package com.cyw.leetcode;


public class PatchingArrayProblem330 {
	//nums为正整数数组   Time Limit Exceeded
    public int minPatches(int[] nums, int n) {
        if(nums==null || nums.length<0 || n<1) return 0;
        /*
         max是前缀数组的之和，而且 前缀数组中的各元素组合能够表示1到max
         max是小于当前位i的nums元素之和
         */
        long max = 0;
        int count = 0;
        int index = 0;
        int len = nums.length;
//        for(int i=1;i<n;i++){
        for(long i=1;i<=n;){
        	while(index<len && nums[index]<=i ) max += nums[index++];
        	if(max<i) {
        		count++;
        		max += i;
        	}
        	i = max+1;
        }
        return count;
    }
	public static void main(String[] args) {
		PatchingArrayProblem330 pa = new PatchingArrayProblem330();
		int[] nums = {};//{1,2,32};//{1,5,10};//{1, 3};   [1,2,32]2147483647
		System.out.println(pa.minPatches(nums, 8));
	}

}
