package ru.shkandyuk;

import org.junit.Test;

public class testBalancedBST {

    int[] a = {11, 4, 9, 8, 14, 3, 12, 15, 1, 7, 6, 2, 5, 10, 13};

    @Test
    public void testGenerateBST() {
//        int[] a = null;
        BalancedBST bst = new BalancedBST();
        bst.GenerateTree(a);

        System.out.print("Массив дерево: [ ");
        printArrTree(bst.Root);
        System.out.println("]");

        System.out.print("Массив глубин: [ ");
        printDeep(bst.Root);
        System.out.println("]");

        printTree(bst.Root);
    }

    public void printTree(BSTNode fromNode) {
        if (fromNode != null) {
            if (fromNode.Parent != null) {
                System.out.println(fromNode.Parent.NodeKey + " --> " + fromNode.NodeKey);
            } else {
                System.out.println("C = " + fromNode.NodeKey);
            }
            printTree(fromNode.LeftChild);
            printTree(fromNode.RightChild);
        }
    }

    public void printArrTree(BSTNode fromNode) {
        if (fromNode != null) {
            System.out.print(fromNode.NodeKey + ", ");
            printArrTree(fromNode.LeftChild);
            printArrTree(fromNode.RightChild);
        }
    }

    public void printDeep(BSTNode fromNode) {
        if (fromNode != null) {
            System.out.print(fromNode.Level + ", ");
            printDeep(fromNode.LeftChild);
            printDeep(fromNode.RightChild);
        }
    }
}
