package com.yb.base.utils.base.controller;

import java.lang.reflect.Field;
import java.util.List;

import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.exception.APPExCode;
import com.yb.base.utils.paging.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseController {

    public Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BaseRespons baseRespons;

    public BaseRespons success(List list) {
        baseRespons.setData(BaseRespons.ok(list));
        return baseRespons;
    }
    public BaseRespons success(PageInfo pageInfo) {
        baseRespons.setData(BaseRespons.ok(pageInfo));
        return baseRespons;
    }
    public BaseRespons success(String str) {
        baseRespons.setData((str));
        return baseRespons;
    }
    public BaseRespons success(Object object) {
        baseRespons.setData(BaseRespons.ok(object));
        return baseRespons;
    }
    public BaseRespons RRException (String code,String mgs) {
        return  BaseRespons.RRException(code, mgs);
    }
    public BaseRespons defaultError (Exception e) {
        e.printStackTrace();
        return  BaseRespons.error(APPExCode.SYS_UNKNOWN_ERROR.getErrorCode(),APPExCode.SYS_UNKNOWN_ERROR.getErrorMsg());
    }
    public BaseRespons userDefinedError (String code,String mgs) {
        return  BaseRespons.error(code, mgs);
    }
    public  boolean checkObjFieldIsNull(Object obj) throws IllegalAccessException {

        boolean flag = false;
        for(Field f : obj.getClass().getDeclaredFields()){
            f.setAccessible(true);

            if(f.get(obj) == null){
                flag = true;
                return flag;
            }
        }
        return flag;
    }
}

