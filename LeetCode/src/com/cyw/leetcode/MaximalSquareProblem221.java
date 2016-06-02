package com.cyw.leetcode;

/**
 * https://leetcode.com/problems/maximal-square/
 * 二维二进制矩阵
 * @author cyw
 *
 */
public class MaximalSquareProblem221 {

	public static void main(String[] args) {

	}
	/**
	 * 找小岛
	 * @param matrix
	 * @return
	 */
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length<=0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
        	for(int j=1;j<=n;j++){
        		if(matrix[i-1][j-1]=='0') dp[i][j] = 0;
        		else{
        			dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
        		}
        	}
        }
        int max = 0;
        for(int i=0;i<=m;i++){
        	for(int j=0;j<=n;j++){
        		max = Math.max(max, dp[i][j]);
        	}
        }
        return (int) Math.pow(max, 2);
    }
}
