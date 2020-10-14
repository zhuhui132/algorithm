package com.leetcode.algorithm.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConfig {
    private static JedisPool pool = null;

    public static JedisPool getPool() {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(500);
            config.setMaxIdle(5);
            config.setMaxWaitMillis(1000 * 10);
            //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(true);
            //new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
            pool = new JedisPool(config, "116.196.89.151", 6379, 10000, "Root1357");

        }
        return pool;
    }

    public synchronized static Jedis getResource() {
        if (pool == null) {
            pool = getPool();
        }
        return pool.getResource();
    }
}