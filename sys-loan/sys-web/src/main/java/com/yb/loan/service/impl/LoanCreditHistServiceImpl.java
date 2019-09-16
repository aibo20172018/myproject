package com.yb.loan.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanCreditHist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.loan.service.LoanCreditHistService;
import com.yb.loan.dao.LoanCreditHistDao;

import java.util.List;

@Service("loanCreditHistService")
public class LoanCreditHistServiceImpl extends BaseServiceImpl implements LoanCreditHistService {
	@Autowired
	private LoanCreditHistDao loanCreditHistDao;

	@Override
	public BaseDao getBaseDao() {
		return loanCreditHistDao;
	}

	@Override
	public List<LoanCreditHist> listPageLoanCreditHist(LoanCreditHist loanCreditHist, Pagination pagination) {
		return loanCreditHistDao.listPageLoanCreditHist(loanCreditHist,pagination);
	}
}
