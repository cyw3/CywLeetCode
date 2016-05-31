package com.cyw.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @author cyw
 *
 */
public class BestTimeToBuyAndSellStockProblem121 {

	public static void main(String[] args) {
		int[] prices = {2,1,2,0,1};
		System.out.println(new BestTimeToBuyAndSellStockProblem121().maxProfit(prices));
	}
	/**
	 * 需要一次遍历O(n)
	 * 只能完成至多一次交易
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1) return 0;
        int len = prices.length;
        int min = prices[0];
        int maxPro = 0;
        for(int i=1;i<len;i++){
        	min = Math.min(min,prices[i]);
        	maxPro = Math.max(maxPro, prices[i]-min);
        }
        return maxPro;
    }
}
