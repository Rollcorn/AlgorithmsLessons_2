// package ru.shkandyuk;

import java.io.*;
import java.util.*;

class BSTNode<T> {
    public int NodeKey;    // ключ узла
    public T NodeValue;  // значение в узле
    public BSTNode<T> Parent;     // родитель или null для корня
    public BSTNode<T> LeftChild;  // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T> {
    public BSTNode<T> Node; // null если в дереве вообще нету узлов
    public boolean NodeHasKey; // true если узел найден
    public boolean ToLeft; // true, если родительскому узлу надо добавить новый левым

    public BSTFind() {
        Node = null;
        NodeHasKey = false;
        ToLeft = false;
    }
}

class BST<T> {
    BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node) {
        Root = node;
    }

    /*****************************************************************
     * Метод поиска в дереве узла по ключу и сопутствующей информации
     * @param aKey
     * @return
     */
    public BSTFind<T> FindNodeByKey(int aKey) {
        BSTNode<T> curNode = Root;
        BSTFind<T> findNode = new BSTFind<>();

        // Попытка найтир звено с заданным ключеном либо доказать что такого нет
        while (curNode != null && !findNode.NodeHasKey) {

            findNode.Node = curNode;

            if (curNode.NodeKey == aKey) {
                findNode.NodeHasKey = true;
            } else if (aKey < curNode.NodeKey) {
                findNode.ToLeft = true;
                curNode = curNode.LeftChild;
            } else {
                curNode = curNode.RightChild;
                findNode.ToLeft = false;
            }
        }

        return findNode;
    }

    /**************************************************************************************
     * Метод добавления нового узла, задаём добавляемый ключ и соответствующее ему значение
     * @param key
     * @param val
     * @return
     */
    public boolean AddKeyValue(int key, T val) {
        BSTFind<T> checkNode = FindNodeByKey(key);

        // если ключ уже есть
        if (checkNode.NodeHasKey) {
            return false;
        }

        BSTNode<T> curNode = checkNode.Node;
        BSTNode<T> insertNode = new BSTNode<>(key, val, curNode);
        if (checkNode.Node == null) {
            Root = insertNode;
        } else if (checkNode.ToLeft) {
            curNode.LeftChild = insertNode;
        } else {
            curNode.RightChild = insertNode;
        }

        return true;
    }

    public BSTNode<T> FinMinMax(BSTNode<T> aFromNode, boolean aFindMax) {
        BSTNode<T> node = null;
        BSTNode<T> curNode = aFromNode;

        while (curNode != null) {
            node = curNode;
            if (aFindMax) {
                curNode = curNode.RightChild;
            } else {
                curNode = curNode.LeftChild;
            }
        }
        return node;
    }

    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> checkNode = FindNodeByKey(key);
        if (!checkNode.NodeHasKey) {
            return false;
        }

        BSTNode<T> curNode = checkNode.Node;

        if (curNode.LeftChild == null) {
            Transplant(curNode, curNode.RightChild);
        } else if (curNode.RightChild == null) {
            Transplant(curNode, curNode.LeftChild);
        } else {
            BSTNode<T> nextMinNode = FinMinMax(curNode.RightChild, false);

            if (nextMinNode.Parent != curNode) {
                Transplant(nextMinNode, nextMinNode.RightChild);
                nextMinNode.RightChild = curNode.RightChild;
                nextMinNode.RightChild.Parent = nextMinNode;
            }
            Transplant(curNode, nextMinNode);
            nextMinNode.LeftChild = curNode.LeftChild;
            nextMinNode.LeftChild.Parent = nextMinNode;
        }

        return true;
    }

    public void Transplant(BSTNode<T> firstNode, BSTNode<T> secondNode) {
        if (firstNode.Parent == null) {
            Root = secondNode;
        } else if (firstNode == firstNode.Parent.LeftChild) {
            firstNode.Parent.LeftChild = secondNode;
        } else {
            firstNode.Parent.RightChild = secondNode;
        }

        if (secondNode != null) {
            secondNode.Parent = firstNode.Parent;
        }
    }

    public int Count() {
        return CountNode(Root); // количество узлов в дереве
    }

    public int CountNode(BSTNode<T> fromNode) {
        int count = 0;
        if (fromNode != null) {
            count = 1 + CountNode(fromNode.LeftChild) + CountNode(fromNode.RightChild);
        }
        return count; // количество узлов в дереве
    }

    public void printTree(BSTNode<T> fromNode){
            if (fromNode != null) {
                if(fromNode.Parent != null){
                    System.out.println(fromNode.Parent.NodeKey + " --> " + fromNode.NodeKey);
                } else {
                    System.out.println("C = " + fromNode.NodeKey);
                }
                printTree(fromNode.LeftChild);
                printTree(fromNode.RightChild);
            }
    }

    public ArrayList<BSTNode> WideAllNodes() {
        ArrayList<BSTNode> mList = new ArrayList<>();
        BSTNode curnode = Root;
        mList.add(Root);
        for ( int i = 0, elems = 1; elems < this.Count(); i++, curnode = mList.get(i)) {
            if(curnode == null) {
                continue;
            }
            if(curnode.LeftChild != null){
                elems++;
            }
            if(curnode.RightChild != null){
                elems++;
            }
            mList.add(curnode.LeftChild);
            mList.add(curnode.RightChild);
        }

        return mList;
    }

    public ArrayList<BSTNode> DeepAllNodes( int order ){
        ArrayList<BSTNode> mList = new ArrayList<>();

        if( order == 0 ){
            mList.addAll( InOrederTrav(Root) );
        }
        if( order == 2 ) {
            mList.addAll( PreOrederTrav(Root) );
        }

        if ( order == 1){
            mList.addAll( PostOrederTrav(Root) );
        }
        return mList;
    }

    public ArrayList<BSTNode> InOrederTrav(BSTNode node){
        ArrayList<BSTNode> mList = new ArrayList<>();

        if(node == null){
            return mList;
        }
        if(node.LeftChild != null){
            mList.addAll( InOrederTrav(node.LeftChild) );
        }
        mList.add(node);
        if(node.RightChild != null){
            mList.addAll( InOrederTrav(node.RightChild) );
        }
        return mList;
    }

    public ArrayList<BSTNode> PreOrederTrav(BSTNode node){
        ArrayList<BSTNode> mList = new ArrayList<>();

        if(node == null){
            return mList;
        }
        mList.add(node);
        if(node.LeftChild != null){
            mList.addAll( PreOrederTrav(node.LeftChild) );
        }
        if(node.RightChild != null){
            mList.addAll( PreOrederTrav(node.RightChild) );
        }
        return mList;
    }

    public ArrayList<BSTNode> PostOrederTrav(BSTNode node){
        ArrayList<BSTNode> mList = new ArrayList<>();

        if(node == null){
            return mList;
        }
        if(node.LeftChild != null){
            mList.addAll( PostOrederTrav(node.LeftChild) );
        }
        if(node.RightChild != null){
            mList.addAll( PostOrederTrav(node.RightChild) );
        }
        mList.add(node);
        return mList;
    }

}
