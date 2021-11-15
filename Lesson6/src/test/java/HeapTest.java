import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Зачем нужны пирамиды? Они эффективно реализуют так называемые приоритетные очереди, когда надо максимально быстро
 * обслужить объект с максимальным приоритетом, а также учитывать и ранжировать все поступающие объекты.
 */
class HeapTest {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] arr2 = {8, 6, 4, 3, 10, 5, 7, 1, 2, 9};

    @Test
    void makeHeap() {
        Heap heap1 = new Heap();
        heap1.MakeHeap(arr, 3);

        System.out.print("arr: [");
        for (int x: heap1.HeapArray) {
            System.out.print( x + ", ");
        }
        System.out.println();

    }

    @Test
    void getMax() {
    }

    @Test
    void add() {
    }
}