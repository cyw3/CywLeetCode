package com.cyw.leetcode;

public class TwoSumProblem1 {
	public  int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        int length = nums.length;
        boolean status = false;
        int i=0,j=1;
        for(;i<length-1;i++){
        	for(j=i+1;j<length;j++){
        		if(nums[i]+nums[j]==target){
        			status = true;
        			break;
        		}
        	}
    		if(status){
    			break;
    		}
        }
    	result[0]=++i;
    	result[1]=++j;
        return result;
    }
}
