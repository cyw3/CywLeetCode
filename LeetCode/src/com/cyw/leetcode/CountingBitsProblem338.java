package com.cyw.leetcode;

/**
 * https://leetcode.com/problems/counting-bits/
 * CywLeetCode\LeetCode\src\com\cyw\swordoffer\NumberOf1.java
 * @author cyw
 *
 */
public class CountingBitsProblem338 {
    public int[] countBits(int num) {
    	if(num<0) return null;
        int[] result = new int[num+1];
        for(int i=0;i<=num;i++){
        	result[i] = getCountBits(i);
        }
        return result;
    }

	private int getCountBits(int n) {
		int count = 0;
		while(n!=0){
			n = (n-1)&n;
			count++;
		}
		return count;
	}
}
