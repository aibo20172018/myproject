package com.yb.companyfund.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.companyfund.dao.CompanyFundCountDao;
import com.yb.companyfund.pojo.CompanyFundCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.loan.service.CompanyFundCountService;

import java.util.List;

@Service("companyFundCountService")
public class CompanyFundCountServiceImpl extends BaseServiceImpl implements CompanyFundCountService {
	@Autowired
	private CompanyFundCountDao companyFundCountDao;

	@Override
	public BaseDao getBaseDao() {
		return companyFundCountDao;
	}

	@Override
	public List<CompanyFundCount> listPageCompanyFundCount(CompanyFundCount companyFundCount, Pagination pagination) {
		return companyFundCountDao.listPageCompanyFundCount(companyFundCount,pagination);
	}
}
