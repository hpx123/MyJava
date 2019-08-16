package DP;

public class LC_0053 {
    public static void main(String[] args) {
        Polution po = new Polution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(po.maxSubArray(nums));
    }
}
class Polution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i];
            if(dp[i - 1] + nums[i] > nums[i]){
                dp[i] = dp[i - 1] + nums[i];
            }
            if(dp[i] > sum){
                sum = dp[i];
            }
        }
        return sum;
    }
}