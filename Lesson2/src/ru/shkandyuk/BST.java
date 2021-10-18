package ru.shkandyuk;

import java.io.*;
import java.util.*;

class BSTNode<T> {

    public int NodeKey; // ключ узла

    public T NodeValue; // значение в узле

    public BSTNode<T> Parent; // родитель или null для корня

    public BSTNode<T> LeftChild; // левый потомок

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

        while ( curNode != null && !findNode.NodeHasKey) {
            if ( curNode.NodeKey == aKey ) {
                findNode.Node = curNode;
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
        boolean addResult = false;


        return addResult; // если ключ уже есть
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        // ищем максимальный/минимальный ключ в поддереве
        return null;
    }

    public boolean DeleteNodeByKey(int key) {
        // удаляем узел по ключу
        return false; // если узел не найден
    }

    public int Count() {
        return 0; // количество узлов в дереве
    }

}
