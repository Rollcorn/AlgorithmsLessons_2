package ru.shkandyuk;


import org.junit.Test;

import java.util.*;

public class testSimpleTree {

    @Test
    public void testSimpleTreeNode(){

    }

    @Test
    public void testSimpleTree(){
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(14, null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(15, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(16, node1);

        ArrayList<SimpleTreeNode<Integer>> nodesArray = new ArrayList<>();
        for (int i = 0; i < 14; i++ ){
            nodesArray.add( new SimpleTreeNode<Integer>(i, null) );
        }

        SimpleTree<Integer> myTree = new SimpleTree<Integer>(node1);
        myTree.AddChild(node1, node2);
        myTree.AddChild(node1, node3);
        myTree.AddChild(node2, nodesArray.get(0));
        myTree.AddChild(node2, nodesArray.get(1));

        System.out.println("Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        myTree.DeleteNode(node2);
        myTree.AddChild(node3, nodesArray.get(2));
        myTree.AddChild(node3, nodesArray.get(3));

        System.out.println("Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
        for (SimpleTreeNode<Integer> x :myTree.GetAllNodes()) {
            System.out.println(x.NodeValue);
        }

        for (SimpleTreeNode<Integer> x :myTree.GetSubtree(node2)) {
            System.out.println(x.NodeValue);
        }

        myTree.DeleteNode(myTree.Root);
        System.out.println("Количество узлов: " + myTree.Count() + " Количество листьев: " + myTree.LeafCount());
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
