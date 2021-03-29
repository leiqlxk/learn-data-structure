package org.lql.collections;

import java.util.Iterator;

/**
 * Title: table <br>
 * ProjectName: learn-data-structure <br>
 * description: 集合框架顶层接口 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/29 14:41 <br>
 */
public interface Collection<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    void clear();

    boolean contains(E e);

    boolean add(E e);

    boolean remove(E e);

    Iterator<E> iterator();
}
