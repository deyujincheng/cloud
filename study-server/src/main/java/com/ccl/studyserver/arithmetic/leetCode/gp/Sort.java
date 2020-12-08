package com.ccl.studyserver.arithmetic.leetCode.gp;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp
 * @Class : Sort
 * @Description : 排序
 * @CreateDate : 2020-12-08 20:23:33
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class Sort {
    /*
    1、复杂度分析
    2、比较和交换字数分析
    3、内存分析
    4、稳定性
     */

    // 冒泡排序
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i< array.length;i++) {
            for (int j = 1;j < i; j++) {
                if (array[j-1] > array[j]) {
                    int tmp = array[j -1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[]  array){
        int insertNode;
        int j;
        for (int i=1; i<array.length;i++) {
            insertNode = array[i];
            j = i-1;
            while (j >= 0 && insertNode < array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = insertNode;
        }
    }

    //选择排序
    //快速排序
    //归并排序
}
