package org.lql.collections;

/**
 * Title: ListIterator <br>
 * ProjectName: learn-data-structure <br>
 * description: list扩展迭代器对象<br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/29 22:03 <br>
 */
public interface ListIterator<E> extends Iterator<E> {

    boolean hasPrevious();
    E previous();

    void add(E x);

    void set(E newVal);
}
