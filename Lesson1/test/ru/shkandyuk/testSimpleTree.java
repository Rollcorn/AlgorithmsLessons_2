package ru.shkandyuk;


import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class testSimpleTree {


    @Test
    public void testSimpleTree(){
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4, null);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(5, null);
        SimpleTreeNode<Integer> node6 = new SimpleTreeNode<Integer>(6, null);
        SimpleTreeNode<Integer> node7 = new SimpleTreeNode<Integer>(3, null);

        SimpleTree<Integer> myTree = new SimpleTree<Integer>(node1);
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }
        System.out.println("0: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());

        myTree.AddChild(null, node2);

        System.out.println("1: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        myTree.AddChild(node1, node2);
        myTree.AddChild(node1, node3);
//        myTree.AddChild(null, node2);
//        myTree.AddChild(node2, null);

        System.out.println("2: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        myTree.AddChild(node2, node4);
        myTree.AddChild(node2, node5);
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }
        System.out.println("3: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        myTree.DeleteNode(node2);
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }

        System.out.println("3.1: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        myTree.AddChild(node1, node2);
        myTree.AddChild(node2, node4);
        myTree.AddChild(node2, node5);
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }
        System.out.println("4: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());

        myTree.AddChild(node3, node6);
        myTree.AddChild(node3, node7);
        System.out.println("5: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());

        myTree.DeleteNode(myTree.Root);
        System.out.println("6: Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
    }

    @Test
    public void testFindByValue(){
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4, null);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(5, null);
        SimpleTreeNode<Integer> node6 = new SimpleTreeNode<Integer>(6, null);
        SimpleTreeNode<Integer> node7 = new SimpleTreeNode<Integer>(3, null);

        SimpleTree<Integer> myTree = new SimpleTree<Integer>(node1);
        myTree.AddChild(node1, node2);
        myTree.AddChild(node1, node3);
        myTree.AddChild(node2, node4);
        myTree.AddChild(node2, node5);
        myTree.AddChild(node3, node6);
        myTree.AddChild(node3, node7);

        for (SimpleTreeNode<Integer> x : myTree.FindNodesByValue(3) ) {
            System.out.println(x.NodeValue);
        }
    }

    @Test
    public void testMoveNode(){
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4, null);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(5, null);
        SimpleTreeNode<Integer> node6 = new SimpleTreeNode<Integer>(6, null);
        SimpleTreeNode<Integer> node7 = new SimpleTreeNode<Integer>(3, null);

        SimpleTree<Integer> myTree = new SimpleTree<Integer>(node1);
        myTree.AddChild(node1, node2);
        myTree.AddChild(node1, node3);
        myTree.AddChild(node2, node4);
        myTree.AddChild(node2, node5);
        myTree.AddChild(node3, node6);
        myTree.AddChild(node3, node7);
        System.out.println("Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }
        myTree.MoveNode(node2, node6);
        System.out.println("Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }
    }
}
