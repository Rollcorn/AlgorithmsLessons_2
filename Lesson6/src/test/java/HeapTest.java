import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Зачем нужны пирамиды? Они эффективно реализуют так называемые приоритетные очереди, когда надо максимально быстро
 * обслужить объект с максимальным приоритетом, а также учитывать и ранжировать все поступающие объекты.
 */
class HeapTest {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Heap heap1 = new Heap();

    int[] arr2 = {8, 6, 4, 3, 10, 5, 7, 1, 2, 9, 15, 13, 11, 14, 12, 16};
    Heap heap2 = new Heap();


    //            15
//          14 10
//        13 6 9 11
//    12 2 4 5 8 3 7 1
    @Test
    void makeHeap() {
//        [1]
        heap1.MakeHeap(arr, 4);
        printHeap(heap1);
//        [2]
        heap2.MakeHeap(arr2, 4);
        printHeap(heap2);

    }

    @Test
    void getMax() {
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