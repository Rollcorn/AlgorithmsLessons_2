package ru.shkandyuk;


import org.junit.Test;

public class testSimpleTree {

    @Test
    public void testSimpleTreeNode(){

    }

    @Test
    public void testSimpleTree(){
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(14, null);
        SimpleTree<Integer> myTree = new SimpleTree<Integer>(node1);
    }

}
