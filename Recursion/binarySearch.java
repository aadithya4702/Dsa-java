public class binarySearch {

    public static void main(String[] args) {
        int[] arr = { 3, 7, 8, 10, 12, 14, 19 };
        System.out.println(binarySearchAlgo(arr, 38));
        // using recursion
        System.out.println(bsUsingRecursion(arr, 0, arr.length - 1, 67));
    }

    private static int bsUsingRecursion(int[] arr, int s, int e, int target) {
        if (s > e) {
            return -1;
        }
        int mid = s + (e - s) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return bsUsingRecursion(arr, mid + 1, e, target);
        }
        return bsUsingRecursion(arr, s, mid - 1, target);

    }

    private static int binarySearchAlgo(int[] arr, int target) {

        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;

    }

}
