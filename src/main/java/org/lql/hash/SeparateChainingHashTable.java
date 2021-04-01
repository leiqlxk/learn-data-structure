package org.lql.hash;

import java.util.List;

import java.util.LinkedList;

/**
 * Title: SeparateChainingHashTable <br>
 * ProjectName: learn-data-structure <br>
 * description: 分离链接法实现 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/1 15:49 <br>
 */
public class SeparateChainingHashTable<E> {

    private static final int DEFAULT_TABLE_SIZE = 101;
    private List<E>[] theLists;
    private int currentSize;

    public SeparateChainingHashTable() {
        this(SeparateChainingHashTable.DEFAULT_TABLE_SIZE);
    }

    /**
     * description: 保存链表数组 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/4/1 16:14 <br>
     *
     * @throws
     * @param size
     * @return
     */
    public SeparateChainingHashTable(int size) {
        this.theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < this.theLists.length; i++) {
            this.theLists[i] = new LinkedList<>();
        }
    }

    /**
     * description: 如果存在就不做任何操作，否则插入，如果大小改变就进行rehash <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/4/1 16:16 <br>
     *
     * @throws
     * @param e
     * @return void
     */
    public void insert(E e) {
        List<E> wichList = this.theLists[this.myhash(e)];
        if (!wichList.contains(e)) {
            wichList.add(e);

            if (++this.currentSize > theLists.length) {
                this.rehash();
            }
        }
    }

    public void remove(E e) {
        List<E> wichList = this.theLists[this.myhash(e)];
        if (wichList.contains(e)) {
            wichList.remove(e);

            this.currentSize--;
        }
    }

    /**
     * description: 先选择数组中的位置再利用链表的contains判断是否存在 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/4/1 16:14 <br>
     *
     * @throws
     * @param e
     * @return boolean
     */
    public boolean contains(E e) {
        List<E> whichList = this.theLists[this.myhash(e)];

        return whichList.contains(e);
    }

    public void makeEmpty() {
        for (int i = 0; i < this.theLists.length; i++) {
            this.theLists[i].clear();
        }

        this.currentSize = 0;
    }

    public void rehash() {

    }

    private int myhash(E e) {
        int hashVal = e.hashCode();

        hashVal %= theLists.length;

        if (hashVal < 0) {
            hashVal += theLists.length;
        }

        return hashVal;
    }

    private static int nextPrime(int n) {

    }

    private static boolean isPrime(int n) {

    }
}
