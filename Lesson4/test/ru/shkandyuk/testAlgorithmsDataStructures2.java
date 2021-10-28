package ru.shkandyuk;

import org.junit.Test;

public class testAlgorithmsDataStructures2 {

    int[] a = { 4, 9, 8, 3, 1, 7, 6, 2, 5};

    AlgorithmsDataStructures2 obj = new AlgorithmsDataStructures2();

    @Test
    public void testGenerateBbstArray(){
        int[] sortArr = AlgorithmsDataStructures2.GenerateBBSTArray(a);

        for (int x: sortArr) {
            System.out.println(x);
        }

        for (int x: a) {
            System.out.println(x);
        }
    }


}
