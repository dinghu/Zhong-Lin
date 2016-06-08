package com.lidroid.xutils.util.core;

import java.util.*;

public class LruMemoryCache<K, V>
{
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private KeyExpiryMap<K, Long> keyExpiryMap;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;
    
    public LruMemoryCache(final int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
        this.keyExpiryMap = new KeyExpiryMap<K, Long>(0, 0.75f);
    }
    
    private int safeSizeOf(final K k, final V v) {
        final int size = this.sizeOf(k, v);
        if (size <= 0) {
            this.size = 0;
            for (final Map.Entry<K, V> entry : this.map.entrySet()) {
                this.size += this.sizeOf(entry.getKey(), (V)entry.getValue());
            }
        }
        return size;
    }
    
    private void trimToSize(final int n) {
        while (true) {
            synchronized (this) {
                if (this.size <= n || this.map.isEmpty()) {
                    return;
                }
                final Map.Entry<K, V> entry = this.map.entrySet().iterator().next();
                final K key = entry.getKey();
                final V value = entry.getValue();
                this.map.remove(key);
                this.keyExpiryMap.remove(key);
                this.size -= this.safeSizeOf(key, value);
                ++this.evictionCount;
                // monitorexit(this)
                this.entryRemoved(true, key, value, null);
            }
        }
    }
    
    public final boolean containsKey(final K k) {
        return this.map.containsKey(k);
    }
    
    protected V create(final K k) {
        return null;
    }
    
    public final int createCount() {
        synchronized (this) {
            return this.createCount;
        }
    }
    
    protected void entryRemoved(final boolean b, final K k, final V v, final V v2) {
    }
    
    public final void evictAll() {
        this.trimToSize(-1);
        this.keyExpiryMap.clear();
    }
    
    public final int evictionCount() {
        synchronized (this) {
            return this.evictionCount;
        }
    }
    
    public final V get(final K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        if (!this.keyExpiryMap.containsKey(k)) {
            this.remove(k);
            return null;
        }
        synchronized (this) {
            final V value = this.map.get(k);
            if (value != null) {
                ++this.hitCount;
                return value;
            }
        }
        ++this.missCount;
        // monitorexit(this)
        final K i;
        final Object create = this.create(i);
        if (create == null) {
            return null;
        }
        synchronized (this) {
            ++this.createCount;
            final V put = this.map.put(i, (V)create);
            if (put != null) {
                this.map.put(i, put);
            }
            else {
                this.size += this.safeSizeOf(i, (V)create);
            }
            // monitorexit(this)
            if (put != null) {
                this.entryRemoved(false, i, (V)create, put);
                return put;
            }
        }
        this.trimToSize(this.maxSize);
        return (V)create;
    }
    
    public final int hitCount() {
        synchronized (this) {
            return this.hitCount;
        }
    }
    
    public final int maxSize() {
        synchronized (this) {
            return this.maxSize;
        }
    }
    
    public final int missCount() {
        synchronized (this) {
            return this.missCount;
        }
    }
    
    public final V put(final K k, final V v) {
        return this.put(k, v, Long.MAX_VALUE);
    }
    
    public final V put(final K k, final V v, final long n) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            ++this.putCount;
            this.size += this.safeSizeOf(k, v);
            final V put = this.map.put(k, v);
            this.keyExpiryMap.put(k, Long.valueOf(n));
            if (put != null) {
                this.size -= this.safeSizeOf(k, put);
            }
            // monitorexit(this)
            if (put != null) {
                this.entryRemoved(false, k, put, v);
            }
            this.trimToSize(this.maxSize);
            return put;
        }
    }
    
    public final int putCount() {
        synchronized (this) {
            return this.putCount;
        }
    }
    
    public final V remove(final K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            final V remove = this.map.remove(k);
            this.keyExpiryMap.remove(k);
            if (remove != null) {
                this.size -= this.safeSizeOf(k, remove);
            }
            // monitorexit(this)
            if (remove != null) {
                this.entryRemoved(false, k, remove, null);
            }
            return remove;
        }
    }
    
    public void setMaxSize(final int maxSize) {
        this.trimToSize(this.maxSize = maxSize);
    }
    
    public final int size() {
        synchronized (this) {
            return this.size;
        }
    }
    
    protected int sizeOf(final K k, final V v) {
        return 1;
    }
    
    public final Map<K, V> snapshot() {
        synchronized (this) {
            return new LinkedHashMap<K, V>((Map<? extends K, ? extends V>)this.map);
        }
    }
    
    @Override
    public final String toString() {
        int n = 0;
        synchronized (this) {
            final int n2 = this.hitCount + this.missCount;
            if (n2 != 0) {
                n = this.hitCount * 100 / n2;
            }
            return String.format("LruMemoryCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", this.maxSize, this.hitCount, this.missCount, n);
        }
    }
}
