import java.util.*;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи
    public int size = 0;

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {

        // Расчет необходимой длины массива для размещения кучи заданной глубины
        int arrLength = 0;
        // размер массива кучи вычисляется на основе глубины кучи
        for (int i = 0; i <= depth; i++) {
            arrLength = arrLength + (1 << i);
        }
        // Инициализация количества эллементов в массиве
        HeapArray = new int[arrLength];
        if ( a == null || a.length == 0 ) {
            return;
        }
        // создаём массив кучи HeapArray из заданного
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

            if ( ( Left(i) < size ) && ( HeapArray[currMax] < HeapArray[Left(i)] ) ) {
                currMax = Left(i);
            }
            if ( ( Right(i) < size ) && ( HeapArray[currMax] < HeapArray[Right(i)] ) ){
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
        // вернуть значение корня и перестроить кучу
        return max; // если куча пуста
    }

    /************************************
     * Добавление новго элемента в кучу
     * @param key
     * @return
     */
    public boolean Add(int key) {
        // проверить что в массиве есть место
        if ( HeapArray == null || size >= HeapArray.length) {
            return false;// если куча вся заполнена
        }
        // поместить новый элемент после последнего элемента
        HeapArray[size] = key;

        // пока родительский элемент меньше нового элемента просеиваем новый элемент вверх кучи
        for (int i = size;
             ( i > 0 ) && ( Parent(i) >= 0 ) && ( HeapArray[i] > HeapArray[Parent(i)] );
             i = Parent(i) ) {
            int tmp = HeapArray[Parent(i)];
            HeapArray[Parent(i)] = HeapArray[i];
            HeapArray[i] = tmp;

        }
        size++;
        return true;
    }

    // Индекс родительского элемента
    public int Parent(int i) {
        return (i - 1)/2;
    }

    // Индекс левого дочернего элемента
    public int Left(int i) {
        return 2 * i + 1;
    }

    // Индекс правого дочернего элемента
    public int Right(int i) {
        return 2 * i + 2;
    }

}
