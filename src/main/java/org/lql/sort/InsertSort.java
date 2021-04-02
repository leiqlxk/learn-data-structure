package org.lql.sort;

/**
 * Title: InsertSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 插入排序 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/2 17:04 <br>
 */
public class InsertSort<E> {

    public static <E extends Comparable<? super E>> void insertSort(E[] a) {
        int j;

        for (int p = 1; p < a.length; p++) {
            E temp = a[p];
            for (j = p; j > 0 && temp.compareTo(a[j-1]) < 0; j--) {
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
    }


    public static void main(String[] args) {
        Integer[]  array = new Integer[] {3, 2, 25, 12, 11, 36, 9};

        InsertSort.insertSort(array);
        for (Integer a : array) {
            System.out.println(a);
        }
    }
}
