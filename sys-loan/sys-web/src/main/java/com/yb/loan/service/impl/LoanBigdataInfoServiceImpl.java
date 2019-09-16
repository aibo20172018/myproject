package com.yb.loan.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanBigdataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.loan.service.LoanBigdataInfoService;
import com.yb.loan.dao.LoanBigdataInfoDao;

import java.util.List;

@Service("loanBigdataInfoService")
public class LoanBigdataInfoServiceImpl extends BaseServiceImpl implements LoanBigdataInfoService {
	@Autowired
	private LoanBigdataInfoDao loanBigdataInfoDao;

	@Override
	public BaseDao getBaseDao() {
		return loanBigdataInfoDao;
	}

	@Override
	public List<LoanBigdataInfo> listPageLoanBigdataInfo(LoanBigdataInfo loanBigdataInfo, Pagination pagination) {
		return loanBigdataInfoDao.listPageLoanBigdataInfo(loanBigdataInfo,pagination);
	}
}
