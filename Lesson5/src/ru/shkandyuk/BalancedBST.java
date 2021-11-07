package ru.shkandyuk;

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

        return false; // сбалансировано ли дерево с корнем root_node
    }

    /*********************************************************
     * Сравнивает глубину листа левого и правого подеревьев
     * @param root_node
     * @return
     */
    public int DifSubTreeDeep(BSTNode root_node) {
        Integer res       = null;
        Integer leftDeep  = null;
        Integer rightDeep = null;

        if ( root_node == null ) {
            return res;
        }

        // Проверка является ли звено листом
        if ( root_node.RightChild == null && root_node.LeftChild == null ) {
            res =  root_node.Level;
        }

        /**
         * Рассматриваются варианты наличия/отсутствия узлов
         * - один из узлов отсутствует;
         * - оба узла отсутствуют;
         * - оба узла присутствуют.
         */
        // Поиск листа в правом поддереве
        if ( root_node.RightChild != null ) {
            rightDeep = DifSubTreeDeep(root_node.RightChild);
        }
        // Поиск листа в левом поддереве
        if ( root_node.LeftChild != null ) {
            leftDeep = DifSubTreeDeep( root_node.LeftChild);
        }

        // Разница глубин листьев правого и левого поддерева
        if ( rightDeep != null && leftDeep != null ) {
            res = Math.abs( leftDeep - rightDeep );
        }

        // Если правое и левое поддеревья сбаласированны возвращает наибольшую глубину
        if ( res <= 1 ) {
            return Math.max(leftDeep, rightDeep);
        }
        else if( res > 1) {
            return -res;
        }
        else {
            return res;
        }
    }
} 