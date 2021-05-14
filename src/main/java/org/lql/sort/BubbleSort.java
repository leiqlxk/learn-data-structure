package org.lql.sort;

import javax.xml.stream.FactoryConfigurationError;

/**
 * Title: BubbleSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 冒泡排序  稳定  时间复杂度：O(n*n)  最坏：O(n*n)  最好：O(n)  空间复杂度：O(1)  <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 9:49 <br>
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 2, 4, 7, 1, 3, 9, 8};

        BubbleSort.sort(arr);
        BubbleSort.print(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    BubbleSort.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void optimSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    BubbleSort.swap(arr, j, j + 1);
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
