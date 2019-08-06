package DP;

public class LC_0673 {

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums  = {};

        System.out.println(so.findNumberOfLIS(nums));
    }
}

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int i = 0, j = 0;
        int len = nums.length;
        int[] dp = new int[1000];
        int[] ans = new int[1000];
        int max = -1, maxLen = -1;
        if(nums.length == 0){
            return 0;
        }
        for(i = 0; i < len; i++){
            dp[i]  = 1;
            ans[i] = 1;
            for(j = 0; j < i; j++){
                if(nums[j] < nums[i] && dp[j] + 1 >= dp[i]){
                    if(dp[j] + 1 == dp[i]){
                        ans[i] += ans[j];
                    }else {
                        ans[i] = ans[j];
                    }
                    dp[i] = dp[j] + 1;
                }
            }
            System.out.println(dp[i] + "==" + ans[i]);
            if(dp[i] == max){
                maxLen += ans[i];
            }
            else if(dp[i] > max){
                max = dp[i];
                maxLen = ans[i];
            }
        }
        return maxLen;

    }
}
