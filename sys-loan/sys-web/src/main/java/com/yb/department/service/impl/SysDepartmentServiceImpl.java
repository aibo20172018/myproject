package com.yb.department.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.base.utils.paging.Pagination;
import com.yb.department.dao.SysDepartmentDao;
import com.yb.department.pojo.SysDepartment;
import com.yb.department.service.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysDepartmentService")
public class SysDepartmentServiceImpl extends BaseServiceImpl implements SysDepartmentService {
	@Autowired
	private SysDepartmentDao sysDepartmentDao;

	@Override
	public BaseDao getBaseDao() {
		return sysDepartmentDao;
	}

	@Override
	public List<SysDepartment> listPageSysDepartment(SysDepartment sysDepartment, Pagination pagination) {
		return sysDepartmentDao.listPageSysDepartment(sysDepartment,pagination);
	}
}
