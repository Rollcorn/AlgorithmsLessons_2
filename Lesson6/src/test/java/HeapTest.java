import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Зачем нужны пирамиды? Они эффективно реализуют так называемые приоритетные очереди, когда надо максимально быстро
 * обслужить объект с максимальным приоритетом, а также учитывать и ранжировать все поступающие объекты.
 */
class HeapTest {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10};
    int[] arrHeap = {10, 10, 6, 7, 9, 2, 5, 1, 4, 3, 8, 0, 0, 0, 0};
    Heap heap1 = new Heap();

    int[] arr2 = {8, 6, 4, 3, 10, 5, 7, 1, 10, 9, 15, 13, 11, 14, 12, 10};
    Heap heap2 = new Heap();


    //            15
//          14 10
//        13 6 9 11
//    12 2 4 5 8 3 7 1
    @Test
    void makeHeap() {
//      [1]
        heap1.MakeHeap(arr, 3);
        printHeap(heap1);
        assertArrayEquals(arrHeap, heap1.HeapArray);
//      [2]
        heap2.MakeHeap(arr2, 3);
        printHeap(heap2);
//      [3]
        int[] arr3 = {10, 5, 10, 4};
        Heap heap3 = new Heap();
        heap3.MakeHeap(arr3, 3);
        printHeap(heap3);

    }

    @Test
    void getMax() {
        heap1.MakeHeap(arr, 3);
        printHeap(heap1);
        System.out.println("Heap1 SIZE is " + heap1.size);
        System.out.println("Heap1 max is " + heap1.GetMax());
        System.out.println("Heap1 SIZE is " + heap1.size);

        printHeap(heap1);
        System.out.println("Heap1 max is " + heap1.GetMax());
        System.out.println("Heap1 SIZE is " + heap1.size);

        printHeap(heap1);
        System.out.println("Heap1 max is " + heap1.GetMax());
        System.out.println("Heap1 SIZE is " + heap1.size);
        printHeap(heap1);

        heap1.Add(10);
        printHeap(heap1);
        System.out.println("Heap1 SIZE is " + heap1.size);
        System.out.println("Heap1 max is " + heap1.GetMax());
        System.out.println("Heap1 SIZE is " + heap1.size);
        printHeap(heap1);

    }

    @Test
    void add() {
        heap1.MakeHeap(arr, 4);

        for (int x : arr) {
            heap1.Add(x);
        }
        printHeap(heap1);
    }

    public void printHeap(Heap h) {
        System.out.print("arr: [");
        for (int x : h.HeapArray) {
            System.out.print(x + ", ");
        }
        System.out.println("]");
    }
}