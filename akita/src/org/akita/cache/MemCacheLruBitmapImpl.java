/*
 * Copyright 1999-2101 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.akita.cache;


import android.support.v4.util.LruCache;

import java.util.Map;


/**
 * Caution: use this impl on support_v4
 * @author zhe.yangz 2012-3-30 下午03:23:19
 */
public class MemCacheLruBitmapImpl<K, V> implements MemCache<K, V> {

    private LruCache<K, V> mCache = null;

    protected MemCacheLruBitmapImpl(int maxMByteSize){
        mCache = new LruCache<K, V>(maxMByteSize) {
            @Override
            protected int sizeOf(K key, V value) {
                return super.sizeOf(key, value);
            }

            @Override
            protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
                super.entryRemoved(evicted, key, oldValue, newValue);
            }
        };

    }
    
    public V get(K key){
        return mCache.get(key);
    }
    
    public V put(K key, V value) {
        return mCache.put(key, value);
    }
    
    public V remove(K key) {
        return mCache.remove(key);
    }

    @Override
    public void clear() {
        mCache.evictAll();
    }

    public Map<K, V> snapshot() {
        return mCache.snapshot();
    }
}
