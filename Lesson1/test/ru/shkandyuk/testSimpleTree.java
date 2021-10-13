package ru.shkandyuk;


import org.junit.Test;

import java.util.ArrayList;

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

        System.out.println(myTree.Count());
//        myTree.DeleteNode(node1);
        System.out.println(myTree.Count());
        for (SimpleTreeNode<Integer> x :myTree.GetAllChildren()) {
            System.out.println(x.NodeValue);
        }
    }

}
