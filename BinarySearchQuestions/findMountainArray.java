package BinarySearchQuestions;

public class findMountainArray {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 3, 1 };
        int peak = findPeak(arr);
        int ans = findTarget(arr, 2, 0, peak);

        if (ans != -1) {
            System.out.println(ans);
        } else {
            ans = findTarget(arr, 3, peak + 1, arr.length - 1);
        }
        System.out.println(ans);

    }

    public static int findTarget(int[] arr, int target, int start, int end) {

        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;

            } else {
                return mid;
            }

        }
        return -1;
    }

    public static int findPeak(int[] arr) {

        int l = 0;
        int h = arr.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;

            if (arr[mid] > arr[mid + 1]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
