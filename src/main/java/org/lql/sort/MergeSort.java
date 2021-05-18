package org.lql.sort;

import java.util.zip.Inflater;

/**
 * Title: MergeSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 归并排序  稳定  时间复杂度：O(nlog₂n) 最好和最坏都是O(nlog₂n)  空间复杂度：O(n) <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/18 10:03 <br>
 */
public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {1, 3, 6, 7, 2, 4, 5};
        int[] arr = {6, 5, 2, 4, 7, 1, 3, 9, 8};
        MergeSort.merge(arr, 0, arr.length - 1);

        MergeSort.print(arr);
    }

    public static void merge(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }

        // 分成两半
        int mid = (left + right) / 2;
        // 左边排序
        MergeSort.merge(arr, left, mid);
        //右边排序
        MergeSort.merge(arr, mid + 1, right);

        MergeSort.sort(arr, left, mid, right);
    }

    public static void sort(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr;
        int[] temp = new int[rightBound - leftPtr + 1];
        int i = leftPtr;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= rightBound) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j < rightBound + 1) {
            temp[k++] = arr[j++];
        }

        k = 0;
        while (leftPtr <= rightBound) {
            arr[leftPtr++] = temp[k++];
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
