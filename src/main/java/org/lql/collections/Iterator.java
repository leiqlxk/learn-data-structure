package org.lql.collections;

/**
 * Title: Iterator <br>
 * ProjectName: learn-data-structure <br>
 * description: 迭代器对象接口 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/29 16:48 <br>
 */
public interface Iterator<E> {

    boolean hashNext();

    E next();

    void remove();
}
