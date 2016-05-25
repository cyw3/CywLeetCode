package com.cyw.leetcode;

/**
 * https://leetcode.com/problems/coin-change/
 * dp 动态规划
 * @author cyw
 *
 */
public class CoinChangeProblem322 {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length<=0 || amount<0) return -1;
        
        int[] expr = new int[amount+1];
        expr[0] = 0;
        int len = coins.length;
        for(int i=0;i<len;i++){
        	if(coins[i]<=amount)
        		expr[coins[i]] = 1;
        }
        for(int i=1;i<=amount;i++){
        	int min = Integer.MAX_VALUE;
        	//需要coins
            for(int j=0;j<len;j++){
            	if(i>=coins[j]){
            		if(min-1>expr[i-coins[j]]){
            			min = expr[i-coins[j]]+1;
            		}
            	}
            }
            expr[i] = min;
        }
        if(expr[amount]==Integer.MAX_VALUE) return -1;
        return expr[amount];
    }
    
    public static void main(String [] args){
    	CoinChangeProblem322 co = new CoinChangeProblem322();
    	int[] coins = {1};
    	System.out.println(co.coinChange(coins, 0));
    }
}
