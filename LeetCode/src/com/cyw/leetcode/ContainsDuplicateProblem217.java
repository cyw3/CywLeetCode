package com.cyw.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateProblem217 {

	public static void main(String[] args) {
	}
	/**
	 * 找重复的数
	 * 1、hashMap
	 * 2、位映射
	 * @param nums
	 * @return
	 */
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length<=0) return false;
        int len = nums.length;
        Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for(int i=0;i<len;i++){
        	int time = dict.getOrDefault(nums[i], 0);
        	if(time>=1) return true;
        	dict.put(nums[i], time+1);
        }
        return false;
    }
    
    /*
     public boolean containsDuplicate(int[] nums) {
	    byte[] mark = new byte[150000];
	    for (int i : nums) {
	        int j = i/8;
	        int k = i%8;
	        int check = 1<<k;
	        if ((mark[j] & check) != 0) {
	            return true;
	        }
	        mark[j]|=check;
	    }
	    return false;
	 }
     */
}
