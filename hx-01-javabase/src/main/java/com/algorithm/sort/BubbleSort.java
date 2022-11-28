package com.algorithm.sort;

/**
 * @Description 冒泡排序
 * @Author huangxiao
 * @Date 2022-11-16
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] sortArray = {10, 23, 11, 56, 45, 26, 59, 28, 84, 79, 1, 5, 3, 89, 45, 26, 23, 11};
        outputArray(sortArray);

        bubbleSort(sortArray);

        outputArray(sortArray);
    }

    /**
     *
     */
    public static void bubbleSort(int[] sortArray) {
        for (int i = 0; i < sortArray.length - 1; i++) {
            for (int j = 0; j < sortArray.length - i - 1; j++) {
                if (JudgeSize(sortArray[j], sortArray[j + 1])) {
                    changePosition(j, sortArray);
                }
            }
        }
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

    /**
     * 数组输出
     */
    public static void outputArray(int[] inputArray, int num) {
        System.out.println("第" + num + "次输出数组：");
        for (int value : inputArray) {
            System.out.print(value + "  ");
        }
        System.out.println();
    }

    /**
     * 判断大小
     */
    public static boolean JudgeSize(int num1, int num2) {
        return num1 > num2;
    }

    /**
     * 交换位置
     */
    public static int[] changePosition(int num, int[] sortArray) {
        int temp = sortArray[num];
        sortArray[num] = sortArray[num + 1];
        sortArray[num + 1] = temp;
        return sortArray;
    }
}
