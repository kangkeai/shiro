package com.imooc.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.Collection;
import java.util.Set;

/**
 * @Author: GZM
 * @Date: 23:03 2018/6/11
 */
public class ShiroSprinfCache<K,V> implements Cache<K,V> {

    @Override
    public V get(K key) throws CacheException {
        return null;
    }

    @Override
    public V put(K key, V value) throws CacheException {
        return null;
    }

    @Override
    public V remove(K key) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
