package com.yb.user.dao;

import com.yb.base.utils.paging.Pagination;
import com.yb.user.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
@Mapper
public interface RoleDao {

    List<Role> listPageRole(@Param("role") Role role, @Param("pagination") Pagination pagination);

    Role queryRoleByName(String roleName);

    void insertRole(Role role);

    void deleteRole(Long id);

    List<Role> listRole();
}
