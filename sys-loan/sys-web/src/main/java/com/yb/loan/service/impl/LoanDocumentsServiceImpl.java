package com.yb.loan.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.loan.service.LoanDocumentsService;
import com.yb.loan.dao.LoanDocumentsDao;

import java.util.List;

@Service("loanDocumentsService")
public class LoanDocumentsServiceImpl extends BaseServiceImpl implements LoanDocumentsService {
	@Autowired
	private LoanDocumentsDao loanDocumentsDao;

	@Override
	public BaseDao getBaseDao() {
		return loanDocumentsDao;
	}

	@Override
	public List<LoanDocuments> listPageLoanDocuments(LoanDocuments loanDocuments, Pagination pagination) {
		return loanDocumentsDao.listPageLoanDocuments(loanDocuments,pagination);
	}
}
