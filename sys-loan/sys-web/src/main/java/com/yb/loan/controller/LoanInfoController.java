package com.yb.loan.controller;

import com.yb.base.utils.CloudApiConstants;
import com.yb.base.utils.TradePlatformHelper;
import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.base.utils.redis.RedisDao;
import com.yb.loan.pojo.LoanInfo;
import com.yb.loan.pojo.vo.*;
import com.yb.loan.service.LoanInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yb.base.utils.paging.Pagination;

import java.util.Date;


/**
 * 借款申请表
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "借款申请模块")
@RestController
@RequestMapping("/loanInfo")
public class  LoanInfoController extends BaseController {
    @Autowired
	private LoanInfoService loanInfoService;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private TradePlatformHelper platformHelper;

    @ApiOperation(value = "准入审核列表查询")
    @GetMapping("/listPageFirstTrialLoan.json")
    public PageResponsVO<FirstTrialLoanVo> listPageData(FirstTrialLoanVo loanInfo, Pagination pagination){
        PageInfo<FirstTrialLoanVo> result = new PageInfo<>();
        result.setList(loanInfoService.listPageFirstTrialLoan(loanInfo,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }

    @ApiOperation(value = "现场考察订单列表")
    @GetMapping("/listPageInspectLoan.json")
    public PageResponsVO<InspectLoanVo> listPageData(InspectLoanVo loanInfo, Pagination pagination){
        PageInfo<InspectLoanVo> result = new PageInfo<>();
        result.setList(loanInfoService.listPageInspectLoan(loanInfo,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }

    @ApiOperation(value = "风控初审列表")
    @GetMapping("/listPageRiskFirstTrialLoan.json")
    public PageResponsVO<RiskFirstTrialLoanVo> listPageData(RiskFirstTrialLoanVo loanInfo, Pagination pagination){
        PageInfo<RiskFirstTrialLoanVo> result = new PageInfo<>();
        result.setList(loanInfoService.listPageRiskFirstTrialLoanVo(loanInfo,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }

    @ApiOperation(value = "风控复审列表")
    @GetMapping("/listPageRiskReviewLoan.json")
    public PageResponsVO<RiskReviewLoanVo> listPageData(RiskReviewLoanVo loanInfo, Pagination pagination){
        PageInfo<RiskReviewLoanVo> result = new PageInfo<>();
        result.setList(loanInfoService.listPageRiskReviewLoanVo(loanInfo,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }

    @ApiOperation(value = "拒绝订单")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "query", dataType = "String", name = "loanNo", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "remark", value = "拒绝原因", required = true)})
    @PostMapping("/updateExamResult.json")
    public BaseRespons updateExamResult(String loanNo,String remark){
        LoanInfo loanInfo = loanInfoService.queryObject(loanNo);
        String status = loanInfo.getStatus();
        if(loanInfo != null){
            String refusalRemark = "";
            switch (status){
                case "4" : refusalRemark = "准入核实";break;
                case "8" : refusalRemark = "风控初审";break;
                case "12" : refusalRemark = "风控复审";
            }
            if("".equals(refusalRemark)){
                return RRException("500","当前订单状态不允许拒绝");
            }
            loanInfo.setRefusalRemark(refusalRemark + "拒绝" + remark);
            loanInfo.setExamResult("2");
            loanInfoService.update(loanInfo);
            return success("ok");
        }
        return RRException("500","修改记录不存在");
    }

    @ApiOperation(value = "通用编辑申请表接口",notes = "为空的属性则为不修改，修改操作时 loanNo不能为空")
    @PostMapping("/updateLoanInfo.json")
    public BaseRespons updateLoanInfo(LoanInfo loanInfo){
        loanInfo.setStatus("4");

        //补充人
        loanInfo.setSupplyId(1L);
        loanInfo.setSupplyTime(new Date());
        int result = loanInfoService.update(loanInfo);
        if(result == 1){
            return success("ok");
        }
        return RRException("500","error");
    }

    @ApiOperation(value = "申请表录单")
    @PostMapping("/insertLoanInfo.json")
    public BaseRespons insertLoanInfo(LoanInfoVo loanInfoVo){
//        String code = redisDao.get(CloudApiConstants.CACHE_KEY_SMS_CODE_PREFIX + loanInfoVo.getMobile());
        String code = "1234";
        if((loanInfoVo.getCode().toLowerCase()).equals(code.toLowerCase())){
            LoanInfo loanInfo = new LoanInfo();
            Date date = new Date();
            loanInfo.setLoanNo(platformHelper.generateTradeOrderNo(date));
            loanInfo.setNewDate(DateUtils.formatDate(date, "yyyyMMdd"));
            loanInfo.setCreateTime(date);
            loanInfo.setCompanyName(loanInfoVo.getCompanyName());
            loanInfo.setControllName(loanInfoVo.getControllName());
            loanInfo.setSellArea(loanInfoVo.getSellArea());
            loanInfo.setSellName(loanInfoVo.getSellArea());
            loanInfo.setMobile(loanInfoVo.getMobile());
            int result = loanInfoService.insertLoanInfoByInit(loanInfo);
            if(result == 1){
                return success("成功");
            }
        }else {
            return RRException("500","验证码不正确");
        }
        return  RRException("500","失败");
    }
}
 
