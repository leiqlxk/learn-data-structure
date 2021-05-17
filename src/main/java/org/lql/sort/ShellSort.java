package org.lql.sort;

/**
 * Title: ShellSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 希尔排序 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/17 10:18 <br>
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 2, 4, 7, 1, 3, 9, 8};

        ShellSort.knuthSort(arr);
        ShellSort.print(arr);
    }

    public static void sort(int[] arr) {
        int gap = arr.length / 2;

        for (; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j - gap >= 0 && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }

    }

    public static void knuthSort(int[] arr) {
        int gap = 1;

        while (gap <= arr.length / 3) {
            gap = gap * 3 + 1;
        }

        for (; gap > 0; gap = (gap-1) / 3) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j - gap >= 0 && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
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
