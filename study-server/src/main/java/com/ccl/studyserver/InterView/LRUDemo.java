package com.ccl.studyserver.InterView;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.InterView
 * @Class : LRUDemo
 * @Description :
 * @CreateDate : 2020-12-30 13:37:37
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class LRUDemo {

    LinkedHashMap<Integer, Integer> cache;

    public LRUDemo(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public static void main(String[] args) {
        LRUDemo lruDemo = new LRUDemo(3);
        lruDemo.put(1,1);
        lruDemo.put(2,2);
        lruDemo.put(3,3);
        lruDemo.put(4,4);
        lruDemo.get(3);
        for (Map.Entry<Integer, Integer> map : lruDemo.cache.entrySet()) {
            System.out.println(map.getKey());
        }
    }
}
