package com.cyw.leetcode;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * @author cyw
 *
 */
public class LongestIncreasingSubsequenceProblem300 {

	public static void main(String[] args) {
		int[] nums = {1,3,6,7,9,4,10,5,6};
		LongestIncreasingSubsequenceProblem300 lo = new LongestIncreasingSubsequenceProblem300();
		System.out.println(lo.lengthOfLIS(nums));
	}
	/**
	 * 1、DP
	 * @param nums
	 * @return
	 */
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length<=0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        for(int i=0;i<len;i++){
        	dp[i] = 1;
        }
        for(int i=1;i<len;i++){
        	for(int j=i-1;j>=0;j--){
        		//找到小于nums[i]的递增数列的个数的最大值
        		if(nums[i]>nums[j]) {
        			dp[i] = Math.max(dp[i], dp[j]+1);
        		}
        	}
        }
        int max = 0;
        for(int i=0;i<len;i++){
        	max = Math.max(max, dp[i]);
        }
        return max;
    }
}
