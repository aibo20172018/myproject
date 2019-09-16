package com.yb.base.utils;

import com.yb.base.utils.redis.RedisCacheService;
import com.yb.base.utils.redis.RedisDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class TradePlatformHelper {

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private RedisCacheService cacheService;

    /**
     * 生成流水单号
     * @param tradeDate
     * @return
     */
    public String generateTradeOrderNo(Date tradeDate) {
        String dateNo = DateUtils.formatDate(tradeDate, "yyyyMMdd");
        String tradeOrderNoPrefix = dateNo ;
        String key = CloudApiConstants.CACHE_KEY_TRADE_LOAN_NO_PREFIX + tradeOrderNoPrefix;
        Long index = redisDao.increment(key,1L);
        //设置key超时时间36小时
        if (index == 1) {
            cacheService.expire(key, 25L, TimeUnit.HOURS);
        }
        return tradeOrderNoPrefix + org.apache.commons.lang3.StringUtils.leftPad(index.toString(), 9, "0");
    }

    public String getSpdNoByTradeNo(String merNo) {
        return StringUtils.substring(merNo, 8, 11);
    }

}
