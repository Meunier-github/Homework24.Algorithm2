package org.example;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    int size;
    private Integer[] integerList;
    static final int MAX_SIZE = 100000;

    public IntegerListImpl(int size) {
        this.integerList = new Integer[size];
    }

    public IntegerListImpl() {
        this.integerList = new Integer[MAX_SIZE];
    }


    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    public Integer add(Integer item) {
        validateItem(item);
        //validateSize();
        growIfNeeded();
        integerList[size++] = item;
        return item;
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    public     Integer add(int index, Integer item) {
        //validateSize();
        growIfNeeded();
        validateIndex(index);
        validateItem(item);
        if (index == size) {
            integerList[size++] = item;
            return item;
        }
        System.arraycopy(integerList,index, integerList,index+1,size-index);
        integerList[index] = item;
        size++;
        return item;
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        integerList[index] = item;
        return item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    public Integer remove(int index) {
        validateIndex(index);
        if (index == -1) {
            throw new ElementNotFindException();
        }
        Integer item = integerList[index];
        if (index == size) {
            System.arraycopy(integerList,index+1, integerList,index,size-index);
        }

        size--;
        return item;

    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    public boolean contains(Integer item) {
        Integer[] integerListCopy = toArray();
        sort(integerListCopy);
        return bynarySearch(integerListCopy, item);
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    public Integer get(int index) {
        validateIndex(index);
        return integerList[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    // Вернуть фактическое количество элементов.
    public int size() {
        return size;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    public boolean isEmpty() {
        return size == 0;
    }

    // Удалить все элементы из списка.
    public void clear() {
        size = 0;
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    public Integer[] toArray() {
        return Arrays.copyOf(integerList, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == integerList.length) {
            throw new IntegerListIsFUllException();
        }
    }

    private void growIfNeeded() {
        if (size == integerList.length) {
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalideIndexException();
        }
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    private static void swapElements(IntegerListImpl arr, int indexA, int indexB) {
        int tmp = arr.get(indexA);
        arr.set(indexA,arr.get(indexB));
        arr.set(indexB,tmp);
    }

    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }    public static void sortBubble(IntegerListImpl arr) {
        for (int i = 0; i < arr.size - 1; i++) {
            for (int j = 0; j < arr.size - 1 - i; j++) {
                if (arr.get(j) > arr.get(j+1)) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortSelection(IntegerListImpl arr) {
        for (int i = 0; i < arr.size - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.size; j++) {
                if (arr.get(j) < arr.get(minElementIndex)) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }public static void sortInsertion(IntegerListImpl arr) {
        for (int i = 1; i < arr.size; i++) {
            int temp = arr.get(i);
            int j = i;
            while (j > 0 && arr.get(j - 1) >= temp) {
                arr.set(j,arr.get(j - 1));
                j--;
            }
            arr.set(j,temp);
        }
    }
private void sort(Integer [] arr) {
/*    for (int i = 1; i < arr.length; i++) {
        int temp = arr[i];
        int j = i;
        while (j > 0 && arr[j - 1] >= temp) {
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = temp;
    }*/
    quickSort(arr,0,arr.length - 1);
}
    public static boolean bynarySearch(Integer[] arr, int item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    private void grow() {
        integerList = Arrays.copyOf(integerList, size + size / 2);
    }
    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    private static int partition(Integer[] arr, int begin, int end) {
        Integer pivot = arr[end];
        Integer i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

}
