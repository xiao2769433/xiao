package com.algorithm.sort;

/**
 * @Description 选择排序
 * @Author huangxiao
 * @Date 2022-11-21
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {6, 4, 7, 56, 23, -101, -77, -1, 0, 5, 0, 100};
        outputArray(array);
        selectSort(array, 0);
        outputArray(array);
    }

    public static void selectSort(int[] array, int index) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {
                swap(array, i, index);
            }
        }
    }

    /**
     * 交换位置
     */
    public static void swap(int[] sortArray, int start, int end) {
        int temp = sortArray[start];
        sortArray[start] = sortArray[end];
        sortArray[end] = temp;
    }

    /**
     * 数组输出
     */
    public static void outputArray(int[] inputArray) {
        System.out.println("数组遍历输出：");
        for (int value : inputArray) {
            System.out.print(value + "  ");
        }
        System.out.println();
    }
}
