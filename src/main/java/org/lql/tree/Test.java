package org.lql.tree;

import java.sql.PseudoColumnUsage;

/**
 * Title: Test <br>
 * ProjectName: learn-data-structure <br>
 * description: TODO <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/3/31 16:03 <br>
 */
public class Test {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(19);
        binarySearchTree.insert(3);
        binarySearchTree.insert(10);
        binarySearchTree.insert(21);
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(9);

        binarySearchTree.printTree();
    }
}
