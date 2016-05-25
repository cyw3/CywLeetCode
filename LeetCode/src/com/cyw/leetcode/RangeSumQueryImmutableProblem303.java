package com.cyw.leetcode;

/**
 * https://leetcode.com/articles/range-sum-query-immutable/
 * Given an integer array nums, 
 * find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 * Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 * @author cyw
 *缓存?
 */
public class RangeSumQueryImmutableProblem303 {
	public int[] query; 
	public int len ;
	
    public RangeSumQueryImmutableProblem303(int[] nums) {
        this.query = nums;
        this.len = nums.length;
        
        for(int i=1;i<len;i++){
        	query[i] += query[i-1];
        }
        
    }

    //1\超时O(n)
//    public int sumRange(int i, int j) {
//        if(j<i) return 0;
//        if(i<0) i=0;
//        if(j>=len) j=len-1;
//        int sum = 0;
//        for(;i<=j;i++){
//        	sum += query[i];
//        }
//        return sum;
//    }
    
    
    /**2\ 使用缓存
    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

	public NumArray(int[] nums) {
	    for (int i = 0; i < nums.length; i++) {
	        int sum = 0;
	        for (int j = i; j < nums.length; j++) {
	            sum += nums[j];
	            map.put(Pair.create(i, j), sum);
	        }
	    }
	}
	
	public int sumRange(int i, int j) {
	    return map.get(Pair.create(i, j));
	}
    */
    
    //3\
    //利用索引i的值，是0到i之间的值之总和
    public int sumRange(int i, int j) {
        if(j<i) return 0; //i<=j
        if(i<0) i=0;
        if(j>=len) j=len-1;
        if(i>0){
        	return query[j]-query[i-1];
        }else
        	return query[j];
    }
    
    public static void main(String [] args){
    	int[] nums = {-2, 0, 3, -5, 2, -1};
    	RangeSumQueryImmutableProblem303 rs = new RangeSumQueryImmutableProblem303(nums);
    	System.out.println(rs.sumRange(2, 5));
    }
}
//Your NumArray object will be instantiated and called as such:
//NumArray numArray = new NumArray(nums);
//numArray.sumRange(0, 1);
//numArray.sumRange(1, 2);
