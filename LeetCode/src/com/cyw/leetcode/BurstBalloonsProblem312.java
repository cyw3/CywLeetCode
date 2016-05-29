package com.cyw.leetcode;

public class BurstBalloonsProblem312 {

	//2、经典的DP。算法导论.Dp的关键是  得到一个最优子结构的递推公式
	//从小的、中间的开始？
    public int maxCoins(int[] nums) {
    	if(nums==null || nums.length<=0) return 0;
    	
        int n=nums.length+2;
        int[] newnums=new int[n];
        for(int i=0;i<n-2;i++){
            newnums[i+1]=nums[i];
        }
        newnums[0]=newnums[n-1]=1;
        //一个二维表
        int[][] DP=new int[n][n];
        //长度，从小到大，cache
        for(int k=2;k<n;k++){
            for(int l=0;l+k<n;l++){
                int h=l+k;
                //各种可能性
                for(int m=l+1;m<h;m++){
                	//DP[l][h]是指 消除l与h之间的元素 得到的最大的金币数。l与m不需要消除。所以
                	//需要 包第0位与第len-1位 设置为1。把相关联的系数都放在一起，
                    DP[l][h]=Math.max(DP[l][h],newnums[l]*newnums[m]*newnums[h]+DP[l][m]+DP[m][h]);
                }
            }
        }
        return DP[0][n-1];
    }
	
//	public int maxCoins(int[] nums) {
//		if(nums==null || nums.length<=0) return 0;
//		int len = nums.length;
//		int[] newNums = new int[len+2];
//		for(int i=0;i<len;i++){
//			newNums[i+1] = nums[i];
//		}
//		newNums[0] = 1;
//		newNums[len+1] = 1;
//		
//		//一个二维表，存储dp
//		int[][] cache = new int[len+2][len+2];
//		//cache[i][i]以及cache[i][i+1] == 0
//		//步长
//		for(int k=2;k<=len+1;k++){
//			for(int i=0;k+i<=len+1;i++){
//				for(int j=i+1;j<k+i;j++){
//					cache[i][k+i] = 
//							Math.max(cache[i][k+i], newNums[i]*newNums[j]*newNums[k+i]+cache[i][j]+cache[j][k+i]);
//				}
//			}
//		}
//		return cache[0][len+1];
//	}
	
	//1、分治法
	//Time Limit Exceeded 	时间复杂度空间复杂度都太大了。
//    public int maxCoins(int[] nums) {
//    	if(nums==null || nums.length<=0) return 0;
//    	if(nums.length==1) return nums[0];
//
//    	int len = nums.length;
//    	int max = 0;
//    	for(int i=0;i<len;i++){
//    		int coinsC = 0;
//    		int start = 1;
//    		int end = 1;
//    		if(i!=0){
//    			start = nums[i-1];
//    		}
//    		if(i!=len-1){
//    			end = nums[i+1];
//    		}
//    		coinsC += start * nums[i] * end;
//    		int[] newNums = new int[len-1];
//    		for(int j=0;j<i;j++){
//    			newNums[j] = nums[j];
//    		}
//    		for(int j=i+1;j<len;j++){
//    			newNums[j-1] = nums[j];
//    		}
//    		coinsC += maxCoins(newNums);
//    		
//    		if(max<coinsC){
//    			max = coinsC;
//    		}
//    	}
//    	return max;
//    }
    
    public static void main(String [] args){
    	BurstBalloonsProblem312 bu = new BurstBalloonsProblem312();
//    	int[] nums = {3, 1, 5, 8};
    	int[] nums = {7,9,8,0,7,1,3,5,5,2,3};
    	System.out.println(bu.maxCoins(nums));
    }
}
