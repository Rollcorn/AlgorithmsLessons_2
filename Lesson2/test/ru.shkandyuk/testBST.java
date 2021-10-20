package ru.shkandyuk;

import org.junit.Before;
import org.junit.Test;

public class testBST {
//    тест: проверяем поиск отсутствующего ключа в двух вариантах (запрошенный ключ добавляем либо левому, либо
//    правому потомку и поиск присутствующего ключа)
    BSTNode<Integer> n1 = new BSTNode<Integer>(7, 7, null);

    BST<Integer> mbst = new BST<Integer>(n1);

    @Before
    public void start(){
        mbst.AddKeyValue(3,3);
        mbst.AddKeyValue(23,23);
        mbst.AddKeyValue(2,2);
        mbst.AddKeyValue(6,6);
        mbst.AddKeyValue(11,11);
        mbst.AddKeyValue(10,10);
        mbst.AddKeyValue(5,5);
        mbst.AddKeyValue(8,8);
        mbst.AddKeyValue(9,9);
        mbst.AddKeyValue(4,4);


    }

    @Test
    public void testFinMinMax(){
        System.out.println("Size: " + mbst.Count());
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);

    }

    @Test
    public void testDelete(){
        System.out.println("Delete key = 7");
        mbst.DeleteNodeByKey(7);
        System.out.println("Size: " + mbst.Count());
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);
        System.out.println("Delete key = 23");
        mbst.DeleteNodeByKey(23);
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);
        System.out.println("Delete key = 2");
        mbst.DeleteNodeByKey(2);
        System.out.println("Max: " + mbst.FinMinMax(mbst.Root, true).NodeKey);
        System.out.println("Min: " + mbst.FinMinMax(mbst.Root, false).NodeKey);


    }


}
