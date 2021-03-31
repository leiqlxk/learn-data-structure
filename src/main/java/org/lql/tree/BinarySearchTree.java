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

    /**
     * description: 删除时如果节点是叶子节点可以直接删除，如果节点有一个子节点，
     * 则该节点可以在其父节点调整自己的链接以绕过该节点，如果节点有两个子节点，
     * 一般的删除策略是用其右子树的最小数据代替该节点的数据并递归地删除那个节点。<br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/30 21:49 <br>
     *
     * @throws
     * @param e
     * @param t
     * @return org.lql.tree.BinarySearchTree.BinaryNode<E>
     */
    private BinaryNode<E> remove(E e, BinaryNode<E> t) {
        if (t == null) {
            return t;
        }

        int compareResult = e.compareTo(t.element);

        if (compareResult < 0) {
            t.left = this.remove(e, t.left);
        }else if (compareResult > 0) {
            t.right = this.remove(e, t.right);
        }else  if (t.left != null && t.right !=  null) {
            t.element = this.findMin(t.right).element;
            t.right = this.remove(t.element, t.right);
        }else {
            t = (t.left != null) ? t.left : t.right;
        }

        return t;
    }


    private BinaryNode<E> insert(E e, BinaryNode<E> t) {
        if (t == null) {
            return new BinaryNode<>(e, null, null);
        }

        int compareResult = e.compareTo(t.element);
        if (compareResult < 0) {
            t.left = this.insert(e, t.left);
        }else if (compareResult > 0) {
            t.right = this.insert(e, t.right);
        }

        return t;
    }

    public void printTree() {
        if (this.isEmpty()) {
            System.out.println("Empty tree");
        }else {
            this.printTree(this.root);
        }
    }

    public int height(BinaryNode<E> e) {
        if (e == null) {
            return -1;
        }else {
            return 1 + Math.max(height(e.left), height(e.right));
        }
    }

    private void printTree(BinaryNode<E> t) {
        if (t != null) {
            this.printTree(t.left);
            System.out.println(t.element);
            this.printTree(t.right);
        }
    }


    /**
     * description: 查找最大值朝右子节点进行 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/30 21:39 <br>
     *
     * @throws
     * @param t
     * @return org.lql.tree.BinarySearchTree.BinaryNode<E>
     */
    private BinaryNode<E> findMax(BinaryNode<E> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    /**
     * description: 查找最小值从根开始并且只要有左子节点就向左进行，终点就是最小元素 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/3/30 21:37 <br>
     *
     * @throws
     * @param t
     * @return org.lql.tree.BinarySearchTree.BinaryNode<E>
     */
    private BinaryNode<E> findMin(BinaryNode<E> t) {
        if(t == null) {
            return null;
        }else if (t.left == null) {
            return t;
        }

        return this.findMin(t.left);
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
