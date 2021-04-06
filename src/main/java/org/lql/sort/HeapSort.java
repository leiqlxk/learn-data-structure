package org.lql.sort;

/**
 * Title: HeapSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 堆排序 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/6 10:32 <br>
 */
public class HeapSort {

    /**
     * description: 小标从0开始，所以左儿子变成了2i + 1 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/4/6 10:34 <br>
     *
     * @throws
     * @param i
     * @return int
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * description: 下滤 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/4/6 10:36 <br>
     *
     * @throws
     * @param a
     * @param i
     * @param n
     * @return void
     */
    private static <E extends Comparable<? super E>> void percDown(E[] a, int i, int n) {
        int child;
        E temp;
        for(temp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
            }

            if (temp.compareTo(a[child]) < 0) {
                a[i] = a[child];
            }else {
                break;
            }
        }

        a[i] = temp;
    }

    public static <E extends Comparable<? super  E>> void heapSort(E[] a) {
        for (int i = a.length/2 - 1; i >=0; i--) {
            percDown(a, i, a.length);
        }

        for (int i = a.length - 1; i > 0; i--) {
//            swapReferences(a, 0, i);
            percDown(a, 0, i);
        }
    }
}
