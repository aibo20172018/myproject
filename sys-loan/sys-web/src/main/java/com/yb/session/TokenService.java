package com.yb.session;

public interface TokenService {
    /**
     * 保存 sessionBean
     * @param sessionId
     */
    void createSessionBean(String sessionId, TokenBean tokenBean);

    void updateSessionBean(String sessionId, TokenBean tokenBean);

    void updateSessionBeanAndDeleteOld(String sessionId, TokenBean tokenBean, String oldSessionId);

    /**
     * 更新sessionBean的存活时间
     * @param sessionId
     * @param expireTime 毫秒
     */
    boolean updateSessionBeanExpireTime(String sessionId, long expireTime);
    /**
     * 获取 sessionBean
     * @param sessionId
     * @return
     */
    TokenBean getSessionBean(String sessionId);

    /**
     * 删除 sessionBean
     * @param SessionId
     */
    void deleteSessionBean(String SessionId);

    /**
     *  获取锁
     * @param tokenId
     * @return
     */
    boolean trySsoLock(String tokenId);

    /**
     * 释放锁
     * @param tokenId
     */
    void releaseSsoLock(String tokenId);

    /**
     *  获取token对象
     * @param tokenId
     * @return
     */
    TokenBean getSsoToken(String tokenId);

    /**
     * 获取token对象的String
     * @param tokenId
     * @return
     */
    String getJsonSsoToken(String tokenId);


    /**
     * 更新失效时间
     * @param tokenId
     * @param expireTime
     * @return
     */
    boolean updateSsoTokenExpireTime(String tokenId, long expireTime);

    /**
     * 删除token对象
     * @param tokenId
     */
    void deleteSsoToken(String tokenId);

    /**
     * 更新密码错误次数
     * @param userCode
     * @return 当前错误次数
     */
    Integer updateFailCount(String userCode);

    /**
     * @param userCode
     * @return 获取当前密码错误次数
     */
    Integer getFailCount(String userCode);

    /**
     * 清除Redis中的密码错误次数
     * @param userCode
     */
    void deleteFailCount(String userCode);

    /**
     * 判断是否达到错误次数上限
     * @param userCode
     * @return
     */
    boolean isReachLimit(String userCode);
}