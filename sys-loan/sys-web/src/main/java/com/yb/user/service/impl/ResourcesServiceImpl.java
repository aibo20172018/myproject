package com.yb.user.service.impl;

import com.yb.base.utils.CloudApiConstants;
import com.yb.base.utils.json.JSONUtils;
import com.yb.base.utils.redis.RedisDao;
import com.yb.user.pojo.Resources;
import com.yb.base.utils.base.vo.response.BaseRespons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.yb.user.service.ResourcesService;
import com.yb.user.dao.ResourcesDao;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("resourcesService")
public class ResourcesServiceImpl implements ResourcesService {

	@Autowired
	private ResourcesDao resourcesDao;

	@Autowired
	public RedisDao redisDao;

	@Override
	public List<Resources> listResource(String userName, String type) {
		return resourcesDao.listResourceByUserName(userName,type);
	}

	@Override
	public List<Resources> listResource() {
		String res = redisDao.get(CloudApiConstants.CACHE_KEY_SYS_ALL_RESOURCE);
		if(res != null){
			return JSONUtils.toArray(res,Resources.class);
		}
		List<Resources> list = resourcesDao.listResource();
		redisDao.put(CloudApiConstants.CACHE_KEY_SYS_ALL_RESOURCE,JSONUtils.toJson(list),30, TimeUnit.MINUTES);
		return list;
	}

	@Override
	public List<Resources> listResourceByRoleId(Long roleId) {
		return resourcesDao.listResourceByRoleId(roleId);
	}

	@Override
	public void addResource(Resources resources) {
		resourcesDao.addResource(resources);
	}

	@Override
	public BaseRespons<String> deleteResource(Long resourceId) {
		List<Resources> list = resourcesDao.listChildrenResourceById(resourceId);
		if(list != null && list.size() > 0){
			return BaseRespons.error("500","请删除子节点");
		}else {
			resourcesDao.deleteResource(resourceId);
		}
		return BaseRespons.ok("200","ok");
	}

	@Override
	public void updateResource(Resources resources) {
		resourcesDao.updateResource(resources);
	}

	@Override
	public Resources getResourceById(Long id) {
		return resourcesDao.getResourceById(id);
	}

	@Override
	public List<Resources> queryUserPowerByUserId(String userId) {
		return resourcesDao.queryUserPowerByUserId(userId);
	}
}
