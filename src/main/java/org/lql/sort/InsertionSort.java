package org.lql.sort;

/**
 * Title: InsertionSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 插入排序  稳定  时间复杂度：O(n*n)  最坏：O(n*n)  最好：O(n)  空间复杂度：O(1) <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/14 10:31 <br>
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 2, 4, 7, 1, 3, 9, 8};

        InsertionSort.sort(arr);
        InsertionSort.print(arr);
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    InsertionSort.swap(arr, j - 1 , j);
                }
            }
        }
    }

    public static void optimSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;

            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j -1];
            }
            arr[j] = temp;
        }
    }


    public static void swap(int[] arr, int i, int j) {
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
