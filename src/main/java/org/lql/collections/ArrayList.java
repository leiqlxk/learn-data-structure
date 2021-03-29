package org.lql.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Title: ArrayList <br>
 * ProjectName: learn-data-structure <br>
 * description: ArrayList <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/29 22:19 <br>
 */
public class ArrayList<E> implements Iterable<E> {

    private static final int DEAFULT_CAPACITY = 10;

    private int theSize;
    private E[] theItems;

    public ArrayList() {
        this.doClear();
    }

    /**
     * description: 清空数组 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:27 <br>
     *
     * @throws
     * @return void
     */
    public void clear() {
        this.doClear();
    }

    /**
     * description: 清空数组 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:28 <br>
     *
     * @throws
     * @return void
     */
    private void doClear() {
        this.theSize = 0;
        ensureCapacity(DEAFULT_CAPACITY);
    }

    /**
     * description: 获取当前项数 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:28 <br>
     *
     * @throws
     * @return int
     */
    public int size() {
        return this.theSize;
    }

    /**
     * description: 是否为空集合 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:28 <br>
     *
     * @throws
     * @return boolean
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * description: 去除数组超出集合项数部分，节省空间 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:29 <br>
     *
     * @throws
     * @return void
     */
    public void  trimToSize() {
        ensureCapacity(this.size());
    }

    /**
     * description: 根据下标获取元素 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:29 <br>
     *
     * @throws
     * @param idx
     * @return E
     */
    public E get(int idx) {
        if (idx < 0 || idx >= this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return this.theItems[idx];
    }

    /**
     * description: 根据下标设置元素 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:30 <br>
     *
     * @throws
     * @param idx
     * @return E
     */
    public E set(int idx, E newVal) {
        if (idx < 0 || idx >= this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        E oldVal = this.theItems[idx];
        this.theItems[idx] = newVal;

        return oldVal;
    }


    /**
     * description: 确保足够容量 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:32 <br>
     *
     * @throws
     * @param newCapacity
     * @return void
     */
    private void ensureCapacity(int newCapacity) {
        if (newCapacity < this.size()) {
            return;
        }

        E[] old = this.theItems;
        this.theItems = (E[])new Object[newCapacity];
        for (int i = 0; i < this.size(); i++) {
            this.theItems[i] = old[i];
        }
    }

    /**
     * description: 添加元素 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:38 <br>
     *
     * @throws
     * @param x
     * @return boolean
     */
    public boolean add(E x) {
        add(this.size(), x);
        return true;
    }

    /**
     * description: 根据索引添加元素 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:38 <br>
     *
     * @throws
     * @param idx
     * @param x
     * @return void
     */
    private void add(int idx, E x) {
        if (this.theItems.length == this.size()) {
            ensureCapacity(this.size() * 2 + 1);
        }

        for (int i = this.size(); i > idx; i--) {
            this.theItems[i] = this.theItems[i-1];
        }

        this.theItems[idx] = x;

        this.theSize++;
    }

    /**
     * description: 根据下标删除元素 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 22:42 <br>
     *
     * @throws
     * @param idx
     * @return E
     */
    public E remove(int idx) {
        E removedItem = this.theItems[idx];

        for (int i = idx; i < this.size() - 1; i++) {
            this.theItems[i] = this.theItems[i + 1];
        }

        this.theSize--;
        return removedItem;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    private class ArrayListIterator implements Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public E next() {
            if (!this.hasNext()) {
                throw  new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            ArrayList.this.remove(--current);
        }
    }
}
