package com.yb.department.service.impl;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.impl.BaseServiceImpl;
import com.yb.department.dao.SysDepRoleDao;
import com.yb.department.service.SysDepRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysDepRoleService")
public class SysDepRoleServiceImpl extends BaseServiceImpl implements SysDepRoleService {
	@Autowired
	private SysDepRoleDao sysDepRoleDao;

	@Override
	public BaseDao getBaseDao() {
		return sysDepRoleDao;
	}
}
