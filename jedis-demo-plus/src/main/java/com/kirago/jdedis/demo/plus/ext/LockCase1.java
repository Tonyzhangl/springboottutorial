package com.kirago.jdedis.demo.plus.ext;

import com.kirago.jdedis.demo.plus.core.RedisLock;
import redis.clients.jedis.Jedis;

import static com.kirago.jdedis.demo.plus.constant.LockConstants.NOT_EXIST;
import static com.kirago.jdedis.demo.plus.constant.LockConstants.OK;

/**
 * 此种场景会出现客户端A所在服务器异常之后A所拿到的锁一直存在导致其他服务一直无法拿到锁
 */
public class LockCase1 extends RedisLock {

    public LockCase1(Jedis jedis,String lockKey) {
        super(jedis, lockKey);
    }

    @Override
    public void lock() {
        while(true){
            String result = jedis.set(lockKey, "value", NOT_EXIST);
            if(OK.equals(result)){
                System.out.println(Thread.currentThread().getId()+"加锁成功!");
                break;
            }
        }
    }

    @Override
    public void unlock() {
        jedis.del(lockKey);
    }

}
