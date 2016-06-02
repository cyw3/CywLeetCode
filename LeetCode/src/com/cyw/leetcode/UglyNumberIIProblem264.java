package com.cyw.leetcode;

/**
 * --
 * @author cyw
 *
 */
public class UglyNumberIIProblem264 {
	/**
	 * 每次用还没有用过的，最小的三个ugly numbers
	 * @param n
	 * @return
	 */
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        if(n==1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        for(int i=1;i<n;i++){
        	dp[i] = Math.min(dp[multiply2]*2, Math.min(dp[multiply3]*3, dp[multiply5]*5));
        	if(dp[i]==dp[multiply2]*2) multiply2++;
        	if(dp[i]==dp[multiply3]*3) multiply3++;
        	if(dp[i]==dp[multiply5]*5) multiply5++;
        }
        return dp[n-1];
    }
}
