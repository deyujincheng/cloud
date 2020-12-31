package com.ccl.studyserver.arithmetic.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.other
 * @Class : Balance
 * @Description :
 * @CreateDate : 2020-12-22 17:56:12
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Balance {

    private static Map<String, Integer> ban =  new HashMap<>();
    private static Map<String, Integer> init =  new HashMap<>();
    static int allW = 0;

    static {
        ban.put("a", 1);
        ban.put("b", 5);
        ban.put("c", 3);
        ban.put("d", 26);
        ban.put("e", 4);

        Set<String> strings = ban.keySet();

        for (String k : strings){
            allW += ban.get(k);
            init.put(k, ban.get(k));
        }
    }

    public static void main(String[] args) {

        Set<String> strings2 = ban.keySet();
        for (String k : strings2){
            System.out.println("权重: " + k + ": " + ban.get(k));
        }
        int fc = 0;
        for (Map.Entry<String, Integer> m: ban.entrySet()){
            fc += m.getValue();
        }

        HashMap<String, Integer> count = new HashMap<>();

        for (int i = 0; i < fc; ++ i){
            System.out.println(init);
            String max = balance();
            System.out.print(max + " ");
            Integer c = count.get(max);
            if (c == null){
                count.put(max, 1);
            }else {
                count.put(max, 1 + c);
            }
        }
        System.out.println();

        Set<String> strings1 = count.keySet();
        for (String k : strings1){
            System.out.println("循环" + fc + "次" + k + "出现次数: " + count.get(k));
        }

    }

    private static String balance(){
        String max = getMax();
        for (String k : init.keySet()){
            if (k.equals(max)){
                init.put(k, init.get(k) - allW + ban.get(k));
            }else {
                init.put(k, init.get(k) + ban.get(k));
            }
        }
        return max;
    }

    private static String getMax(){
        String max =  null;
        int maxAllW = 0;
        Set<String> strings = init.keySet();
        for (String k : strings){
            if(maxAllW < init.get(k)){
                max =  k;
                maxAllW = init.get(k);
            }

        }
        return max;
    }
}
