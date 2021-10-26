//package ru.shkandyuk;

import java.util.*;

class aBST {
    public Integer Tree[]; // массив ключей

    public aBST(int depth) {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = 0;
        for (int i = 0; i <= depth; i++) {
            tree_size += (1 << i);
        }
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) {
            Tree[i] = null;
        }
    }

    public Integer FindKeyIndex(int key) {
        Integer ret = null;
        Integer curKey = 0;

        // ищем в массиве индекс ключа
        for ( int index = 0; index < Tree.length && ret == null; ) {
            curKey = Tree[index];
            if ( curKey == null || curKey == key ) {
                ret = index;
            }
            else if ( key < curKey  ) {
                index = getLeftChildIndex(index);
            }
            else {
                index = getRightChildIndex(index);
            }
        }

        return ret; // не найден
    }

    public int AddKey(int key) {
        int ret = -1;
        Integer curKey = 0;

        // добавляем ключ в массив
        for ( int index = 0; index < Tree.length && ret == -1; ) {

            curKey = Tree[index];

            if ( curKey == null || curKey == key ) {
                Tree[index] = key;
                ret = index;
            }
            else if ( key < curKey  ) {
                index = getLeftChildIndex(index);
            }
            else {
                index = getRightChildIndex(index);
            }
        }
        // индекс добавленного/существующего ключа или -1 если не удалось
        return ret;
    }

    private Integer getLeftChildIndex(Integer aIndex) {
        Integer ret;
        if ( aIndex == null ) {
            ret = null;
        } else {
            ret = 2 * aIndex + 1;
        }
        return ret;
    }

    private Integer getRightChildIndex(Integer aIndex) {
        Integer ret;
        if ( aIndex == null ) {
            ret = null;
        } else {
            ret = 2 * aIndex + 2;
        }
        return ret;
    }

    public void printTree(){
        int border = 1;
        for (int i = 0; i != Tree.length; i++) {
            if (i == ( border - 1 ) )  {
                System.out.println("----------");
                border = border << 1;
            }
            System.out.println("[" + i + "] = " + Tree[i] );

        }
    }
}