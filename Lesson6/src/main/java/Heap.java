import java.util.*;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи
    int size = 0;

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        // Расчет необходимой длины массива для размещения кучи заданной глубины
        int arrLength = 0;
        // размер массива кучи вычисляется на основе глубины кучи
        for (int i = 0; i < depth; i++) {
            arrLength = arrLength + (1 << i);
        }
        // Инициализация количества эллементов в массиве
        HeapArray = new int[arrLength];
        // создаём массив кучи HeapArray из заданного
        for (int j : a) {
            Add(j);
        }

    }

    public int GetMax() {
        int max = HeapArray[0];
        for (int i = size;
             ( Parent(i) <= 0 ) && ( HeapArray[i] > HeapArray[Parent(i)] );
             i = Parent(i) ) {
            int tmp = HeapArray[Parent(i)];
            HeapArray[Parent(i)] = HeapArray[i];
            HeapArray[i] = tmp;

        }
        // вернуть значение корня и перестроить кучу
        return -1; // если куча пуста
    }

    /************************************
     * Добавление новго элемента в кучу
     * @param key
     * @return
     */
    public boolean Add(int key) {
        // проверить что в массиве есть место
        if ( HeapArray == null || size >= HeapArray.length) {
            return false;
        }
        // поместить новый элемент после последнего элемента
        HeapArray[size] = key;

        // пока родительский элемент меньше нового элемента просеиваем новый элемент вверх кучи
        for (int i = size; ( Parent(i) >= 0 ) && ( HeapArray[i] > HeapArray[Parent(i)] ); i = Parent(i) ) {
            int tmp = HeapArray[Parent(i)];
            HeapArray[Parent(i)] = HeapArray[i];
            HeapArray[i] = tmp;

        }
        size++;
        return true; // если куча вся заполнена
    }

    // Индекс родительского элемента
    public int Parent(int i) {
        return i / 2;
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