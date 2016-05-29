package com.cyw.leetcode;

public class JumpGameProblem55 {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length<=0) return false;
        if(nums.length==1) return true;
        if(nums[0]==0) return false;
//        int pos = 0;
        int len = nums.length;
        //可跳跃距离在 nums[pos]以内
        //应该是计算出前几的可跳跃最长距离。只要该距离大于len即可
//        while(pos<len-1){
////        	if(nums[pos]<=0) return false;
//        	if(pos+nums[pos]>=len-1) return true;
//        	pos += nums[pos];
//        }
        int[] cache = new int[len];
        cache[0] = nums[0];
        for(int i=1;i<len;i++){
        	//cache[i-1]  nums[i]+pos
        	cache[i] = Math.max(cache[i-1], nums[i]+i);
        	//如果cache[i] == i
        	if(cache[i]==i) return false;
        	if(cache[i]>=len-1) return true;
        }
        return false;
    }
	public static void main(String[] args) {
		int[] a = {3,2,1,0,4};//{2,5,0,0};//{3,2,1,0,4};//{2,3,1,1,4}; [2,5,0,0]//[0]//[0,1]
		JumpGameProblem55 ju = new JumpGameProblem55();
		System.out.println(ju.canJump(a));
	}

}
