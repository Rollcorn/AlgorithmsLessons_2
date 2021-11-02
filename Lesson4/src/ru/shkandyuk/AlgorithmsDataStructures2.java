//package ru.shkandyuk;

import java.util.*;

public class AlgorithmsDataStructures2 {

    public static int[] GenerateBBSTArray(int[] a) {

        if (a == null || a.length <= 1) {
            return a;
        }

        // Сортируем массив
        int[] sortArr = a;
        Arrays.sort(sortArr);

        int begin = 0;
        int end = sortArr.length; // ind of obj outside the array
        int middle = end / 2;

        int[] bstArr = new int[a.length];
        bstArr[0] = sortArr[middle];
        int[] leftArr = Arrays.copyOfRange(sortArr, begin, middle);
        int[] rightArr = Arrays.copyOfRange(sortArr, (middle + 1), end);
        int[] leftTree = GenerateBBSTArray(leftArr);
        int[] rightTree = GenerateBBSTArray(rightArr);

        int i = 1;
        int l = 0;
        int r = 0;
        int part = 1;
        while ( i < bstArr.length ) {
            for( int j = 0; j < part && l < leftTree.length; j++, i++, l++ ){
                bstArr[i] = leftTree[l];
            }

            for( int j = 0; j < part && r < rightTree.length; j++, i++, r++ ){
                bstArr[i] = rightTree[r];
            }
            part = part << 1;
        }
        return bstArr;
    }

}