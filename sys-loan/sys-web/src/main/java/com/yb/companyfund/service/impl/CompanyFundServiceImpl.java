package com.yb.companyfund.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.companyfund.dao.CompanyFundDao;
import com.yb.companyfund.pojo.CompanyFund;
import com.yb.companyfund.service.CompanyFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("companyFundService")
public class CompanyFundServiceImpl extends BaseServiceImpl implements CompanyFundService {
	@Autowired
	private CompanyFundDao companyFundDao;

	@Override
	public BaseDao getBaseDao() {
		return companyFundDao;
	}

	@Override
	public List<CompanyFund> listPageCompanyFund(CompanyFund companyFund, Pagination pagination) {
		return companyFundDao.listPageCompanyFund(companyFund,pagination);
	}
}
