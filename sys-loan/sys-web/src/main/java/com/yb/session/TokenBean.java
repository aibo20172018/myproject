package com.yb.session;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TokenBean implements Serializable {

    public String sessionID;

    public String token;

    private LocalDateTime expireTime;

    private long expire = 60;

    //json的序列化有缺陷。value不要放太复杂的类
    //不建议放太多东西进去
    //如果要放入其它对象，先用json转字符串
    private Map<String, String> attribute = new HashMap<String, String>();

    public TokenBean(int expireIn){
        this.expire = expireIn;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public TokenBean() {
    }

    /**
     * 是否过期
     * @return
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(getExpireTime());
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAttribute(String key) {
        if(key==null || key.trim().equals("")){
            return null;
        }
        return attribute.get(key);
    }

    public void setAttribute(String key, String value) {
        if(key!=null && !key.trim().equals("")){
            attribute.put(key, value);
        }
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public Map<String, String> getAttribute() {
        return attribute;
    }

    public void setAttribute(Map<String, String> attribute) {
        this.attribute = attribute;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
        this.expireTime = LocalDateTime.now().plusSeconds(expire);
    }
}
