package com.yb.loan.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanInfo;
import com.yb.loan.pojo.vo.FirstTrialLoanVo;
import com.yb.loan.pojo.vo.InspectLoanVo;
import com.yb.loan.pojo.vo.RiskFirstTrialLoanVo;
import com.yb.loan.pojo.vo.RiskReviewLoanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.loan.service.LoanInfoService;
import com.yb.loan.dao.LoanInfoDao;

import java.util.List;


@Service("loanInfoService")
public class LoanInfoServiceImpl extends BaseServiceImpl<LoanInfo> implements LoanInfoService {
	@Autowired
	private LoanInfoDao loanInfoDao;

	@Override
	public BaseDao getBaseDao() {
		return loanInfoDao;
	}

	@Override
	public List<LoanInfo> listPageLoanInfo(LoanInfo loanInfo, Pagination pagination) {
		return loanInfoDao.listPageLoanInfo(loanInfo,pagination);
	}

	@Override
	public List<FirstTrialLoanVo> listPageFirstTrialLoan(FirstTrialLoanVo firstTrialLoanVo, Pagination pagination) {
		return loanInfoDao.listPageFirstTrialLoan(firstTrialLoanVo,pagination);
	}

	@Override
	public List<InspectLoanVo> listPageInspectLoan(InspectLoanVo inspectLoanVo, Pagination pagination) {
		return loanInfoDao.listPageInspectLoan(inspectLoanVo,pagination);
	}

	@Override
	public List<RiskFirstTrialLoanVo> listPageRiskFirstTrialLoanVo(RiskFirstTrialLoanVo riskFirstTrialLoanVo, Pagination pagination) {
		return loanInfoDao.listPageRiskFirstTrialLoanVo(riskFirstTrialLoanVo,pagination);
	}

	@Override
	public List<RiskReviewLoanVo> listPageRiskReviewLoanVo(RiskReviewLoanVo reviewLoanVo, Pagination pagination) {
		return loanInfoDao.listPageRiskReviewLoanVo(reviewLoanVo,pagination);
	}

	@Override
	public int insertLoanInfoByInit(LoanInfo loanInfo) {
		return loanInfoDao.insertLoanInfo(loanInfo);
	}
}
