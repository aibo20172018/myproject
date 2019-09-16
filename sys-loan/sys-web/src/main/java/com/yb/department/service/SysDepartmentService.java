package com.yb.department.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.department.pojo.SysDepartment;

import java.util.List;


/**
 * 
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */

public interface SysDepartmentService extends BaseService{

    List<SysDepartment> listPageSysDepartment(SysDepartment sysDepartment, Pagination pagination);
}