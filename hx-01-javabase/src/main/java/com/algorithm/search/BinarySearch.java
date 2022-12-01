package com.algorithm.search;

import java.util.Arrays;

/**
 * @Description 二分查找
 * @Author huangxiao
 * @Date 2022-11-22
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        int arrayTool = binarySearch(array, 5);
        int iteration = binarySearchIteration(array, 5);
        int recursion = binarySearchRecursion(array, 5);
        System.out.println(arrayTool);
        System.out.println(iteration);
        System.out.println(recursion);
    }

    /**
     * Arrays类的binarySearch方法
     * 如果需要查找的数据存在，就返回数组中对应数据的下标值，
     * 如果不存在，返回值为：-（应该插入的位置索引+1）
     *
     * @param array     有序数组
     * @param searchNum 查找的数
     * @return 查找的数的下标
     */
    public static int binarySearch(int[] array, int searchNum) {
        return Arrays.binarySearch(array, searchNum);
    }

    /**
     * 迭代方式
     *
     * @param array     有序数组
     * @param searchNum 查找的数
     * @return 查找的数的下标
     */
    public static int binarySearchIteration(int[] array, int searchNum) {
        // 初始化最小值的索引为0
        int left = 0;
        // 初始化最大值的索引为arr.length-1
        int right = array.length - 1;
        // 首尾相加再除以2得出中间索引
        int mid = (left + right) / 2;
        while (left <= right) { // 确保程序不会重复查询，不会越界
            if (searchNum > array[mid]) {
                // 如果查询的值比中间值大，则往右边区域找，就把最小索引改为中间索引右移一位
                left = mid + 1;
            } else if (searchNum < array[mid]) {
                // 如果查询的值比中间值小，则往左边区域找，就把最大索引改为中间索引左移一位
                right = mid - 1;
            } else {
                // 剩余的情况就是查询到了结果，那么就直接返回索引。
                return mid;
            }
            mid = (left + right) / 2;
        }
        // 没有查询到，则返回-1
        return -1;
    }

    /**
     * 递归方式
     *
     * @param array     有序数组
     * @param searchNum 查找的数
     * @return 查找的数的下标
     */
    public static int binarySearchRecursion(int[] array, int searchNum) {
        // 初始化最小值的索引为0
        int left = 0;
        // 初始化最大值的索引为arr.length-1
        int right = array.length - 1;
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == searchNum) {
            return mid;
        } else if (array[mid] > searchNum) {
            return binarySearchRecursion(array, mid - 1);
        } else {
            return binarySearchRecursion(array, searchNum);
        }
    }
}
