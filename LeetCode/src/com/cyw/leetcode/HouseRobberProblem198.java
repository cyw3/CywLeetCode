package com.cyw.leetcode;

//一晚上不能偷相邻的两家
public class HouseRobberProblem198 {
	//dp
    public int rob(int[] nums) {
        if(nums==null || nums.length<=0) return 0;
        
        int n = nums.length;
        int[] steal = new int[n+1];
        int[] noSteal = new int[n+1];
        steal[0] = 0;
        noSteal[0] = 0;
        for(int i=1;i<=n;i++){
        	steal[i] = Math.max(noSteal[i-1]+nums[i-1],steal[i-1] );
        	noSteal[i] = Math.max(steal[i-1], noSteal[i-1]);
        }
        return steal[n];
    }

	//递归分治 Time Limit Exceeded 
//    public int rob(int[] nums) {
//      if(nums==null || nums.length<=0) return 0;
//      return robDC(nums, 0);
//    }
//    
//    public int robDC(int[] nums, int start){
//        if(nums==null || nums.length<=0 || start<0) return 0;
//        if(start==nums.length-1) return nums[start];
//        if(start==nums.length-2) 
//        	return Math.max(nums[start], robDC(nums, start+1));
//        return Math.max(nums[start]+robDC(nums, start+2), robDC(nums, start+1));
//    }
	
    public static void main(String [] args){
    	HouseRobberProblem198 ho = new HouseRobberProblem198();
//    	int[] nums = {1,2,3,0,5};
    	int[] nums = {104,209,137,52,158,67,213,86,141,110,151,127,238,
    	               147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,
    	               165,180,214,151,111,161,233,147,124,143};
    	System.out.println(ho.rob(nums));
    }
}
