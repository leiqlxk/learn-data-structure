package org.lql.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Title: DataCheck <br>
 * ProjectName: learn-data-structure <br>
 * description: 验证 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/5/12 23:39 <br>
 */
public class DataCheck {

    public static int[] generateArr(int length) {
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt();
        }

        return arr;
    }

    public static void check() {
        int[] arr = DataCheck.generateArr(10000);
        int[] copyArr = new int[arr.length];
        System.arraycopy(arr, 0, copyArr, 0, arr.length);

        boolean same = true;

        Arrays.sort(arr);
//         SelectionSort.selectionSort(copyArr);

//        SelectionSort.optimSelectionSort(copyArr);

//        BubbleSort.sort(copyArr);

//        BubbleSort.optimSort(copyArr);

        InsertionSort.sort(copyArr);
        for (int i = 0; i < arr.length; i++) {
            same = arr[i] == copyArr[i];
        }

        if (!same) {
            System.out.println("wrong");
        }
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();

        for (int i = 0; i < 500; i++) {
            DataCheck.check();
        }

        long end = System.currentTimeMillis();
        System.out.println("完成时间时间：" + (end - begin) + "(ms)");

    }
}
