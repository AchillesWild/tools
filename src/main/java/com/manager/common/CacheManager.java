package com.manager.common;

public interface CacheManager {

    boolean lock(String key,int seconds);

    boolean unLock(String key);
}
