package ru.shkandyuk;

import java.io.*;
import java.util.*;

class BSTNode<T> {
    public int        NodeKey;    // ключ узла
    public T          NodeValue;  // значение в узле
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
        findNode.NodeHasKey = false;

        // Попытка найтир звено с заданным ключеном либо доказать что такого нет
        while ( curNode != null && !findNode.NodeHasKey) {
            findNode.Node = curNode;

            if ( curNode.NodeKey == aKey ) {
                findNode.NodeHasKey = true;
            } else if ( aKey < curNode.NodeKey ) {
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

        if( checkNode.NodeHasKey ){
            return false;
        }

        BSTNode<T> curNode = Root;
        BSTNode<T> insertNode = new BSTNode<>(key, val, curNode);
        if( checkNode.ToLeft ){
            curNode.LeftChild = insertNode;
        } else {
            curNode.RightChild = insertNode;
        }

        return true; // если ключ уже есть
    }

    public BSTNode<T> FinMinMax(BSTNode<T> aFromNode, boolean aFindMax) {
        BSTNode<T> node = null;
        BSTNode<T> curNode = aFromNode;

        while( curNode != null ){
            node = curNode;
            if( aFindMax ){
                curNode = curNode.RightChild;
            } else {
                curNode = curNode.LeftChild;
            }
        }
        return node;
    }

    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> checkNode = FindNodeByKey(key);
        if( checkNode.NodeHasKey ){
            return false;
        }

        BSTNode<T> curNode = checkNode.Node;
        curNode.Parent.LeftChild = null;
        curNode = curNode.LeftChild;

        while( curNode != null ){
            AddKeyValue(curNode.NodeKey, curNode.NodeValue);
            curNode = curNode.LeftChild;

        }

        return false; // если узел не найден
    }

    public int Count() {

        return CountNode(Root); // количество узлов в дереве
    }

    public int CountNode(BSTNode<T> fromNode) {
        int count = 0;

        if( fromNode != null ){
            count = 1 + CountNode(fromNode.LeftChild) + CountNode(fromNode.RightChild);
        }

        return count; // количество узлов в дереве
    }
}
