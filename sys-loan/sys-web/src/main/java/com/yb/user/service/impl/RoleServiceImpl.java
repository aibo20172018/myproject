package com.yb.user.service.impl;

import com.yb.user.dao.RoleResourcesDao;
import com.yb.user.pojo.Role;
import com.yb.user.pojo.RoleResources;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.user.service.RoleService;
import com.yb.user.dao.RoleDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private RoleResourcesDao roleResourcesDao;

	@Override
	public List<Role> listPageRole(Role role, Pagination pagination) {
		return roleDao.listPageRole(role,pagination);
	}

	@Override
	public void updateRole(List<RoleResources> roleResources) {
		roleResourcesDao.deleteRoleResources(roleResources.get(0).getRoleId());
		for (RoleResources r:roleResources) {
			roleResourcesDao.addRoleResources(r);
		}
	}

	@Override
	public BaseRespons insertRole(String roleName, String pers) {
		Role role = roleDao.queryRoleByName(roleName);
		if(role != null){
			return BaseRespons.error("500","角色已存在");
		}

		role = new Role();
		role.setRoleName(roleName);
		roleDao.insertRole(role);
		String[] ary = pers.split(",");

		for (String perid:ary) {
			RoleResources resources = new RoleResources();
			resources.setRoleId(role.getId());
			resources.setResourcesId(Long.parseLong(perid));
			roleResourcesDao.addRoleResources(resources);
		}
		return BaseRespons.ok("200","ok");
	}

	@Override
	public void deleteRole(Long roleId) {
		roleDao.deleteRole(roleId);
		roleResourcesDao.deleteRoleResources(roleId);
	}

	@Override
	public void deleteRoles(String roleIds) {
		String[] ary = roleIds.split(",");
		for (String str:ary) {
			deleteRole(Long.parseLong(str));
		}
	}

	@Override
	public List<Role> listRole() {
		return roleDao.listRole();
	}
}
