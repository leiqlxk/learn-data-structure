package org.lql.sort;

import java.lang.reflect.WildcardType;

/**
 * Title: MergeSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 归并排序：将一个数组分成两部分别排序，再递归比较两个数组各个位置的数组
 * 大小，小的插入到第三个数组中 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/6 10:50 <br>
 */
public class MergeSort {

    private static <E extends Comparable<? super E>> void mergeSort(E[] a, E[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tempArray, left, center);
            mergeSort(a, tempArray, center + 1, right);
            merge(a, tempArray, left, center + 1, right);
        }
    }

    private static <E extends Comparable<? super E>> void merge(E[] a, E[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int temPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tempArray[temPos++] = a[leftPos++];
            }else {
                tempArray[temPos++] = a[rightEnd++];
            }
        }

        while (leftPos <= leftEnd) {
            tempArray[temPos++] = a[rightPos++];
        }

        while (rightPos <= rightEnd) {
            tempArray[temPos++] = a[rightPos];
        }

        //把数据copy回去
        for (int i = 0; i < numElements; i++,rightEnd--) {
            a[rightEnd] = tempArray[rightEnd];
        }
    }

    public static <E extends Comparable<? super E>> void mergeSort(E[] a) {
        E[] tempArray = (E[])new Comparable[a.length];

        mergeSort(a, tempArray, 0, a.length - 1);
    }
}
