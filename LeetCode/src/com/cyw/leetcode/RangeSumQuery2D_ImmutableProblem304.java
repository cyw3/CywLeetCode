package com.cyw.leetcode;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * @author cyw
 *
 */
public class RangeSumQuery2D_ImmutableProblem304 {
	private int[][] matrix;
	public int[][] dp;
    public RangeSumQuery2D_ImmutableProblem304(int[][] matrix) {
    	if(matrix==null || matrix.length<=0) return;
        this.matrix = matrix;
        int row = matrix.length;
        int col = matrix[0].length;
        this.dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for(int r=1;r<row;r++){
        	dp[r][0] = dp[r-1][0] + matrix[r][0];
        }
        for(int c=1;c<col;c++){
        	dp[0][c] = dp[0][c-1]+ matrix[0][c];
        }
        for(int r=1;r<row;r++){
        	for(int c=1;c<col;c++){
        		dp[r][c] = dp[r-1][c] + dp[r][c-1] + matrix[r][c] - dp[r-1][c-1];
        	}
        }
    }

    /**
     * 因为是多次调用，可以将调用的存储起来。DP
     * 可以存储以[0][0]坐标到 [i][j]的总和
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(row1==0 && col1==0) return dp[row2][col2];
    	if(row1==0) return dp[row2][col2]-dp[row2][col1-1];
    	if(col1==0) return dp[row2][col2]-dp[row1-1][col2];
        return dp[row2][col2]+dp[row1-1][col1-1]-dp[row2][col1-1]-dp[row1-1][col2];
    }
    
    public static void main(String [] args){
    	int[][] matrix = {{-4,-5}};
    		/*{
    			{3,0,1,4,2},
    			{5,6,3,2,1},
    			{1,2,0,1,5},
    			{4,1,0,1,7},
    			{1,0,3,0,5}};*/
    	RangeSumQuery2D_ImmutableProblem304 ra = new RangeSumQuery2D_ImmutableProblem304(matrix);
    	for(int i:ra.dp[0]){
    		System.out.print(i+" ");
    	}
    	System.out.println(ra.sumRegion(0,0,0,1));
    }
}
