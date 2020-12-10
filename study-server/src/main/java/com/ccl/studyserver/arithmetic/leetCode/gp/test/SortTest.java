package com.ccl.studyserver.arithmetic.leetCode.gp.test;

/**
 * @author : chichenglong
 * @version : V0.5
 * @Project : OCHServ
 * @Package : com.ccl.studyserver.arithmetic.leetCode.gp.test
 * @Class : SortTest
 * @Description :
 * @CreateDate : 2020-12-09 13:38:58
 * @Copyright : 2019 dfcx.com Inc. All rights reserved.
 * @Reviewed :
 * @UpateLog :    Name    Date    Reason/Contents
 * ---------------------------------------
 * ****    ****    ****
 */
public class SortTest {

    public static void bubbleSort(int[] array) {
        for (int i = 0; i<array.length;i++) {
            for (int j=0;j<i;j++) {
                if (array[j-1] > array[j]) {
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void insertSort(int[] array) {

        int insertNode;
        int j;
        for (int i=1;i<array.length;i++) {
            insertNode = array[i];
            j = i-1;
            if (j >= 0 && insertNode < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = insertNode;
        }
    }

    public static void fastSort(int[] array, int start, int end) {

        if (start >= end) {
            return;
        }
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        fastSort(array, start, left);
        fastSort(array, right, end);
    }
}
