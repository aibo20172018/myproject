package com.yb.department.dao;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.paging.Pagination;
import com.yb.department.pojo.SysDepRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Mapper
public interface SysDepRoleDao extends BaseDao {

    List<SysDepRole> listPageSysDepRole(@Param("sysDepRole") SysDepRole sysDepRole, @Param("pagination") Pagination pagination);
}
