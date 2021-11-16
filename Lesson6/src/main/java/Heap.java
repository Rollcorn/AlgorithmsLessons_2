//import java.util.*;

class Heap {
    public int[] HeapArray;
    public int size = 0;

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {

        int arrLength = 0;
        for (int i = 0; i <= depth; i++) {
            arrLength = arrLength + (1 << i);
        }
        HeapArray = new int[arrLength];
        if ( a == null || a.length == 0 ) {
            return;
        }
        for ( int j : a ) {
            Add(j);
        }

    }

    public int GetMax() {

        if ( HeapArray == null || HeapArray.length == 0 ) {
            return -1;
        }
        int max = HeapArray[0];

        HeapArray[0] = HeapArray[size - 1];
        HeapArray[size - 1] = 0;
        size--;

        int currMax = 0;
        for (int i = 0; i < size; i = currMax ) {

            if ( Left(i) < (size - 1) && HeapArray[currMax] < HeapArray[Left(i)] ) {
                currMax = Left(i);
            }
            if ( Right(i) < (size - 1) && HeapArray[currMax] < HeapArray[Right(i)] ){
                currMax = Right(i);
            }

            if ( currMax == i ) {
                break;
            } else {
                int tmp = HeapArray[currMax];
                HeapArray[currMax] = HeapArray[i];
                HeapArray[i] = tmp;
            }


        }
        return max;
    }

    public boolean Add(int key) {
        if ( HeapArray == null || size >= HeapArray.length) {
            return false;
        }
        HeapArray[size] = key;

        for (int i = size; ( Parent(i) >= 0 ) && ( HeapArray[i] > HeapArray[Parent(i)] ); i = Parent(i) ) {
            int tmp = HeapArray[Parent(i)];
            HeapArray[Parent(i)] = HeapArray[i];
            HeapArray[i] = tmp;

        }
        size++;
        return true;
    }

    public int Parent(int i) {
        return i / 2;
    }

    public int Left(int i) {
        return 2 * i + 1;
    }

    public int Right(int i) {
        return 2 * i + 2;
    }

}
