package org.lql.tree;

import sun.net.idn.Punycode;

import java.nio.BufferUnderflowException;
import java.util.NoSuchElementException;

/**
 * Title: BinarySearchTree <br>
 * ProjectName: learn-data-structure <br>
 * description: 二叉查找树 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/30 17:37 <br>
 */
public class BinarySearchTree<E extends Comparable<? super E>> {

    private BinaryNode<E> root;

    public  BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(E e) {
        return this.contains(e, root);
    }

    public E findMin() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        
        return this.findMin(this.root).element;
    }
    
    public E findMax() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        
        return this.findMax(this.root).element;
    }

    public void insert(E e) {
        root = this.insert(e, this.root);
    }
    
    public void remove(E e) {
        root = this.remove(e, this.root);
    }

    private BinaryNode<E> remove(E e, BinaryNode<E> root) {
    }

    private BinaryNode<E> insert(E e, BinaryNode<E> root) {
    }

    private BinaryNode<E> findMax(BinaryNode<E> root) {
    }

    private BinaryNode<E> findMin(BinaryNode<E> root) {
    }

    /**
     * description: 如果在树中含有e那么返回true，如果不存在这样的节点返回false <br>
     * 如果树是空集直接返回false，对树的左子树或右子树进行一次递归调用就能得到结果<br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/30 17:51 <br>
     *
     * @throws
     * @param e 查询的元素
     * @param t 根节点
     * @return boolean
     */
    private boolean contains(E e, BinaryNode<E> t) {
        if (t == null) {
            return false;
        }

        int compareResult = e.compareTo(t.element);

        if (compareResult < 0) {
            return this.contains(e,t.left);
        }else if (compareResult > 0) {
            return this.contains(e, t.right);
        }else {
            return true;
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    private static class BinaryNode<E> {
        private E element;
        private BinaryNode<E> left;
        private BinaryNode<E> right;

        BinaryNode(E e) {
            this(e, null, null);
        }

        BinaryNode(E e, BinaryNode<E> lt, BinaryNode<E> rt) {
            this.element = e;
            this.left = lt;
            this.right = rt;
        }
    }


}
