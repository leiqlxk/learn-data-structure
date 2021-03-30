package org.lql.tree;

/**
 * Title: BinaryNode <br>
 * ProjectName: learn-data-structure <br>
 * description: 二叉树节点 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/30 15:52 <br>
 */
public class BinaryNode<E> {
    BinaryNode(E e) {
        this(e, null, null);
    }

    BinaryNode(E e, BinaryNode<E> lt, BinaryNode<E> rt) {
        // 嵌套类的时候取值
        // element = theElement;
        left = lt;
        right = rt;
    }
    E element;
    BinaryNode<E> left;
    BinaryNode<E> right;
}
