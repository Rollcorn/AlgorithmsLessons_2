//package ru.shkandyuk;

import java.util.*;

class BSTNode {
    public int      NodeKey;         // ключ узла
    public BSTNode  Parent;      // родитель или null для корня
    public BSTNode  LeftChild;   // левый потомок
    public BSTNode  RightChild;  // правый потомок
    public int      Level;       // глубина узла

    public BSTNode(int key, BSTNode parent) {
        NodeKey     = key;
        Parent      = parent;
        LeftChild   = null;
        RightChild  = null;
    }
}

class BalancedBST {
    public BSTNode Root; // корень дерева

    public BalancedBST() {
        Root = null;
    }

    /**
     * - выбираем корневой элемент (центральный в отсортированном
     * массиве),
     * - применяем этот алгоритм к левому и правому поддеревьям (левой и
     * правой частям массива).
     * Соответственно, из корневого элемента мы создаём текущий узел,
     * а левым и правым его узлами делаем поддеревья, которые возвращают эти два рекурсивных
     * вызова.
     *
     * @param a
     */
    public void GenerateTree(int[] a) {

        if (a != null) {
            // Сортировка массива
            Arrays.sort(a);
            Root = GenerateSubTree(null, a);
        }

    }

    private BSTNode GenerateSubTree(BSTNode parent, int[] arr) {
        int     begin   = 0;
        int     end     = arr.length; // ind of obj outside the array
        int     middle  = end / 2;
        BSTNode res     = new BSTNode(arr[middle], parent);
        if ( parent == null ){
            res.Level = 0;
        } else {
            res.Level = parent.Level + 1;
        }

        if ( arr.length > 1 ) {
            // Разделение массива
            int[] leftArr = Arrays.copyOfRange(arr, begin, middle);
            int[] rightArr = Arrays.copyOfRange(arr, (middle + 1), end);

            // Инициализация потомков
            res.LeftChild = GenerateSubTree(res, leftArr);

            res.RightChild = GenerateSubTree(res, rightArr);

        }

        return res;
    }

    public boolean IsBalanced(BSTNode root_node) {

        return DifSubTreeDeep(root_node) >= 0; // сбалансировано ли дерево с корнем root_node
    }

    /*********************************************************
     * Сравнивает глубину листа левого и правого подеревьев
     * @param root_node
     * @return
     */
    public int DifSubTreeDeep(BSTNode root_node) {

        int res = 0;

        if ( root_node == null ) {
            return res;
        }

        // Проверка является ли звено листом
        if ( root_node.RightChild == null && root_node.LeftChild == null ) {
            return root_node.Level;
        }

        int leftDeep  = 0;
        int rightDeep = 0;
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