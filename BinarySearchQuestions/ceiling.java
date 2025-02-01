package BinarySearchQuestions;

public class ceiling {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 9, 14, 16, 18 };

        System.out.println(findCeiling(arr, 9));
    }

    private static int findCeiling(int[] arr, int target) {

        int l = 0;
        int h = arr.length - 1;
        int mid = 0;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (arr[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
