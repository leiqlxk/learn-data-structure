package org.lql.collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Title: LinkedList <br>
 * ProjectName: learn-data-structure <br>
 * description: LinkedList <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/29 23:17 <br>
 */
public class LinkedList<E> implements Iterable<E>{

    private int theSize;
    // 用于快速错误检测，检测迭代期间是否被修改
    private int modCount = 0;
    private Node<E> beginMarker;
    private Node<E> endMarker;

    /**
     * description: 节点对象 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 23:23 <br>
     *
     * @throws
     * @return
     */
    private static class Node<E> {
        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public E data;
        public Node<E> prev;
        public Node<E> next;
    }

    private class LinkedListIterator implements Iterator<E> {
        // 被构造时赋值
        private Node<E> current = beginMarker.next;
        private int expectedModCount = modCount;
        private  boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            E nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            if (!okToRemove) {
                throw new IllegalStateException();
            }

            LinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }

    public LinkedList() {
        this.doClear();
    }

    public void clear() {
        this.doClear();
    }

    public int size() {
        return this.theSize;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean add(E x) {
        this.add(this.size(), x);
        return true;
    }

    private void add(int idx, E x) {
        this.addBefore(this.getNode(idx, 0, this.size()), x);
    }

    private E get(int idx) {
        return this.getNode(idx).data;
    }

    private E set(int idx,  E newVal) {
        Node<E> p = this.getNode(idx);
        E oldVal = p.data;
        p.data = newVal;

        return oldVal;
    }

    public E remove(int idx) {
        return this.remove(this.getNode(idx));
    }

    /**
     * description: 删除节点 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 23:52 <br>
     *
     * @throws
     * @param p 当前节点
     * @return E
     */
    private E remove(Node<E> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        this.theSize--;
        this.modCount++;

        return p.data;
    }

    /**
     * description: 在当前节点位置插入节点 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 23:41 <br>
     *
     * @throws
     * @param p 当前节点
     * @param x 插入的节点
     * @return void
     */
    private void addBefore(Node<E> p, E x) {
        Node<E> newNode = new Node<>(x, p.next, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        this.theSize++;
        this.modCount++;
    }

    /**
     * description: 根据位置获取节点 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 23:47 <br>
     *
     * @throws
     * @param idx
     * @return org.lql.collections.LinkedList.Node<E>
     */
    private Node<E> getNode(int idx) {
        return this.getNode(idx, 0, this.size() - 1);
    }

    /**
     * description: 获取节点 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/29 23:35 <br>
     *
     * @throws
     * @param idx 获取第几个节点
     * @param lower 最低有效位
     * @param upper 最高有效位
     * @return java.lang.Object
     */
    private Node<E> getNode(int idx, int lower, int upper) {
        Node<E> prev;

        if (idx < lower || idx > upper) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (idx < this.size() / 2) {
            prev = this.beginMarker.next;
            for (int i = 0; i < idx; i++) {
                prev = prev.next;
            }
        }else {
            prev = this.endMarker;
            for (int i = this.size(); i > idx; i--) {
                prev = prev.prev;
            }
        }

        return prev;
    }

    private void doClear() {
        this.beginMarker = new Node<E>(null, null, null);
        this.endMarker = new Node<E>(null, this.beginMarker, null);
        this.beginMarker.next = this.endMarker;

        this.theSize = 0;
        modCount++;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
}
