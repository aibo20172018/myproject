package com.yb.loan.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanSixdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.loan.service.LoanSixdataService;
import com.yb.loan.dao.LoanSixdataDao;

import java.util.List;

@Service("loanSixdataService")
public class LoanSixdataServiceImpl extends BaseServiceImpl implements LoanSixdataService {
	@Autowired
	private LoanSixdataDao loanSixdataDao;

	@Override
	public BaseDao getBaseDao() {
		return loanSixdataDao;
	}

	@Override
	public List<LoanSixdata> listPageLoanSixdata(LoanSixdata loanSixdata, Pagination pagination) {
		return loanSixdataDao.listPageLoanSixdata(loanSixdata,pagination);
	}
}
