package SearchingAlgorithms;

public class linearSearch {

    public static void main(String[] args) {
        int[] arr = { 6, 7, 12, 13, 34, 56 };
        System.out.println(linearSearchAlgo(arr, 56));
    }

    private static int linearSearchAlgo(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
