package BinarySearchQuestions;

import SearchingAlgorithms.binarySearch;

public class findInInfiniteArray {

    public static void main(String[] args) {

        int[] arr = { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };

        System.out.println(searchInInfinite(arr, 10));
        ;
    }

    private static int searchInInfinite(int[] arr, int target) {

        int l = 0;
        int h = 1;

        while (arr[h] < target) {

            int temp = h + 1;

            // double the box
            h = h + (h - l + 1) * 2;
            l = temp;
        }
        return binarySearch(arr, l, h, target);
    }

    private static int binarySearch(int[] arr, int l, int h, int target) {
        int mid = 0;
        while (l <= h) {

            mid = l + (h - l) / 2;

            if (arr[mid] > target) {
                h = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }

        }

        return 0;
    }
}
