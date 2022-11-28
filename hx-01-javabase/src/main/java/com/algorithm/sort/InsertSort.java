package com.algorithm.sort;

/**
 * @Description 插入排序
 * @Author huangxiao
 * @Date 2022-11-21
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {6, 4, 7, 56, 23, -101, -77, -1, 0, 5, 0, 100};
        outputArray(array);
        insertSort(array);
        outputArray(array);
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    // array[j+1]=tmp;
                    break;
                }
            }
            array[j + 1] = temp;
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
}
