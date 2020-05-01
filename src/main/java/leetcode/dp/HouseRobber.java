package leetcode.dp;

public class HouseRobber {

    public static int rob(int[] nums) {

        int i, n = nums.length;
        int prevMoney = 0, currMoney = 0, tmp = 0;

        for (i = 0; i < n; i++) {
            currMoney = prevMoney;
            currMoney = Math.max(currMoney, nums[i] + tmp);
            tmp = prevMoney;
            prevMoney = currMoney;
        }
        return prevMoney;
    }

    public static void main(String[] args) {

        int arr[] = {1,2,3,1};
        System.out.print(rob(arr));

    }

}
