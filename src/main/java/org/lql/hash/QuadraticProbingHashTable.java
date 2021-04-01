package org.lql.hash;

/**
 * Title: QuadraticProbingHashTable <br>
 * ProjectName: learn-data-structure <br>
 * description: 平方探测实现 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/4/1 22:15 <br>
 */
public class QuadraticProbingHashTable<E> {

    private static final int DEFAULT_TABLE_SIZE = 11;

    private HashEntry<E>[] array;
    private int currentSize;

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        this.allocateArray(size);
        this.makeEmpty();
    }

    public void makeEmpty() {
        this.currentSize = 0;
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = null;
        }
    }

    /**
     * description:  调用私有方法isActive和findPos，findPos实施冲突的解决<br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/4/1 22:28 <br>
     *
     * @throws
    * @param e
     * @return boolean
     */
    public boolean contains(E e) {
        int currentPos = this.findPos(e);
        return this.isActive(currentPos);
    }

    /**
     * description: 散列表至少为该表中元素个数的两倍大，这样平方探测解决方案才可实现。 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/4/1 22:29 <br>
     *
     * @throws
    * @param e
     * @return void
     */
    public void insert(E e) {
        int currentPos = this.findPos(e);
        if (this.isActive(currentPos)) {
            return;
        }

        this.array[currentPos] = new HashEntry<>(e, true);

        if (++this.currentSize > this.array.length / 2){
            this.rehash();
        }
    }

    /**
     * description: 将元素标记为删除 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/4/1 22:30 <br>
     *
     * @throws
    * @param e
     * @return void
     */
    public void remove(E e) {
        int currentPos = this.findPos(e);
        if (this.isActive(currentPos)) {
            this.array[currentPos].isActive = false;

            this.currentSize--;
        }
    }

    private void allocateArray(int arraySize) {
        this.array = new HashEntry[nextPrime(arraySize)];
    }

    private boolean isActive(int currentPos) {
        return this.array[currentPos] != null && this.array[currentPos].isActive;
    }

    private int findPos(E e) {
        int offset = 1;
        int currentPos = this.myhash(e);

        while (this.array[currentPos] != null && !this.array[currentPos].element.equals(e)) {
            currentPos += offset;
            offset += 2;
            if (currentPos >= this.array.length) {
                currentPos -= this.array.length;
            }
        }

        return currentPos;
    }

    private void rehash() {

    }

    private int myhash(E e) {
        int hashVal = e.hashCode();

        hashVal %= this.array.length;

        if (hashVal < 0) {
            hashVal += this.array.length;
        }

        return hashVal;
    }

    /**
     * description: 生产下一个素数 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/4/1 22:12 <br>
     *
     * @throws
     * @param n
     * @return int
     */
    private static int nextPrime(int n) {
        while(isPrime(++n)) {}
        return n;
    }

    /**
     * description: 判断是否是素数 <br>
     *
     * @author: leiql <br>
     * @version: 1.0 <br>
     * @since: 2021/4/1 22:12 <br>
     *
     * @throws
     * @param n
     * @return boolean
     */
    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n > 2) {
            if(n%2==0) {
                return false ;
            }else {
                int len = (int) Math.sqrt(n);
                for(int i=3 ; i < len ;i++) {
                    if(n%i==0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private static class HashEntry<E> {
        public E element;
        public boolean isActive;

        public HashEntry(E e) {
            this(e, true);
        }

        public HashEntry(E e, boolean b) {
            this.element = e;
            this.isActive = b;
        }
    }
}
