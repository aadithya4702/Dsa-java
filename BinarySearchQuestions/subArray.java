package BinarySearchQuestions;

public class subArray {
    public static void main(String[] args) {
        int[] arr = { 7, 2, 5, 10, 8 };
        System.out.println(findSubArraySum(arr, 2));
    }

    public static int findSubArraySum(int[] arr, int m) {

        int start = 0;
        int end = 0;

        for (int a : arr) {
            start = Math.max(a, start);
            end += a;
        }


        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pices = 1;

            for (int a : arr) {
                if (sum + a > mid) {
                    sum = a;
                    pices++;
                } else {
                    sum += a;
                }
            }

            if (pices > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        
        return end;
    }

}
