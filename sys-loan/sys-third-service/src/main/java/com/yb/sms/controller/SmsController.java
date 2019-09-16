package com.yb.sms.controller;

import com.alibaba.fastjson.JSONObject;
import com.yb.base.utils.CloudApiConstants;
import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.http.HttpHelper;
import com.yb.base.utils.http.HttpParam;
import com.yb.base.utils.redis.RedisDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Api(description = "短信消息发送")
@RestController
@RequestMapping("/sms")
public class SmsController extends BaseController {

    @Value("${sms.dhyt.account}")
    private String account;

    @Value("${sms.dhyt.password}")
    private String password;

    @Value("${sms.dhyt.sign}")
    private String sign;

    @Value("${sms.dhyt.url}")
    private String url;

    @Autowired
    private RedisDao redisDao;

    @ApiOperation("发送手机短信")
    @PostMapping("/senSms.json")
    public BaseRespons senSms(String phone){
        if(phone == null || phone.length() != 11){
            return RRException("500","手机格式不对");
        }
        String dateNo = DateUtils.formatDate(new Date(), "yyyyMMdd");
        String key = CloudApiConstants.CACHE_KEY_SMS_PHONE_NUM_PREFIX + dateNo + ":" + phone;
        String countStr = redisDao.get(key);
        Integer count = countStr != null ? Integer.parseInt(countStr) : 0;
        if(count >=3){
            return RRException("500","发送短信超过上限，请明天再试");
        }

        String code = generateVerifyCode(6);
        JSONObject param = new JSONObject();
        param.put("phones",phone);
        param.put("msgid", UUID.randomUUID().toString().replaceAll("-",""));
        param.put("account",account);
        param.put("password",password);
        param.put("content","短信验证码:"+code);
        param.put("sign",sign);
        HttpParam requestParam = new HttpParam("大汉三通短信发送", url+"/json/sms/Submit",param.toString());
        requestParam.setRequestConfig(
                RequestConfig.custom().setSocketTimeout(5000).setConnectionRequestTimeout(5000).build());
        String respResult = HttpHelper.request(requestParam);

        if(respResult != null){
            JSONObject resJson = JSONObject.parseObject(respResult);
            if("0".equals(resJson.getString("result"))){
                log.info("{}发送短信验证码success:{}",phone,code);
                redisDao.put(key,String.valueOf(++count),24,TimeUnit.HOURS);
                redisDao.put(CloudApiConstants.CACHE_KEY_SMS_CODE_PREFIX + phone, code,5, TimeUnit.MINUTES);
                return success("ok");
            }
            return RRException("500",resJson.getString("desc"));
        }
        return RRException("500","发送失败");
    }


    public static final String VERIFY_CODES = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    /**
     * 使用系统默认字符源生成验证码
     * @param verifySize    验证码长度
     * @return
     */
    public static String generateVerifyCode(int verifySize){
        return generateVerifyCode(verifySize, VERIFY_CODES);
    }
    /**
     * 使用指定源生成验证码
     * @param verifySize    验证码长度
     * @param sources   验证码字符源
     * @return
     */
    public static String generateVerifyCode(int verifySize, String sources){
        if(sources == null || sources.length() == 0){
            sources = VERIFY_CODES;
        }
        int codesLen = sources.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for(int i = 0; i < verifySize; i++){
            verifyCode.append(sources.charAt(rand.nextInt(codesLen-1)));
        }
        return verifyCode.toString();
    }
}
