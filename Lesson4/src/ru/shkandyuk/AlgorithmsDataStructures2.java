package ru.shkandyuk;

import java.util.*;

public class AlgorithmsDataStructures2 {

    public static int[] GenerateBBSTArray(int[] a)
    {
        int[] res = a.clone();
        Arrays.sort(res);

        return res;
    }
}
