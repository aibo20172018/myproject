package com.yb.user.web.controller;


import com.yb.user.pojo.Role;
import com.yb.user.pojo.RoleResources;
import com.yb.user.service.RoleService;
import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.base.utils.paging.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
@Api(description = "角色模块")
@RestController
@RequestMapping("/role")
public class  RoleController extends BaseController {

	@Autowired
	private RoleService roleService;

	/**
	 * 分页获取角色列表
	 * @param role
	 * @param pagination
	 * @return
	 */
	@ApiOperation(value = "分页查询角色")
	@GetMapping("/listRoleData.json")
	public PageResponsVO<Role> listRoleData(Role role, Pagination pagination){
		PageInfo<Role> result = new PageInfo<>();
		result.setList(roleService.listPageRole(role,pagination));
		result.setTotal(pagination.getTotal());
		return BaseRespons.ok(result);
	}

	@ApiOperation(value = "获取所有角色")
	@GetMapping("/listRole.json")
	public List<Role> listRole(){
		return roleService.listRole();
	}

	@PostMapping("/addRole.json")
	@ApiOperation(value = "添加角色")
	@ApiImplicitParams({
	@ApiImplicitParam(paramType = "query", dataType = "String", name = "pers", value = "资源id用“,”隔开", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "roleName", value = "角色名称", required = true)})
	public BaseRespons addRole(String roleName, String pers){
		return success(roleService.insertRole(roleName,pers));
	}

	@PostMapping("/updateRole.json")
	@ApiOperation(value = "修改角色")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "pers", value = "资源id用“,”隔开", required = true),
			@ApiImplicitParam(paramType = "query", dataType = "String", name = "roleId", value = "角色id", required = true)})
	public BaseRespons updateRole(Long roleId,String pers){
	    List<RoleResources> roleResources = new ArrayList<>();
	    String[] ary = pers.split(",");
        for (String perid:ary) {
            RoleResources resources = new RoleResources();
            resources.setRoleId(roleId);
            resources.setResourcesId(Long.parseLong(perid));
            roleResources.add(resources);
        }
        roleService.updateRole(roleResources);
		return null;
	}

	@PostMapping("/deleteRole.json")
	@ApiOperation(value = "删除角色")
	public BaseRespons deleteRole(Long roleId){
		roleService.deleteRole(roleId);
		return null;
	}

	@ApiOperation(value = "批量删除角色")
	@PostMapping("/deleteRoles.json")
	public BaseRespons deleteRoles(String roleIds){
		roleService.deleteRoles(roleIds);
		return null;
	}

}
 
