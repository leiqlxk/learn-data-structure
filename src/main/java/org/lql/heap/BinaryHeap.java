package org.lql.heap;

import java.util.NoSuchElementException;
import java.util.TreeMap;

/**
 * Title: BinaryHeap <br>
 * ProjectName: learn-data-structure <br>
 * description: 二叉堆实现 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/2 14:50 <br>
 */
public class BinaryHeap<E extends Comparable<? super E>> {
    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;
    private E[] array;

    public BinaryHeap() {
        this(BinaryHeap.DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        this.array = (E[]) new Comparable[capacity];
    }

    public BinaryHeap(E[] items) {
        this.currentSize = items.length;
        this.array = (E[]) new Comparable[(this.currentSize + 2) * 11 /10];

        int i = 1;
        for (E item : items) {
            this.array[i++] = item;
        }

        this.buildHeap();
    }

    private void insert(E e) {
        if (this.currentSize == this.array.length - 1) {
            this.enlargeArray(this.array.length * 2 +1);
        }

        //上滤
        int hole = ++this.currentSize;
        for (this.array[0] = e; e.compareTo(this.array[hole / 2]) < 0; hole /= 2) {
            this.array[hole] = this.array[hole/2];
        }

        this.array[hole] = e;
    }

    private E findMin() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        return this.array[1];
    }

    private E deleteMin() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        E minItem = this.findMin();
        this.array[1] = this.array[currentSize--];
        this.percolateDown(1);

        return minItem;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public void makeEmpty() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = null;
        }

        this.currentSize = 0;
    }

    private void percolateDown(int hole) {
        int child;

        E temp = this.array[hole];
        for (;hole * 2 <= this.currentSize; hole = child) {
            child = hole * 2;
            if (child != this.currentSize && this.array[child + 1].compareTo(this.array[child]) < 0) {
                child++;
            }

            if (this.array[child].compareTo(temp) < 0) {
                this.array[hole] = this.array[child];
            }else {
                break;
            }
        }

        this.array[hole] = temp;
    }

    private void buildHeap() {
        for (int i = this.currentSize / 2; i > 0; i--) {
            this.percolateDown(i);
        }
    }

    private void enlargeArray(int capacity) {
    }
}
