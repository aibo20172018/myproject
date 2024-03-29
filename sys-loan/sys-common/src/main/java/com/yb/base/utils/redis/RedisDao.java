package com.yb.base.utils.redis;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisDao implements InitializingBean {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RedisConfig redisConfig;

    private RedisSerializer<?> keySerializer;
    private ValueOperations<String, String> valueOps;
    private HashOperations<String, String, String> hashOps;
    private SetOperations<String, String> setOps;
    private ListOperations<String, String> listOps;
    private ZSetOperations<String, String> zSetOps;


    @Override
    public void afterPropertiesSet() throws Exception {
        this.keySerializer = redisTemplate.getKeySerializer();
        this.valueOps = redisTemplate.opsForValue();
        this.hashOps = redisTemplate.opsForHash();
        this.setOps = redisTemplate.opsForSet();
        this.listOps = redisTemplate.opsForList();
        this.zSetOps = redisTemplate.opsForZSet();
    }

    /**
     * 返回ping值
     *
     * @return
     */
    public String ping() {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.ping();
            }
        });
    }

    /**
     * flush到硬盘
     *
     * @return
     */
    public boolean flushDB() {
        String res = redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "1";
            }
        });
        if ("1".equals(res)) {
            return true;
        }

        return false;
    }

    /**
     * 执行
     *
     * @param redisCallback
     * @return
     */
    public Object execute(RedisCallback<Object> redisCallback) {
        return redisTemplate.execute(redisCallback);
    }

    public List<Object> executePipelined(RedisCallback<List<Object>> pipelineCallback) {
        return redisTemplate.executePipelined(pipelineCallback);
    }

    /**
     * 模糊查询key
     *
     * @param pattern
     * @return
     */
    public Set<String> findKeys(String pattern) {
        return redisTemplate.keys(pattern);
    }


    /*********
     * (1)、Key（键）
     ****************************************/

    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void delete(List keys) {
        redisTemplate.delete(keys);
    }

    public Boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * @param key
     * @return -1表示永久有效，-2表示没有这个对象
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    public Long getExpire(String key, TimeUnit unit) {
        return redisTemplate.getExpire(key, unit);
    }

    public void rename(String key, String newKey) {
        redisTemplate.rename(key, newKey);
    }

    public String type(String key) {
        DataType dt = redisTemplate.type(key);
        return dt.toString();
    }

    /*********
     * (2)、String（字符串）
     ****************************************/
    public long increment(String key, long offset) {
        return valueOps.increment(key, offset);
    }

    public double increment(String key, double offset) {
        return valueOps.increment(key, offset);
    }

    /*-------------valueOps put ------------*/
    public void put(String key, String value) {
        valueOps.set(key, value);
    }

    public void put(String key, String value, long timeout, TimeUnit unit) {
        valueOps.set(key, value, timeout, unit);
    }

    public void putKeepTTL(String key, String value) {
        Long expire = redisTemplate.getExpire(key, TimeUnit.NANOSECONDS);
        if (expire > 0) {
            valueOps.set(key, value, expire, TimeUnit.NANOSECONDS);
        } else {
            valueOps.set(key, value);
        }
    }

    public void putMulti(Map<String, String> data) {

        valueOps.multiSet(data);
    }

    public Boolean putIfAbsent(String key, String value) {
        Boolean isPutSuccess = valueOps.setIfAbsent(key, value);
        setExpire(isPutSuccess, key);    //12小时有效时间
        return isPutSuccess;
    }

    public Boolean putIfAbsent(String key, String value, Integer expire) {
        Boolean isPutSuccess = valueOps.setIfAbsent(key, value);
        setExpire(isPutSuccess, key, expire);    //12小时有效时间
        return isPutSuccess;
    }

    public Boolean putMultiIfAbsent(Map<String, String> data) {
        return valueOps.multiSetIfAbsent(data);
    }

    /*-------------valueOps get ------------*/
    public String get(String key) {
        return valueOps.get(key);
    }

    public List<String> getMulti(Collection<String> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return valueOps.multiGet(keys);
    }


    /*********
     * (3)、Hash（哈希表 ）
     ****************************************/

    public Long hashSize(String key) {
        return hashOps.size(key);
    }

    public Map<String, String> hashEntries(String key) {
        return hashOps.entries(key);
    }

    public Set<String> hashKeys(String key) {
        return hashOps.keys(key);
    }

    public List<String> hashValues(String key) {
        return hashOps.values(key);
    }

    public Boolean hashHasKey(String key, String hashKey) {
        return hashOps.hasKey(key, hashKey);
    }

    public Long hashDelete(String key, String hashKey) {
        return hashOps.delete(key, hashKey);
    }

    public String hashGet(String key, String hashKey) {
        return hashOps.get(key, hashKey);
    }

    public List<String> hashGetMulti(String key, Collection<String> hashKeys) {
        return hashOps.multiGet(key, hashKeys);
    }

    public void hashPut(String key, String hashKey, String value) {
        hashOps.put(key, hashKey, value);
    }

    public Boolean hashPutIfAbsent(String key, String hashKey, String value) {
        Boolean isPutSuccess = hashOps.putIfAbsent(key, hashKey, value);
        setExpire(isPutSuccess, key);    //设置12小时有效时间
        return isPutSuccess;
    }

    public void hashPutAllOfString(String key, Map<String, String> valueMap) {
        hashOps.putAll(key, valueMap);
    }

    public Long listSize(String key) {
        return listOps.size(key);
    }

    public void listSetIndex(String key, long index, String value) {
        listOps.set(key, index, value);
    }

    public Long listRemove(String key, long i, String value) {
        return listOps.remove(key, i, value);
    }

    public void listTrim(String key, long start, long end) {
        listOps.trim(key, start, end);
    }

    public List<String> listRange(String key, long start, long end) {
        return listOps.range(key, start, end);
    }


    public Long listLeftPush(String key, String value) {
        return listOps.leftPush(key, value);
    }

    public Long listLeftPushIfPresent(String key, String value) {
        return listOps.leftPushIfPresent(key, value);
    }

    public String listLeftPop(String key) {
        return listOps.leftPop(key);
    }

    public String listRightPop(String key) {
        return listOps.rightPop(key);
    }

    public String listRightPopAndLeftPush(String key, String newKey) {
        return listOps.rightPopAndLeftPush(key, newKey);
    }

    public String listRightPopAndLeftPush(String key, String newKey, long timeout, TimeUnit unit) {
        return listOps.rightPopAndLeftPush(key, newKey, timeout, unit);
    }

    /*********
     * (5)、Set（集合）
     ****************************************/

    public Long setSize(String key) {
        return setOps.size(key);
    }

    public void setAdd(String key, String obj) {
        setOps.add(key, obj);
    }

    public Set<String> setMembers(String key) {
        return setOps.members(key);
    }

    public Boolean setIsMember(String key, String value) {
        return setOps.isMember(key, value);
    }

    public Long setRemove(String key, String value) {
        return setOps.remove(key, value);
    }


    /*********
     * (6)、ZSet（有序集合）
     ****************************************/

    public Long zsetSize(String key) {
        return zSetOps.size(key);
    }

    public void zsetClear(String key) {
        zSetOps.removeRange(key, 0, zSetOps.size(key));
    }

    public void zsetAdd(String key, String obj, double score) {
        zSetOps.add(key, obj, score);
    }

    public void zsetAdd(String key, Set<ZSetOperations.TypedTuple<String>> tuples) {
        zSetOps.add(key, tuples);
    }

    public Set<String> zsetGetRange(String key, long start, long end) {
        return zSetOps.range(key, start, end);
    }

    public Set<String> zsetGetRevRange(String key, long start, long end) {
        return zSetOps.reverseRange(key, start, end);
    }

    public Long zsetRemove(String key, String obj) {
        return zSetOps.remove(key, obj);
    }

    public Long zsetRank(String key, String obj) {
        return zSetOps.rank(key, obj);
    }

    public Double zsetScore(String key, String obj) {
        return zSetOps.score(key, obj);
    }

    public void setExpire(Boolean isPutSuccess, String key) {
        Integer expiration = redisConfig.getDefaultExpiration();
        if (isPutSuccess && expiration > 0) {
            redisTemplate.expire(key, expiration, TimeUnit.HOURS);
        }
    }

    public void setExpire(Boolean isPutSuccess, String key, Integer expire) {
        if (expire == null) {
            setExpire(isPutSuccess, key);
            return;
        }

        if (isPutSuccess) {
            redisTemplate.expire(key, expire, TimeUnit.MINUTES);
        }


    }
}
