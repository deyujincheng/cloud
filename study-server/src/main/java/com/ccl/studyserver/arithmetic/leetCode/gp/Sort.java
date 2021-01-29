package com.ccl.studyserver.arithmetic.leetCode.gp;

import java.util.Comparator;
import java.util.PriorityQueue;

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
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[pos] > array[j]) {
                    pos = j;
                }
            }
            if (pos != i) {
                int temp = array[i];
                array[i] = array[pos];
                array[pos] = temp;
            }
        }
    }
    //快速排序

    public static void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) {
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
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        sort(array, start, right);
        sort(array, left, end);
    }
    //归并排序
    public static void mergeSort(int[] array) {
        int[] temp = new int[array.length];
        mergeSortImpl(array, 0, array.length - 1, temp);
    }
    public static void mergeSortImpl(int[] array, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortImpl(array, start, mid, temp);
        mergeSortImpl(array, mid + 1, end, temp);
        merge(array, start, mid, end, temp);
    }
    public static void merge(int[] array, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (array[left] < array[right]) {
                temp[index++] = array[left++];
            } else {
                temp[index++] = array[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = array[left++];
        }
        while (right <= end) {
            temp[index++] = array[right++];
        }
        for (index = start; index <= end; index++) {
            array[index]= temp[index];
        }
    }
}
