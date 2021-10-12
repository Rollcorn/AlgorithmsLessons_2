package ru.shkandyuk;


import org.junit.Test;

public class testSimpleTree {

    @Test
    public void testSimpleTreeNode(){

    }

    @Test
    public void testSimpleTree(){
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(14, null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(15, null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(15, null);

        SimpleTree<Integer> myTree = new SimpleTree<Integer>(node1);

        myTree.AddChild(myTree.Root, node2);
        myTree.AddChild(myTree.Root, node3);
    }

}
