package com.yb.user.dao;

import com.yb.user.pojo.Resources;
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
public interface ResourcesDao {

    List<Resources> listResourceByUserName(@Param("userName") String userName, @Param("type") String type);

    List<Resources> listResource();

    List<Resources> listResourceByRoleId(Long roleId);

    List<Resources> listChildrenResourceById(Long id);

    Resources getResourceById(Long id);

    void addResource(Resources resources);

    void deleteResource(Long resourceId);

    void updateResource(Resources resources);

    List<Resources> queryUserPowerByUserId(String userId);
}
