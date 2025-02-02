package SortingAlgorithms;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 1, 4 };
        int[] arr1 = { 6, 4, 7, 3, 8, 2 };

        selectionSort(arr);
        insertionSort(arr1);
        System.out.println("After selection sort" + Arrays.toString(arr));
        System.out.println("After Insertion sort" + Arrays.toString(arr1));
    }

    private static void insertionSort(int[] arr1) {
        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr1[j - 1] > arr1[j]) {
                    helper.swap(arr1, j - 1, j);
                } else {
                    break;
                }

            }
        }
    }

    private static void selectionSort(int[] arr) {

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            helper.swap(arr, max, arr.length - i - 1);
        }
    }

}
