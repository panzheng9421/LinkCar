package com.linkcar.user.utils;

import com.linkcar.common.utils.RedisConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类，用来存储和读取对象
 */
@Component
public class RedisUtils {

    protected static Logger log = LoggerFactory.getLogger(RedisUtils.class);

    @Resource
    @Qualifier("stringRedisTemplate")
    private RedisTemplate<String, String> stringRedisTemplate;

    @Resource
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 存放字符串，默认24小时
     *
     * @param key
     * @param value
     */
    public boolean setString(String key, String value) {
        try {
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            ops.set(key, value, RedisConstants.EXPIRE_24_HOURS, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            log.error("Redis异常：" + e);
            return false;
        }

    }

    /**
     * 存放字符串
     *
     * @param key
     * @param value
     * @param time  时间
     */
    public boolean setString(String key, String value, Long time) {
        try {
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            ops.set(key, value, time, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            log.error("Redis异常：" + e);
            return false;
        }
    }

    /**
     * 获取字符串
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        try {
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            return ops.get(key);
        } catch (Exception e) {
            log.error("Redis异常：" + e);
            return null;
        }
    }

    /**
     * 删除字符串
     *
     * @param key
     * @return
     */
    public boolean delString(String key) {
        try {
            stringRedisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            log.error("Redis异常：" + e);
            return false;
        }
    }

    /**
     * 存入对象，默认存放24小时
     *
     * @param key
     * @param object
     */
    public boolean setObject(String key, Object object) {
        try {
            redisTemplate.opsForValue().set(key, object, RedisConstants.EXPIRE_24_HOURS,
                    TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            log.error("Redis异常：" + e);
            return false;
        }
    }

    /**
     * 存入对象，指定时间
     *
     * @param key
     * @param object
     * @param timeNumber
     */
    public boolean setObject(String key, Object object, Long timeNumber) {
        try {
            redisTemplate.opsForValue().set(key, object, timeNumber, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            log.error("Redis异常：" + e);
            return false;
        }
    }

    /**
     * 获取对象
     *
     * @param key
     * @return
     */
    public Object getObject(String key) {
        try {
            Object object = redisTemplate.opsForValue().get(key);
            return object;
        } catch (Exception e) {
            log.error("Redis异常：" + e);
            return null;
        }
    }

    /**
     * 删除对象
     *
     * @param key
     */
    public boolean deleteByKey(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            log.error("Redis异常：" + e);
            return false;
        }
    }

    /**
     * 设置过期时间对象属性
     *
     * @param key
     * @param seconds
     */
    public boolean expireObject(String key, long seconds) {
        try {
            redisTemplate.expire(key, seconds, TimeUnit.MINUTES);
            return true;
        } catch (Exception e) {
            log.error("Redis异常：" + e);
            return false;
        }
    }

    /**
     * 删除对象
     *
     * @param key
     */
    public boolean delObject(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            log.error("Redis异常：" + e);
            return false;
        }
    }

}
