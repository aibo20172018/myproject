package com.yb.loan.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.RepaymentPlans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.loan.service.RepaymentPlansService;
import com.yb.loan.dao.RepaymentPlansDao;

import java.util.List;

@Service("repaymentPlansService")
public class RepaymentPlansServiceImpl extends BaseServiceImpl implements RepaymentPlansService {
	@Autowired
	private RepaymentPlansDao repaymentPlansDao;

	@Override
	public BaseDao getBaseDao() {
		return repaymentPlansDao;
	}

	@Override
	public List<RepaymentPlans> listPageRepaymentPlans(RepaymentPlans repaymentPlans, Pagination pagination) {
		return repaymentPlansDao.listPageRepaymentPlans(repaymentPlans,pagination);
	}
}
