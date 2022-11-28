package com.algorithm.sort;


/**
 * @Description 堆排序
 * @Author huangxiao
 * @Date 2022-11-21
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 8, 78, 13, 19, 1, 5, 9,};
        outputArray(array);
        heapSort(array);
        outputArray(array);
    }

    public static void heapSort(int[] array) {
        // 从倒数第一个非叶子节点开始
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            // 从第一天非叶子节点从下至上，从左至右调整结构
            adjustHeap(array, i, array.length);
        }
        // 将堆顶元素与末尾元素交换 将最大元素沉到数组末尾 + 重新调整堆结构
        for (int i = array.length - 1; i > 0; i--) {
            // 交换堆顶元素和末尾元素
            swap(array, 0, i);
            // 交换后的末尾元素忽略(j--) 不再参与堆结构的调整
            // 重新调整堆结构
            adjustHeap(array, 0, i);
        }
    }

    public static void adjustHeap(int[] array, int index, int length) {
        // 取出当前元素
        int temp = array[index];
        // i节点是index节点的左子节点
        for (int i = 2 * index + 1; i < length; i = 2 * i + 1) {
            // 表明左子节点小于右子节点
            if (i + 1 < length && array[i] < array[i + 1]) {
                // 将指针移至较大节点
                i++;
            }
            // 如果子节点大于父节点
            if (array[i] > temp) {
                // 将较大值赋给当前节点
                array[index] = array[i];
                // 指针移向子节点
                index = i;
            } else {
                break;
            }
        }
        // 循环结束，已经将最大值放在了堆顶
        // 将temp值放到最终的位置
        array[index] = temp;
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
