package org.lql.collections;

import java.util.EmptyStackException;

/**
 * Title: Stack <br>
 * ProjectName: learn-data-structure <br>
 * description: Stack <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/30 11:13 <br>
 */
public class Stack<E> extends ArrayList<E> {

    public Stack() {

    }

    public E push(E e) {
        super.add(e);
        return e;
    }

    public E pop() {
        int len = this.size();
        return super.remove(len - 1);
    }

    public E peek() {
        int len = this.size();

        if (len == 0) {
            throw new EmptyStackException();
        }

        return super.get(len - 1);
    }
}
