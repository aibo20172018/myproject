package com.yb.department.controller;

import java.util.HashMap;
import java.util.Map;

import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.department.pojo.SysDepRole;
import com.yb.department.service.SysDepRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yb.base.utils.paging.Pagination;




/**
 * 
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "")
@RestController
@RequestMapping("/sysDepRole")
public class  SysDepRoleController {
    @Autowired
	private SysDepRoleService sysDepRoleService;

//    @ApiOperation(value = "分页查询")
//    @PostMapping("/listPageData.json")
//    public PageResponsVO<SysDepRole> listPageData(SysDepRole sysDepRole, Pagination pagination){
//        PageInfo<SysDepRole> result = new PageInfo<>();
//        result.setList(sysDepRoleService.listPageRole(sysDepRole,pagination));
//        result.setTotal(pagination.getTotal());
//        return BaseRespons.ok(result);
//    }
}
 
