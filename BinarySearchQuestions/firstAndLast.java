package BinarySearchQuestions;

public class firstAndLast {

    public static void main(String[] args) {

        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int[] ans = searchRange(nums, 8);
        for (int a : ans) {
            System.out.println(a);
        }

    }

    public static int[] searchRange(int[] nums, int target) {

        int first = search(nums, target, true);
        int last = search(nums, target, false);

        return new int[] { first, last };
    }

    private static int search(int[] nums, int target, boolean findFirst) {

        int l = 0;
        int h = nums.length - 1;
        int mid = 0;
        int ans=-1;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (nums[mid] > target) {
                h = mid - 1;
            } else if(nums[mid]<target){
                l = mid+1;
            }else{
                ans = mid;

                if(findFirst){
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }
        }
        return ans;

    }

}
