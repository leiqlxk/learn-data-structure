package org.lql.collections;

import java.util.ListIterator;

/**
 * Title: List <br>
 * ProjectName: learn-data-structure <br>
 * description: List接口 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/29 20:54 <br>
 */
public interface List<E> extends Collection<E> {

    E get(int idx);

    E set(int idx, E newVal);

    void add(int idx, E x);

    void remove(int idx);

    ListIterator<E> listIterator(int pos);
}
