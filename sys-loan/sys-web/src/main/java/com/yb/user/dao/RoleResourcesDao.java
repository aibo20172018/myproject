package com.yb.user.dao;

import com.yb.user.pojo.RoleResources;
import org.apache.ibatis.annotations.Mapper;


/**
 * 
 * 
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
@Mapper
public interface RoleResourcesDao {

    void deleteRoleResources(Long roleId);

    void addRoleResources(RoleResources roleResources);
}
