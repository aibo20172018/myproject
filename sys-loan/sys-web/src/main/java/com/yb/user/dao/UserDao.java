package com.yb.user.dao;

import com.yb.user.pojo.User;
import com.yb.user.pojo.vo.UserVo;
import com.yb.base.utils.paging.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
@Mapper
public interface UserDao {

    User queryUserByName(String userName);

    List<UserVo> listPageUser(@Param("user") User user, @Param("pagination") Pagination pagination);

    void addUser(User user);

    void deleteUserById(Long userId);

    UserVo queryUserByID(Long userId);

    void updateUser(User user);

    void updateUserLockStatus(User user);
}
