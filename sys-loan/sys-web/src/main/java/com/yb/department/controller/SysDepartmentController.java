package com.yb.department.controller;


import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.department.pojo.SysDepartment;
import com.yb.department.service.SysDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/sysDepartment")
public class  SysDepartmentController {
    @Autowired
	private SysDepartmentService sysDepartmentService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<SysDepartment> listPageData(SysDepartment sysDepartment, Pagination pagination){
        PageInfo<SysDepartment> result = new PageInfo<>();
        result.setList(sysDepartmentService.listPageSysDepartment(sysDepartment,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
