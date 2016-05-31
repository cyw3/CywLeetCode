package com.cyw.leetcode;

/**
 * https://leetcode.com/problems/perfect-squares/
 * @author cyw
 *
 */
public class PerfectSquaresProblem279 {

	public static void main(String[] args) {
//		System.out.println(Math.pow(2, 3));
	}
	/**
	 * 开方，向下取整。优先取大值
	 * DP
	 * @param n
	 * @return
	 */
    public int numSquares(int n) {
        if(n<=0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
        	dp[i] = Integer.MAX_VALUE;
        }
        for(int i=2;i<=n;i++){
        	int maxSq = (int) (Math.sqrt(i));
        	for(int j=maxSq;j>0;j--){
        		dp[i] = Math.min(dp[i], dp[(int) (i-Math.pow(j, 2))]+1);
        	}
        }
        return dp[n];
    }
}
