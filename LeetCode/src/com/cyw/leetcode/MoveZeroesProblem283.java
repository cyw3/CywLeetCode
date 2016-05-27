package com.cyw.leetcode;

/**
 * 
 * @author cyw
 *
 */
public class MoveZeroesProblem283 {
	/*
	 * 维持两个指针，一个是操作后的符合要求的指针，一个是当前处理的元素位置
	 */
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length<=1) return;
        
        int newOrder = 0;
        int nowPos = 0;
        int len = nums.length;
        for(;nowPos<len;nowPos++){
        	if(nums[nowPos]!=0) {
        		//交换newOrder与nowPos的值
        		int tem = nums[nowPos];
        		nums[newOrder] = nums[nowPos];
        		nums[nowPos] = tem;
        		newOrder++;
        	}
        }
        for(;newOrder<len;newOrder++){
        	nums[newOrder] = 0;
        }
    }
    
    public static void main(String [] args){
    	MoveZeroesProblem283 ma = new MoveZeroesProblem283();
//    	int[] nums = {0, 1, 0, 3, 12};
    	int[] nums = {1,0};
    	ma.moveZeroes(nums);
    	for(int i: nums){
    		System.out.print(i+",");
    	}
    }
}
