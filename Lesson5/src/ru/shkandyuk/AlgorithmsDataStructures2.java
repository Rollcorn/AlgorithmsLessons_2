// package ru.shkandyuk;

import java.util.*;

class BSTNode {
    public int      NodeKey;
    public BSTNode  Parent;
    public BSTNode  LeftChild;
    public BSTNode  RightChild;
    public int      Level;

    public BSTNode(int key, BSTNode parent) {
        NodeKey     = key;
        Parent      = parent;
        LeftChild   = null;
        RightChild  = null;
    }
}

class BalancedBST {
    public BSTNode Root;

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {

        if (a != null) {
            Arrays.sort(a);
            Root = GenerateSubTree(null, a);
        }

    }

    public BSTNode GenerateSubTree(BSTNode parent, int[] arr) {
        int     begin   = 0;
        int     end     = arr.length;
        int     middle  = end / 2;
        BSTNode res     = new BSTNode(arr[middle], parent);
        if ( parent == null ){
            res.Level = 0;
        } else {
            res.Level = parent.Level + 1;
        }

        if ( arr.length > 1 ) {
            int[] leftArr = Arrays.copyOfRange(arr, begin, middle);
            int[] rightArr = Arrays.copyOfRange(arr, (middle + 1), end);

            res.LeftChild = GenerateSubTree(res, leftArr);
            res.RightChild = GenerateSubTree(res, rightArr);
        }

        return res;
    }

    public boolean IsBalanced(BSTNode root_node) {
        return DifSubTreeDeep(root_node) >= 0;
    }

    public int DifSubTreeDeep(BSTNode root_node) {

        int res = 0;

        if ( root_node == null ) {
            return res;
        }

        if ( root_node.RightChild == null && root_node.LeftChild == null ) {
            return root_node.Level;
        }

        int leftDeep;
        int rightDeep;
        if ( root_node.RightChild != null ) {
            rightDeep = DifSubTreeDeep(root_node.RightChild);
        } else {
            rightDeep = root_node.Level;
        }
        if ( root_node.LeftChild != null ) {
            leftDeep = DifSubTreeDeep( root_node.LeftChild);
        } else {
            leftDeep = root_node.Level;
        }

        if ( rightDeep < 0 || leftDeep < 0 ) {
            res = Math.min( rightDeep, leftDeep );
        } else {
            res = Math.abs( leftDeep - rightDeep );
            if ( res > 1 ) {
                res = -res;
            } else {
                res = Math.max( leftDeep, rightDeep );
            }
        }
        return res;
    }
} 
