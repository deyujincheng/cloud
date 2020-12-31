package com.ccl.studyserver.InterView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.InterView
 * @Class : BalaceDemo
 * @Description :
 * @CreateDate : 2020-12-30 13:54:47
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class BalaceDemo {

    public static Map<String, Integer> weight = new HashMap<>();
    public static Map<String, Integer> init = new HashMap<>();
    static int all = 0;
    static {
        init.put("a",10);
        init.put("b",15);
        init.put("c",5);

        Set<String> strings = init.keySet();

        for (String k : strings){
            all += init.get(k);
            weight.put(k, init.get(k));
        }
    }

    public String get() {
        String max = getMax();
        for (String key : weight.keySet()) {
            if (key.equals(max)) {
                weight.put(key, weight.get(key) + init.get(key) - all);
            } else {
                weight.put(key, weight.get(key) + init.get(key));
            }
        }
        return max;
    }

    private String getMax() {
        int max = 0;
        String maxKey = "";
        for (Map.Entry<String,Integer> map: weight.entrySet()) {
            if (max < map.getValue()) {
                max = map.getValue();
                maxKey = map.getKey();
            }
        }
        return maxKey;
    }
}
