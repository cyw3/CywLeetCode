package com.cyw.leetcode;

public class HouseRobberIIProblem213 {
	//房子围成一个圆环。不能一晚上偷相邻的两家.即是说最后一个与第一个也不能同时偷
    public int rob(int[] nums) {
        if(nums==null || nums.length<=0) return 0;
        
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        
        //以下至少三个点
        int n = nums.length;
        int[] steal = new int[n+1];
        int[] noSteal = new int[n+1];
        int max = 0;
        /*
         n		1		2
         1		0		1
         1		0		0
         0		0		1
         0		1		0
         */
//        最后一个与第一个也不能同时偷
        //当0是偷
        for(int i=2;i<=n;i++){
        	steal[i] = Math.max(noSteal[i-1]+nums[i-1],steal[i-1] );
        	noSteal[i] = Math.max(steal[i-1], noSteal[i-1]);
        }
//        max = steal[n] + nums[0];
        max = steal[n];
        
        //当0不偷时
        for(int i=1;i<n;i++){
        	steal[i] = Math.max(noSteal[i-1]+nums[i-1],steal[i-1] );
        	noSteal[i] = Math.max(steal[i-1], noSteal[i-1]);
        }
        return Math.max(max, steal[n-1]);
    }
    
    public static void main(String [] args){
    	HouseRobberIIProblem213 ho = new HouseRobberIIProblem213();
//    	int[] nums = {104,209,137,52,158,67,213,86,141,110,151,127,238,
//	               147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,
//	               165,180,214,151,111,161,233,147,124,143};
    	int[] nums = {1};//{1,2,3,0,5};//{1,1,1};
    	System.out.println(ho.rob(nums));
    }
}
