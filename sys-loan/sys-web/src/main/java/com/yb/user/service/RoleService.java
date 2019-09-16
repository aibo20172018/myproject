package com.yb.user.service;


import com.yb.user.pojo.Role;
import com.yb.user.pojo.RoleResources;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.paging.Pagination;

import java.util.List;

/**
 * 
 * 
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */

public interface RoleService {

    List<Role> listPageRole(Role role, Pagination pagination);

    void updateRole(List<RoleResources> roleResources);

    BaseRespons insertRole(String roleName, String pers);

    void deleteRole(Long roleId);

    void deleteRoles(String roleIds);

    List<Role> listRole();
}