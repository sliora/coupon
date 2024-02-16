package org.example.couponcore.component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Log4j2
@RequiredArgsConstructor
@Component
public class DistributeLockExecutor {
    private final RedissonClient redissonClient;

    public void execute(String lockName, long waitMilliSecond, long leaseMilliSecond, Runnable logic) {
        RLock lock = redissonClient.getLock(lockName);
        try {
            boolean isLocked = lock.tryLock(waitMilliSecond, leaseMilliSecond, TimeUnit.MILLISECONDS);
            if(!isLocked) {
                throw new IllegalStateException("[" + lockName + "] lock 획득 실패");
            }
            logic.run();
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } finally {
          if(lock.isHeldByCurrentThread()) {
              lock.unlock();
          }
        }
    }
}
