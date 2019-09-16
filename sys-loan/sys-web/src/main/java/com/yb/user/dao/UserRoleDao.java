package com.yb.user.dao;

import com.yb.user.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
@Mapper
public interface UserRoleDao {

    void insert(UserRole userRole);

    void delete(Long userId);

    void update(UserRole userRole);
}
