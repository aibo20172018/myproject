package com.yb.user.service;


import com.yb.user.pojo.User;
import com.yb.user.pojo.vo.UserVo;
import com.yb.base.utils.paging.Pagination;


import java.util.List;

/**
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */

public interface UserService{

    User queryUserByName(String userName);

    List<UserVo> listPageUser(User user, Pagination pagination);

    void addUser(User user, Long roleId);

    void deleteUsers(String userIds);

    void deleteUser(Long userId);

    UserVo getUserByID(Long userId);

    void updateUser(UserVo userVo);

    void updateUserLockStatus(User user);

}