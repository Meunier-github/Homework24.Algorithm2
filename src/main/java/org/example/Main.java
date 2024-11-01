package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.example.IntegerListImpl.*;

public class Main {
    public static void main(String[] args) {
        IntegerListImpl integerList1 = new IntegerListImpl(MAX_SIZE);
        IntegerListImpl integerList2 = new IntegerListImpl(MAX_SIZE);
        IntegerListImpl integerList3 = new IntegerListImpl(MAX_SIZE);

        int[] arr1 = new int[MAX_SIZE];
        int[] arr2 = new int[MAX_SIZE];
        int[] arr3 = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            arr1[i] = new Random().nextInt(MAX_SIZE);
        }
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        for (int i = 0; i < MAX_SIZE; i++) {
            integerList1.add(new Random().nextInt(MAX_SIZE));
            integerList2.add(integerList1.get(i));
            integerList3.add(integerList1.get(i));
        }


        long start = System.currentTimeMillis();
        sortBubble(arr1);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        sortSelection(arr2);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        sortInsertion(arr3);
        System.out.println(System.currentTimeMillis() - start);


        start = System.currentTimeMillis();
        sortBubble(integerList1);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        sortSelection(integerList2);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        sortInsertion(integerList3);
        System.out.println(System.currentTimeMillis() - start);

    }

}