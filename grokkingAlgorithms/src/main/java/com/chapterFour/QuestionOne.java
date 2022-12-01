package com.chapterFour;

/**
 * @Description sum函数
 * @Author huangxiao
 * @Date 2022-11-27
 */
public class QuestionOne {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        System.out.println(loopSum(array));
        System.out.println(recursionSum(array, array.length - 1));
    }

    /**
     * 遍历方式
     */
    public static int loopSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * 递归方式
     */
    public static int recursionSum(int[] arr, int n) {
        //基线条件
        if (n == 0) {
            return arr[n];
        } else {
            return arr[n] + recursionSum(arr, n - 1);
        }
    }
}
