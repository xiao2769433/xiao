package com.chapterFour;

/**
 * @Description 递归计算列表包含的元素数
 * @Author huangxiao
 * @Date 2022-12-01
 */
public class QuestionTwo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        System.out.println(countNumbers(array, array.length - 1));
    }

    /*
     * 计算列表所包含的元素数
     */
    public static int countNumbers(int[] arr, int n) {
        //判断数组是否为空
        if (arr.length == 0) {
            return 0;
        }
        //基线条件
        else if (n == 0) {
            return 1;
        } else {
            return 1 + countNumbers(arr, n - 1);
        }
    }
}

