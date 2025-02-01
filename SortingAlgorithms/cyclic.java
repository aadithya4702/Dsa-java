package SortingAlgorithms;

import java.util.Arrays;

public class cyclic {

    public static void main(String[] args) {
        int[] arr = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(sortAndFindMissing(arr));
    }

    private static int sortAndFindMissing(int[] arr) {

        int crt = 0;
        int i = 0;
        while (i < arr.length) {
            crt = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[crt]) {
                helper.swap(arr, i, crt);
            } else {
                i++;
            }
        }

        for (int k = 0; k < arr.length; k++) {
            if (k != arr[k]) {
                return k;
            }
        }
        System.out.println(Arrays.toString(arr));
        return 0;
    }
}
