package org.lql.sort;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.Arrays;

/**
 * Title: RadixSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 基数排序  稳定  时间复杂度：O(n*k) 空间复杂度：O(n+k)<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/21 10:09 <br>
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {421, 324, 454, 326, 124, 344, 2, 12, 54, 1211, 3564};

        int highestBit = RadixSort.getHighestBit(arr);
        System.out.println(highestBit);
        System.out.println(Arrays.toString(arr));

        int[] result = RadixSort.sort(arr, highestBit);
        System.out.println(Arrays.toString(result));
    }

    public static int getHighestBit(int[] arr) {
        int h = 0;

        for (int i = 0; i < arr.length; i++) {
            int temp = (arr[i] + "").length();
            h = Math.max(temp, h);
        }

        return h;
    }

    public static int[] sort(int[] arr, int highestBit) {
        int[] count = new int[10];
        int[] result = new int[arr.length];

        for (int i = 0; i < highestBit; i++) {
            int division = (int) Math.pow(10, i);

            for (int j = 0; j <arr.length; j++) {
                int num = arr[j] / division % 10;

                count[num]++;
            }

            System.out.println(Arrays.toString(count));

            for (int m = 1; m < count.length; m++) {
                count[m] = count[m] + count[m - 1];
            }

            for (int n = arr.length - 1; n >= 0; n--) {
                int num = arr[n] / division % 10;
                result[--count[num]] = arr[n];
            }

            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }
        return result;
    }
}
