package SortingAlgorithms;

public class bubbleSort {
    public static void main(String[] args) {

        int[] arr = { 84, 54, 32, 12, 98, 43, 90 }; // 12,32,43,54,84,90,94
        
        bubbleSortAlgo(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    //for every swap the last index gets updated with correct element so we ignore that and continue with other ,
    //also if no swap happen it is already sprted so we can break the loop

    private static void bubbleSortAlgo(int[] arr) {
        boolean swapped;

        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    helper.swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }

        }
    }

}
