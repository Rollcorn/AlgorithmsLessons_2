package ru.shkandyuk;

import org.junit.Test;

public class testAlgorithmsDataStructures2 {

    /****************************************************************
     * sort =
     *                      { 1 2 3 4 5 6 7 8 9}:9
     *                      /         |         \
     *             {1 2 3 4 }:4       5        { 6 7 8 9 }:4
     *             /    |    \                 /     |   \
     *      { 1 2 }:2   3    { 4 }:1    { 6 7 }:2    8    { 9 }:1
     *      /   |              |        /   |               |
     *   { 1 }  2              4     { 6 }  7               9
     *
     *   5 3 2 1 4 8 7 6 9
     *   5 3 8 2 4 7 9 1 x x x 6 x x x
     *   H = 1 +
     *
     *           / 15
     *         14
     *        /  \ 13
     *      12
     *    /   \  / 11
     *   /     10
     *  /        \ 9
     * 8
     *  \        / 7
     *   \     6
     *    \   /  \ 5
     *      4
     *        \  / 3
     *          2
     *           \ 1
     */

    int[] a = { 11, 4, 9, 8, 14, 3, 12, 15, 1, 7, 6, 2, 5, 10, 13};

    AlgorithmsDataStructures2 obj = new AlgorithmsDataStructures2();

    @Test
    public void testGenerateBbstArray(){
        int[] sortArr = AlgorithmsDataStructures2.GenerateBBSTArray(a);
        System.out.print("Изначальный массив [ ");
        for (int x: a) {
            System.out.print(x + " ");
        }
        System.out.println("]");

        System.out.print("Массив дерево: [ ");
        for (int x: sortArr) {
            System.out.print(x + " ");
        }
        System.out.println("]");



    }


}
