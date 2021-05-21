package org.lql.sort;

import java.util.Arrays;

/**
 * Title: CountSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 基数排序   稳定   时间复杂度：O(n+k)  最好最坏都为O(n+k)  空间复杂度：O(n+k) <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/21 9:20 <br>
 */
public class CountSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 2, 4, 7, 1, 3, 9, 8, 3, 4, 6, 2, 6, 1, 8, 7};

        int[] result = CountSort.sort(arr);
        CountSort.print(arr);
        System.out.println();
        CountSort.print(result);
    }

    public static int[] sort(int[] arr) {
        int[] count = new int[10];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        System.out.println(Arrays.toString(count));

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println(Arrays.toString(count));

        for (int i = arr.length - 1; i >= 0; i--) {
            result[--count[arr[i]]] = arr[i];
        }

        return result;
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
