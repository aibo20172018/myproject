package com.yb.session;

import com.yb.base.utils.json.JSONUtils;
import com.yb.base.utils.redis.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TokenServiceImpl implements TokenService {

    private static String SSO_Session_Prefix ="sso:sessionid:";
    private static String SSO_Token_Prefix ="sso:token:";
    private static String SSO_Lock_Prefix ="sso:lock:";
    private static String SSO_Limit_Prefix = "sso:limit:";

    @Value("${login.limitCount}")
    private String LOGIN_LIMIT_COUNT;

    @Autowired
    private RedisDao redisDao;

    @Override
    public void createSessionBean(String sessionId, TokenBean tokenBean) {
        redisDao.put(SSO_Session_Prefix + sessionId, JSONUtils.objToJson(tokenBean),tokenBean.getExpire(), TimeUnit.SECONDS);
    }

    @Override
    public void updateSessionBean(String sessionId, TokenBean tokenBean) {
        createSessionBean(sessionId, tokenBean);
    }

    @Override
    public void updateSessionBeanAndDeleteOld(String sessionId, TokenBean tokenBean, String oldSessionId) {
        deleteSessionBean(oldSessionId);
        createSessionBean(sessionId,tokenBean);
    }

    @Override
    public boolean updateSessionBeanExpireTime(String sessionId, long expireTime) {
        return false;
    }

    @Override
    public TokenBean getSessionBean(String sessionId) {
        return JSONUtils.jsonToObj(redisDao.get(SSO_Session_Prefix+sessionId), TokenBean.class);
    }

    @Override
    public void deleteSessionBean(String SessionId) {
        redisDao.delete(SSO_Session_Prefix + SessionId);
    }

    @Override
    public boolean trySsoLock(String tokenId) {
        return false;
    }

    @Override
    public void releaseSsoLock(String tokenId) {

    }

    @Override
    public TokenBean getSsoToken(String tokenId) {
        return null;
    }

    @Override
    public String getJsonSsoToken(String tokenId) {
        return null;
    }

    @Override
    public boolean updateSsoTokenExpireTime(String tokenId, long expireTime) {
        return false;
    }

    @Override
    public void deleteSsoToken(String tokenId) {

    }

    @Override
    public Integer updateFailCount(String userCode) {
        Integer count = getFailCount(userCode);
        redisDao.put(SSO_Limit_Prefix + userCode, String.valueOf(++count));
        return count;
    }

    @Override
    public Integer getFailCount(String userCode) {
        String countStr = redisDao.get(SSO_Limit_Prefix + userCode);
        Integer count = countStr != null ? Integer.parseInt(countStr) : 0;
        return count;
    }

    @Override
    public void deleteFailCount(String userCode) {
        redisDao.delete(SSO_Limit_Prefix + userCode);
    }

    @Override
    public boolean isReachLimit(String userCode) {
        return getFailCount(userCode) >= Integer.parseInt(LOGIN_LIMIT_COUNT);
    }
}
