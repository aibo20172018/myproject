package com.yb.base.utils.base.service.impl;

import java.util.List;
import java.util.Map;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.base.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public  abstract  class BaseServiceImpl <T> implements BaseService<T> {
    public Logger log = LoggerFactory.getLogger(getClass());
    public abstract BaseDao getBaseDao();

    @Override
    public int insert(T entity) {
        return getBaseDao().insert(entity);
    }
    @Override
    public int insert(Map<String, Object> map) {
        return getBaseDao().insert(map);
    }
    @Override
    public int batchInsert(List<T> entities) {
        return getBaseDao().batchInsert(entities);
    }

    @Override
    public int update(Map<String, Object> map) {
        return getBaseDao().update(map);
    }
    @Override
    public int update(T condition) {
        return getBaseDao().update(condition);
    }
    @Override
    public int batchUpdate(List<T> condition) {
        return getBaseDao().batchUpdate(condition);
    }

    @Override
    public int delete(Object condition) {
        return getBaseDao().delete(condition);
    }

    @Override
    public int delete(Map<String, Object> map) {
        return getBaseDao().delete(map);
    }

    @Override
    public int batchDelete(Object[] id) {
        return getBaseDao().batchDelete(id);
    }

    @Override
    public int count(T condition) {
        return getBaseDao().count(condition);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return getBaseDao().queryTotal(map);
    }

    @Override
    public List<T> query(T condition) {
        return getBaseDao().query(condition);
    }

    @Override
    public List<T> queryList(Map<String, Object> map) {
        return getBaseDao().queryList(map);
    }
    @Override
    public T queryObject(Object condition) {
        return  (T) getBaseDao().queryObject(condition);
    }

    @Override
    public T queryObject(Map<String, Object> map) {
        return (T) getBaseDao().queryObject(map);
    }

}