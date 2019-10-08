package leetcode.dp;

public class MaxSumSubArray {

    public static int maxSubArray(int[] nums) {

        int i, n = nums.length;
        int prevSum = 0, currSum = 0;
        int ans = Integer.MIN_VALUE;

        for (i = 0; i < n; i++) {
            currSum = nums[i];
            currSum = Math.max(currSum, nums[i] + prevSum);
            ans = Math.max(ans, currSum);
            prevSum = currSum;
        }

        return ans;
    }

    public static void main(String[] args) {

        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(arr));

    }

}
