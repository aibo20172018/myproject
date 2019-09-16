package com.yb.loan.dao;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanInfo;
import com.yb.loan.pojo.vo.FirstTrialLoanVo;
import com.yb.loan.pojo.vo.InspectLoanVo;
import com.yb.loan.pojo.vo.RiskFirstTrialLoanVo;
import com.yb.loan.pojo.vo.RiskReviewLoanVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 借款申请表
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Mapper
public interface LoanInfoDao extends BaseDao<LoanInfo> {

    List<LoanInfo> listPageLoanInfo(@Param("loanInfo") LoanInfo loanInfo, @Param("pagination") Pagination pagination);

    List<FirstTrialLoanVo> listPageFirstTrialLoan(@Param("loanInfo")FirstTrialLoanVo firstTrialLoanVo, @Param("pagination") Pagination pagination);

    List<InspectLoanVo> listPageInspectLoan(@Param("loanInfo")InspectLoanVo inspectLoanVo, @Param("pagination") Pagination pagination);

    List<RiskFirstTrialLoanVo> listPageRiskFirstTrialLoanVo(@Param("loanInfo")RiskFirstTrialLoanVo riskFirstTrialLoanVo, @Param("pagination") Pagination pagination);

    List<RiskReviewLoanVo> listPageRiskReviewLoanVo(@Param("loanInfo") RiskReviewLoanVo reviewLoanVo, @Param("pagination") Pagination pagination);

    int insertLoanInfo(LoanInfo loanInfo);
}
