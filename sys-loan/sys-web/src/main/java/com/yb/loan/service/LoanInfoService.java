package com.yb.loan.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanInfo;
import com.yb.loan.pojo.vo.*;

import java.util.List;


/**
 * 借款申请表
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */

public interface LoanInfoService extends BaseService<LoanInfo>{

    List<LoanInfo> listPageLoanInfo(LoanInfo loanInfo, Pagination pagination);

    List<FirstTrialLoanVo> listPageFirstTrialLoan(FirstTrialLoanVo firstTrialLoanVo,Pagination pagination);

    List<InspectLoanVo> listPageInspectLoan(InspectLoanVo inspectLoanVo, Pagination pagination);

    List<RiskFirstTrialLoanVo> listPageRiskFirstTrialLoanVo(RiskFirstTrialLoanVo riskFirstTrialLoanVo, Pagination pagination);

    List<RiskReviewLoanVo> listPageRiskReviewLoanVo(RiskReviewLoanVo reviewLoanVo, Pagination pagination);

    int insertLoanInfoByInit(LoanInfo loanInfo);
}