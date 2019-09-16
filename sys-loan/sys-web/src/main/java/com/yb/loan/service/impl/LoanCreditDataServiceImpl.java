package com.yb.loan.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanCreditData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.loan.service.LoanCreditDataService;
import com.yb.loan.dao.LoanCreditDataDao;

import java.util.List;

@Service("loanCreditDataService")
public class LoanCreditDataServiceImpl extends BaseServiceImpl implements LoanCreditDataService {
	@Autowired
	private LoanCreditDataDao loanCreditDataDao;

	@Override
	public BaseDao getBaseDao() {
		return loanCreditDataDao;
	}

	@Override
	public List<LoanCreditData> listPageLoanCreditData(LoanCreditData loanCreditData, Pagination pagination) {
		return loanCreditDataDao.listPageLoanCreditData(loanCreditData,pagination);
	}
}
