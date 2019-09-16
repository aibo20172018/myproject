package com.yb.user.web.controller;

import com.yb.user.pojo.Resources;
import com.yb.user.service.ResourcesService;
import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
@Api(description = "资源模块")
@RestController
@RequestMapping("/resources")
public class  ResourcesController extends BaseController {

    @Autowired
    private ResourcesService resourcesService;

    @ApiOperation(value = "获取所有资源")
    @GetMapping("/listResource.json")
    public BaseRespons<List<Resources>> listResource(){
        return success(resourcesService.listResource());
    }

    @PostMapping("/listResourceByRoleId.json")
    @GetMapping(value = "查询角色拥有资源")
    public BaseRespons<List<Resources>> listResourceByRoleId(Long roleId){
        return success(resourcesService.listResourceByRoleId(roleId));
    }

    @PostMapping("/addResource.json")
    @ApiOperation(value = "新增资源")
    public BaseRespons<String> addResource(Resources resources){
        resourcesService.addResource(resources);
        return success("ok");
    }

    @PostMapping("/deleteResource.json")
    @ApiOperation(value = "根据资源id删除资源")
    public BaseRespons<String> deleteResource(Long resourceId){
        return resourcesService.deleteResource(resourceId);
    }

    @GetMapping("/getResourceById.json")
    @ApiOperation(value = "根据资源id查询资源")
    public BaseRespons<Resources> getResourceById(Long id){
        return success(resourcesService.getResourceById(id));
    }

    @PostMapping("/updateResource.json")
    @ApiOperation(value = "修改资源")
    public BaseRespons updateResource(Resources resources){
        resourcesService.updateResource(resources);
        return success("ok");
    }

    @GetMapping("/listPageResource.json")
    @ApiOperation(value = "分页查询资源")
    public PageResponsVO<Resources> listPageResource(){
        List<Resources> resourcesList = resourcesService.listResource();
        for (int i = 0; i < resourcesList.size() ; i++) {
            if(resourcesList.get(i).getUrl() == null || "".equals(resourcesList.get(i).getUrl())){
                resourcesList.get(i).setType("-1");
                if(resourcesList.get(i).getpId() == null || "".equals(resourcesList.get(i).getpId())){
                    resourcesList.get(i).setpId(-1L);
                }
            }else if("1".equals(resourcesList.get(i).getType())){

            }else{
                resourcesList.get(i).setType("0");
            }
        }
        PageInfo result = new PageInfo();
        result.setTotal(resourcesList.size());
        result.setList(resourcesList);
        return BaseRespons.ok(result);
    }

}
 
