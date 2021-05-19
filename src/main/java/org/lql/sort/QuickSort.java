package org.lql.sort;

/**
 * Title: QuickSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 快速排序  不稳定  时间复杂度：O(nlog₂n)  最坏：O(n^2)  最好：O(nlog₂n)  空间复杂度：O(log₂n) <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/19 10:24 <br>
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 2, 4, 7, 1, 3, 9, 8};

        QuickSort.sort(arr, 0, arr.length - 1);

        QuickSort.print(arr);
    }

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }

        int mid = QuickSort.partition(arr, leftBound, rightBound);
        // 左分区
        QuickSort.sort(arr, leftBound, mid - 1);
        // 右分区
        QuickSort.sort(arr, mid + 1, rightBound);
    }

    public static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound - 1;

        while (left <= right) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }

            while (left <= right && arr[right] > pivot) {
                right--;
            }

            if (left < right) {
                QuickSort.swap(arr, left, right);
            }
        }

        QuickSort.swap(arr, left, rightBound);

        return left;
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
