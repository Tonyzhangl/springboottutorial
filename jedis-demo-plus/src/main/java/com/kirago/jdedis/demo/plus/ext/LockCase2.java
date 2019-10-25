package com.kirago.jdedis.demo.plus.ext;

import com.kirago.jdedis.demo.plus.core.RedisLock;
import redis.clients.jedis.Jedis;

import static com.kirago.jdedis.demo.plus.constant.LockConstants.NOT_EXIST;
import static com.kirago.jdedis.demo.plus.constant.LockConstants.OK;
import static com.kirago.jdedis.demo.plus.constant.LockConstants.SECONDS;

/**
 * 这时又出现一个问题，问题出现的步骤如下
 *
 * 客户端A获取锁成功，过期时间30秒。
 * 客户端A在某个操作上阻塞了50秒。
 * 30秒时间到了，锁自动释放了。
 * 客户端B获取到了对应同一个资源的锁。
 * 客户端A从阻塞中恢复过来，释放掉了客户端B持有的锁。
 */
public class LockCase2 extends RedisLock {

    public LockCase2(Jedis jedis,String lockKey) {
        super(jedis,lockKey);
    }

    @Override
    public void lock() {
        while (true) {
            String result = jedis.set(lockKey, "value", NOT_EXIST, SECONDS, 30);
            if (OK.equals(result)) {
                System.out.println(Thread.currentThread().getId() + "加锁成功!");
                break;
            }
        }
    }

    @Override
    public void unlock() {
        jedis.del(lockKey);
    }
}
