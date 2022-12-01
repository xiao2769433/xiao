package com.chapterFour;

/**
 * @Description 找出列表中最大的数字
 * @Author huangxiao
 * @Date 2022-12-01
 */
public class QuestionThree {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        System.out.println(findMax(array, 0, array.length - 1));
    }

    public static int findMax(int[] arr, int leftIndex, int rightIndex) {
        // 基线条件
        if (leftIndex == rightIndex) {
            return arr[leftIndex];
        }
        // 这种方式求得mid不会溢出
        int mid = leftIndex + (rightIndex - leftIndex) / 2;
        int maxLeft = findMax(arr, leftIndex, mid);
        int maxRight = findMax(arr, mid + 1, rightIndex);

        return Math.max(maxLeft, maxRight);
    }
}
