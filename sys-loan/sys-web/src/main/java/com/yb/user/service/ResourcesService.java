package com.yb.user.service;


import com.yb.user.pojo.Resources;
import com.yb.base.utils.base.vo.response.BaseRespons;

import java.util.List;

/**
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */

public interface ResourcesService {

    List<Resources> listResource(String userName, String type);

    List<Resources> listResource();

    List<Resources> listResourceByRoleId(Long roleId);

    void addResource(Resources resources);

    BaseRespons<String> deleteResource(Long resourceId);

    void updateResource(Resources resources);

    Resources getResourceById(Long id);

    List<Resources> queryUserPowerByUserId(String userId);
}