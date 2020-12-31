package com.ccl.studyserver.arithmetic.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.lru
 * @Class : LRUCache
 * @Description : LRU算法
 * @CreateDate : 2020-12-03 13:55:17
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        ConcurrentHashMap mapa = new ConcurrentHashMap();
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.put(5,5);
        lruCache.get(3);
        for(Map.Entry<Integer, Integer> entry : lruCache.cache.entrySet()) {
            System.out.println(entry.getKey() + " " +entry.getValue());
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(1, (o1, o2) -> o2 - o1);
        queue.add(1);
        queue.add(2);
    }
}
