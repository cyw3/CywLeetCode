package com.cyw.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. 
In how many distinct ways can you climb to the top?
一步或者两步，多少种不同的方式
 * @author cyw
 *
 */
public class ClimbingStairsProblem70 {
	/*
	 * DP
	 */
    public int climbStairs(int n) {
        if(n<=0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        //缓存表
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        for(int i=3;i<=n;i++){
        	cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }
}
