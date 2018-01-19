package com.xin.lemontree.tools.jedis;

/**
 * @author creator mafh 2018/1/19 16:06
 * @author updater mafh
 * @version 1.0.0
 * @description jedis操作工具接口
 */
public interface JedisClient {
    /**
     * 取值
     * @param key 键
     * @return 值
     */
    String get(String key);

    /**
     * 设定值
     * @param key 键
     * @param value 值
     * @return 结果
     */
    String set(String key, String value);

    /**
     *
     * @param hkey
     * @param key
     * @return
     */
    String hget(String hkey, String key);

    /**
     *
     * @param hkey
     * @param key
     * @param value
     * @return
     */
    long hset(String hkey, String key, String value);

    /**
     * 删除
     * @param key 键
     * @return 结果
     */
    long del(String key);

    /**
     *
     * @param hkey
     * @param key
     * @return
     */
    long hdel(String hkey, String key);

    /**
     * 设定结束时间
     * @param key 键
     * @param second 秒
     * @return 结果
     */
    long expire(String key, int second);
}
