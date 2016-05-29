package com.cyw.leetcode;

/**

Find the contiguous subarray within an array (containing at least one number) which has the largest product.
有最大的积。找顺序相邻的数，组成子数组
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 * @author cyw
 *
 */
public class MaximumProductSubarrayProblem152 {
	
	// Time Limit Exceeded
//	public int maxProduct(int[] nums) {
//		if(nums==null || nums.length<=0) return 0;
////		if(nums.length==1) return nums[0];
//		int len = nums.length;
//        int[] cache = new int[len];
//        cache[0] = nums[0];
//        for(int i=1;i<len;i++){
//        	if(cache[i-1]*nums[i]>cache[i-1]) {
//        		cache[i] = cache[i-1] * nums[i];
//        		continue;
//        	}
//        	int tem = 1;
//        	for(int j=i;j>=0;j--){
//        		tem *= nums[j];
//        		cache[i] = Math.max(cache[i], tem);
//        	}
//        }
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<len;i++){
//        	max = Math.max(max, cache[i]);
//        }
//        return max;
//	}
	
	//注意0 会把一个数组分为多个子数组
	public int maxProduct(int[] nums) {
		if(nums==null || nums.length<=0) return 0;
		//考虑负数的个数
		int max = Integer.MIN_VALUE;
		int len = nums.length;
		int pro = 1;
		for(int i=0;i<len;i++){
			pro *= nums[i];
			max = Math.max(max, pro);
			if(nums[i]==0){
				pro = 1;
			}
		}
		pro = 1;
		for(int i=len-1;i>=0;i--){
			pro *= nums[i];
			max = Math.max(max, pro);
			if(nums[i]==0){
				pro = 1;
			}
		}
		return max;
	}
    
    public static void main(String [] args){
    	MaximumProductSubarrayProblem152 ma = new MaximumProductSubarrayProblem152();
    	int[] nums = {-2};//{-3,0,1,-2};//{2,-2,3,-2,4};//[-3,0,1,-2]
    	System.out.println(ma.maxProduct(nums));
    }
} 
