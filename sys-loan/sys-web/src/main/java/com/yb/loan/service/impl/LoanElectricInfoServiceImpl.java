package com.yb.loan.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanElectricInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.loan.service.LoanElectricInfoService;
import com.yb.loan.dao.LoanElectricInfoDao;

import java.util.List;

@Service("loanElectricInfoService")
public class LoanElectricInfoServiceImpl extends BaseServiceImpl implements LoanElectricInfoService {
	@Autowired
	private LoanElectricInfoDao loanElectricInfoDao;

	@Override
	public BaseDao getBaseDao() {
		return loanElectricInfoDao;
	}

	@Override
	public List<LoanElectricInfo> listPageLoanElectricInfo(LoanElectricInfo loanElectricInfo, Pagination pagination) {
		return loanElectricInfoDao.listPageLoanElectricInfo(loanElectricInfo,pagination);
	}
}
