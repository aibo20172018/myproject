package com.yb.loan.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoansCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.loan.service.LoansCoreService;
import com.yb.loan.dao.LoansCoreDao;

import java.util.List;

@Service("loansCoreService")
public class LoansCoreServiceImpl extends BaseServiceImpl implements LoansCoreService {
	@Autowired
	private LoansCoreDao loansCoreDao;

	@Override
	public BaseDao getBaseDao() {
		return loansCoreDao;
	}

	@Override
	public List<LoansCore> listPageLoansCore(LoansCore loansCore, Pagination pagination) {
		return loansCoreDao.listPageLoansCore(loansCore,pagination);
	}
}
