package com.cyw.leetcode;

import java.util.HashMap;

public class MajorityElementProblem169 {

	public static void main(String[] args) {

	}
	/**
	 * non-empty and the majority element always exist in the array
	 * n/2
	 * @param nums
	 * @return
	 */
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length<=0) return 0;
        int len = nums.length;
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for(int i=0;i<len;i++){
        	dict.put(nums[i], dict.getOrDefault(nums[i], 0)+1);
        	if(dict.get(nums[i])>(len/2)) return nums[i];
        }
        return 0;
    }
    /*
     // Moore's majority vote method
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }
        int count = 1;
        int major = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != major){
                count--;
            } else {
                count++;
            }
            if (count == 0){
                major = nums[i];
                count = 1;
            }
        }
        return major;
    }
    
    // Sorting
	public int majorityElement1(int[] nums) {
	    Arrays.sort(nums);
	    return nums[nums.length/2];
	}
	
	// Bit manipulation 
	public int majorityElement(int[] nums) {
	    int[] bit = new int[32];
	    //将所有的元素的各个字位相加
	    for (int num: nums)
	        for (int i=0; i<32; i++) 
	            if ((num>>(31-i) & 1) == 1)
	                bit[i]++;
	    int ret=0;
	    //因为所求的数出现频率超过n/2，是最多的。所以，也只有这个整数的每一个字位上的1会超过n/2
	    for (int i=0; i<32; i++) {
	        bit[i]=bit[i]>nums.length/2?1:0;
	        ret += bit[i]*(1<<(31-i));
	    }
	    return ret;
	}
     */
}
