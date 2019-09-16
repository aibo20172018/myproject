package com.yb.user.service.impl;

import com.yb.user.dao.UserRoleDao;
import com.yb.user.pojo.User;
import com.yb.user.pojo.UserRole;
import com.yb.user.pojo.vo.UserVo;
import com.yb.base.utils.paging.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.user.service.UserService;
import com.yb.user.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;


	@Override
	public User queryUserByName(String userName) {
		return userDao.queryUserByName(userName);
	}

	@Override
	public List<UserVo> listPageUser(User user, Pagination pagination) {
		return userDao.listPageUser(user,pagination);
	}

	@Override
	public void addUser(User user, Long roleId) {
		user.setPassWord(user.getPassWord());
		userDao.addUser(user);
		UserRole userRole = new UserRole();
		userRole.setUserId(user.getId());
		userRole.setRoleId(roleId);
		userRoleDao.insert(userRole);
	}

	@Override
	public void deleteUsers(String userIds) {
		String[] ary = userIds.split(",");
		for (String str:ary) {
			deleteUser(Long.parseLong(str));
		}
	}

	@Override
	public void deleteUser(Long userId) {
		userDao.deleteUserById(userId);
		userRoleDao.delete(userId);
	}

	@Override
	public UserVo getUserByID(Long userId) {
		return userDao.queryUserByID(userId);
	}

    @Override
    public void updateUser(UserVo userVo) {
	    User user = new User();
	    user.setId(userVo.getUserId());
	    user.setEmail(userVo.getEmail());
	    user.setPhone(userVo.getPhone());
        userDao.updateUser(user);
        UserRole userRole = new UserRole();
        userRole.setRoleId(userVo.getRoleId());
        userRole.setUserId(userVo.getUserId());
        userRoleDao.update(userRole);
    }

	@Override
	public void updateUserLockStatus(User user) {
		userDao.updateUserLockStatus(user);
	}

//	public static void main(String[] args) {
//		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
////		$2a$10$KM0HkwCyp96ZUWFYPWBacuO2SPO8qCMCLaWy9tlcHi5gonIfmho7W
//		System.out.println(bpe.encode("123456"));
//	}
}
