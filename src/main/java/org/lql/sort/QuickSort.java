package org.lql.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: QuickSort <br>
 * ProjectName: learn-data-structure <br>
 * description: 快速排序： <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/6 11:08 <br>
 */
public class QuickSort {

    public static void sort(List<Integer> items) {
        if (items.size() > 1) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size() / 2);
            for (Integer i : items) {
                if (i < chosenItem) {
                    smaller.add(i);
                }else if (i > chosenItem) {
                    larger.add(i);
                }else {
                    same.add(i);
                }
            }

            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }
}
