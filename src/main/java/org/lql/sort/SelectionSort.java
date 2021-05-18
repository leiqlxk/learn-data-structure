package org.lql.sort;

/**
 * Title: SelectionSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 选择排序   不稳定   时间复杂度：O(n^2) 最好：O(n^2) 最坏：O(n^2) 空间复杂度：O(1) <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 23:25 <br>
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {6, 5, 2, 4, 7, 1, 3, 9, 8};

        SelectionSort.selectionSort(arr);
//        SelectionSort.optimSelectionSort(arr);
        SelectionSort.print(arr);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }

            SelectionSort.swap(arr, i, minPos);
            /*SelectionSort.print(arr);
            System.out.println();*/
        }
    }

    public static void optimSelectionSort(int[] arr) {
        int left, right;
        left = 0;
        right = arr.length - 1;

        int minPos = left;
        int maxPos = right;

        while (left < right) {
            minPos = left;
            maxPos = right;

            for (int j = left; j <= right; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }

                if (arr[j] > arr[maxPos]) {
                    maxPos = j;
                }
            }

            if (minPos == left && maxPos == right) {
                // 就是原本位置，什么都不做
            }else if (minPos == right && maxPos == left) {
                // 就是头尾两个位置，交换一次即可
                SelectionSort.swap(arr, minPos, left);
            }else {
                // 交换两次
                SelectionSort.swap(arr, minPos, left);
                SelectionSort.swap(arr, maxPos, right);
            }

            // left和right向中间移动
            left++;
            right--;
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
