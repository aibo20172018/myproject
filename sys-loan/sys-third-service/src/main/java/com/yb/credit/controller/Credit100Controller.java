package com.yb.credit.controller;

import com.alibaba.fastjson.JSONObject;
import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.http.HttpHelper;
import com.yb.base.utils.http.HttpParam;
import com.yb.base.utils.md5.Md5SignUtils;
import com.yb.base.utils.redis.RedisDao;
import org.apache.http.client.config.RequestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/credit100")
public class Credit100Controller extends BaseController {

    private final static String CACHE_KEY_TOKEN = "CREDIT_100_CREDIT_TOKEN";

    @Autowired
    private RedisDao redisDao;

    @Value("credit.url")
    private String url;

    @Value("credit.userName")
    private String userName;

    @Value("credit.password")
    private String password;

    @Value("credit.apiCode")
    private String apiCode;

    private String getToken(){
        JSONObject param = new JSONObject();
        param.put("userName",userName);
        param.put("password", password);
        param.put("apiCode",apiCode);
        HttpParam requestParam = new HttpParam("百融征信获取token发送", url+"/bankServer2/user/login.action",map2HttpParam(param));
        requestParam.setRequestConfig(
                RequestConfig.custom().setSocketTimeout(5000).setConnectionRequestTimeout(5000).build());
        requestParam.setContentType("application/x-www-form-urlencoded;charset=utf-8");
        String respResult = HttpHelper.request(requestParam);
        if(respResult  != null){
            JSONObject jsonObject = JSONObject.parseObject(respResult);
            if("00".equals(jsonObject.getString("code"))){
                String tokenid = jsonObject.getString("tokenid");
                redisDao.put(CACHE_KEY_TOKEN,tokenid,60, TimeUnit.MINUTES);
                return tokenid;
            }
        }
        return null;
    }




    /**
     * DTA_BR0000041
     * 特殊名单序号
     * 参数	类型	是否必填
     * 1	id	string	是
     * 2	cell	string	是
     * 3	name	string	是
     * 4	linkman_cell	string	否
     * 5	time_range	string	否 客户提供的匹配key值。取值：N，单位：年；填入相应数字表示查询最近几年的特殊名单服务，未填或填入其它数字表示默认查询所有时间段的标签
     *
     * STR_BR0000131
     * 1	id	string	是	身份证号
     * 2	cell	string	是	手机号
     * 3	name	string	是	姓名
     * 4	linkman_cell	string	否	联系人手机号
     * 5	time_range	string	否	时间范围 客户提供的匹配key值。取值：1-5，单位：年；填入相应数字表示查询最近几年的特殊名单服务，未填或填入其它数字表示默认查询5年
     *
     * @return
     */
    public BaseRespons strategyApi(String strategyId,String idCard,
                                   String mobile,String name,
                                   String linkmanMobile,String timeRange){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("apiCode",apiCode);
        String tokenId = redisDao.get(CACHE_KEY_TOKEN);
        jsonObject.put("tokenid", tokenId ==null? getToken():tokenId);
        jsonObject.put("apiName", "strategyApi");
        JSONObject jsonData = new JSONObject();
        jsonData.put("strategy_id", strategyId);
        jsonData.put("id",idCard);
        jsonData.put("cell",mobile);
        jsonData.put("name",name);
        if(linkmanMobile != null){
            jsonData.put("linkman_cell",linkmanMobile);
        }
        if(timeRange != null){
            jsonData.put("time_range",timeRange);
        }
        jsonObject.put("jsonData",jsonData);
        jsonObject.put("checkCode",Md5SignUtils.md5(jsonData.toString()+ Md5SignUtils.md5(jsonObject.getString("apiCode")+jsonObject.getString("tokenid"))));

        HttpParam requestParam = new HttpParam("百融征信strategyApi发送", url+"/strategyApi/v1/hxQuery",map2HttpParam(jsonObject));
        requestParam.setRequestConfig(
                RequestConfig.custom().setSocketTimeout(5000).setConnectionRequestTimeout(5000).build());
        requestParam.setContentType("application/x-www-form-urlencoded;charset=utf-8");
        String respResult = HttpHelper.request(requestParam);
        if(respResult != null){
            JSONObject json = JSONObject.parseObject(respResult);
            String code = json.getString("code");
            if("100007".equals(code)){
                redisDao.delete(CACHE_KEY_TOKEN);
                strategyApi(strategyId,idCard,mobile,name,linkmanMobile,timeRange);
            }else if("00".equals(code)) {
                return success(json);
            }else {
                return RRException(code,"服务商异常");
            }
        }
        return RRException("500","请求异常");
    }

    /**
     * MCP_BR0000060
     * id	string	是	身份证号	客户提供的匹配key值
     * cell	string	是	手机号	客户提供的匹配key值
     * name	string	是	姓名	客户提供的匹配key值
     * bank_id	string	是	银行卡号	客户提供的匹配key值，包括借记卡和信用卡
     *
     * DTV_BR0000029
     * id	string	是	身份证号
     * cell	string	是	手机号
     * name	string	是	姓名
     * bank_id	string	是	银行卡号
     */
    public BaseRespons infoverifyApi(String strategyId,String idCard,
                                   String mobile,String name,
                                   String bankNo){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("apiCode",apiCode);
        String tokenId = redisDao.get(CACHE_KEY_TOKEN);
        jsonObject.put("tokenid", tokenId ==null? getToken():tokenId);
        jsonObject.put("apiName", "verificationApi");//验证
        JSONObject jsonData = new JSONObject();
        jsonData.put("conf_id",strategyId);//验证策略编号
        jsonData.put("id",idCard);
        jsonData.put("cell",mobile);
        jsonData.put("name",name);
        jsonData.put("bank_id",bankNo);
        jsonObject.put("jsonData",jsonData);
        jsonObject.put("checkCode",Md5SignUtils.md5(jsonData.toString()+ Md5SignUtils.md5(jsonObject.getString("apiCode")+jsonObject.getString("tokenid"))));

        HttpParam requestParam = new HttpParam("百融征信strategyApi发送", url+"/infoverify/v1/info_verify",map2HttpParam(jsonObject));
        requestParam.setRequestConfig(
                RequestConfig.custom().setSocketTimeout(5000).setConnectionRequestTimeout(5000).build());
        requestParam.setContentType("application/x-www-form-urlencoded;charset=utf-8");
        String respResult = HttpHelper.request(requestParam);
        if(respResult != null){
            JSONObject json = JSONObject.parseObject(respResult);
            String code = json.getString("code");
            if("100007".equals(code)){
                redisDao.delete(CACHE_KEY_TOKEN);
                infoverifyApi(strategyId,idCard,mobile,name,bankNo);
            }else if("00".equals(code)) {
                return success(json);
            }else {
                return RRException(code,"服务商异常");
            }
        }
        return RRException("500","请求异常");
    }

    private String map2HttpParam(JSONObject param) {
        StringBuffer sb = new StringBuffer();
        boolean isFirst = true;
        for (Map.Entry entry : param.entrySet()) {
            if (isFirst) {
                isFirst = false;
            } else {
                sb.append("&");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }
}
