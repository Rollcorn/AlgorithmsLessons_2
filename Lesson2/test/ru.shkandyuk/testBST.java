package ru.shkandyuk;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class testBST {
    //    тест: проверяем поиск отсутствующего ключа в двух вариантах (запрошенный ключ добавляем либо левому, либо
//    правому потомку и поиск присутствующего ключа)
    BSTNode<Integer> n1 = new BSTNode<Integer>(7, 7, null);

    BST<Integer> mbst = new BST<Integer>(n1);

    @Before
    public void start() {
        mbst.AddKeyValue(4, 4);
        mbst.AddKeyValue(3, 3);
        mbst.AddKeyValue(2, 2);
        mbst.AddKeyValue(6, 6);
        mbst.AddKeyValue(10, 10);
        mbst.AddKeyValue(23, 23);
        mbst.AddKeyValue(11, 11);
        mbst.AddKeyValue(5, 5);
        mbst.AddKeyValue(8, 8);
        mbst.AddKeyValue(9, 9);


    }

    @Test
    public void testAdd() {
        BST<Integer> mbst1 = new BST<Integer>(null);
        mbst1.AddKeyValue(6, 6);
        System.out.println("Size: " + mbst1.Count());
        System.out.println("Max: " + mbst1.FinMinMax(mbst1.Root, true).NodeKey);
        System.out.println("Min: " + mbst1.FinMinMax(mbst1.Root, false).NodeKey);
    }

    @Test
    public void testFinMinMax() {
        System.out.println("Size: " + mbst.Count());
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);

    }

    @Test
    public void testDelete() {
        mbst.printTree(mbst.Root);
        System.out.println("Size: " + mbst.Count());
        System.out.println();

        System.out.println("Delete key = 7");
        mbst.DeleteNodeByKey(7);
        mbst.printTree(mbst.Root);
        System.out.println("Size: " + mbst.Count());
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);
        System.out.println();

        System.out.println("Delete key = 23");
        mbst.printTree(mbst.Root);
        mbst.DeleteNodeByKey(23);
        System.out.println("Size: " + mbst.Count());
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);
        System.out.println();

        System.out.println("Delete key = 2");
        mbst.DeleteNodeByKey(2);
        System.out.println("Size: " + mbst.Count());
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);
        System.out.println("Delete key = 11");
        System.out.println();

        mbst.DeleteNodeByKey(11);
        System.out.println("Size: " + mbst.Count());
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);
        System.out.println("Delete key = 3");
        System.out.println();

        mbst.DeleteNodeByKey(3);
        System.out.println("Size: " + mbst.Count());
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);
        System.out.println();

        System.out.println("Delete key = 8");
        mbst.DeleteNodeByKey(8);
        System.out.println("Size: " + mbst.Count());
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);

    }

    @Test
    public void testWideAllNodes() {
        ArrayList<BSTNode> mList = mbst.WideAllNodes();

        System.out.println("Count: " + mbst.Count());
        int i = 0;
        for (BSTNode<Integer> x : mList) {
            if (x != null) {
                System.out.println(x.NodeKey);
            } else {
                System.out.println(x);
            }
            if (i == 0) {
                System.out.println("-----");
            }
            if ( i > 0 && i % 2 == 0){
                System.out.println("-----");
            }
            i++;
        }
    }

}
