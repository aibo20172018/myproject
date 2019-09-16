package com.yb.department.dao;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.paging.Pagination;
import com.yb.department.pojo.SysDepartment;
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
public interface SysDepartmentDao extends BaseDao {

    List<SysDepartment> listPageSysDepartment(@Param("sysDepartment") SysDepartment sysDepartment, @Param("pagination") Pagination pagination);
}
