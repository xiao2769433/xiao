package com.algorithm.sort;

/**
 * @Description 快速排序
 * @Author huangxiao
 * @Date 2022-11-21
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {6, 4, 7, 56, 23, -101, -77, -1, 0, 5, 0, 100};
        outputArray(array);
        quickSort(array, 0, array.length - 1);
        outputArray(array);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        // 先求出基准数的下标
        int index = sort(array, left, right);
        if (index != 0) {
            // 对基准数左边递归
            quickSort(array, left, index - 1);
            // 对基准数右边递归
            quickSort(array, index + 1, right);
        }
    }

    /**
     * left，左边界.
     * right,右边界.范围array.length-1
     */
    public static int sort(int[] array, int start, int end) {
        // 找出一个基准数,使得左边的数<=基准数,基准数>=右边的数,返回此基准数下标
        // 假设第一个数就是基准数
        int s = start;
        while (start < end) {
            // 从右边开始找到小于等于基准数的
            while (start < end && array[end] > array[s]) {
                end--;
            }
            // 从左边开始找到大于基准数的
            while (start < end && array[s] >= array[start]) {
                start++;
            }
            // end>start 说明小于等于基准数还在右边,大于基准数的在左边,两两交换即可
            if (end > start) {
                swap(array, start, end);
            }
        }
        swap(array, s, start);
        return start;
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
