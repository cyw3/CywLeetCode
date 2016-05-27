package com.cyw.leetcode;

public class BestTimeToBuyAndSellStockWithCooldownProblem309 {
	//1、
	/*
	 * 此时使用的是DP，但是 有三个相互关联的子结构。
	 * 即是说，
	 	buy[i] 是说，当第i天为buy的时候，基于rest[i-1]的最大收益。max时最小股价往后面移动
	 	sell[i],当第i天为sell的时候，基于buy[i-1]的最大收益。
	 	rest[i]，当第i天为rest的时候，基于buy[i-1]、sell[i-1]、rest[i-1]的最大收益。
	 	
	 	rest[i-1] == sell[i]
	 	
	 	最近一天应该是sell，则上一天就是buy了，但是buy要找到这一段最小的股价，以确保收益，
	 	rest无动作，可以不考虑
	 	然后buy之前，又是sell。当前sell时候的，最大的收益
	 	接着sell、buy，sell，一次循环下去
	 	
	 	buy[i]  = max(rest[i-1]-price, buy[i-1]) 
sell[i] = max(buy[i-1]+price, sell[i-1])
rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
	 */
//    public int maxProfit(int[] prices) {
//    	if(prices==null || prices.length<=1) return 0;
//    	
//    	//分别存储当前业务  所得最优收益
//    	int len = prices.length;
//    	int[] buy = new int[len+1];
//    	int[] sell = new int[len+1];
//    	int[] rest = new int[len+1];
//    	buy[0] = Integer.MIN_VALUE;
//    	sell[0] = 0;
//    	rest[0] = 0;
//    	//顺序是rest\buy\sell\rest
//    	for(int i=1;i<=len;i++){
//    		//与前一天的收益进行比较，越大收益越大,说明花费越小，price越低
//    		//且保证了rest在buy之前，
//    		//此时buy的话，前一天为rest，当前收益是，
////    		System.out.println(i);
//    		buy[i] = Math.max(rest[i-1]-prices[i-1], buy[i-1] );
//    		System.out.print(buy[i]+" ");
//    		//与之前的sell时候的收益进行比较，此时卖出的话，收益越大越好
//    		sell[i] = Math.max(buy[i-1]+prices[i-1], sell[i-1]);
//    		System.out.print(sell[i]+" ");
//    		//去最大值.最新的一次的sell[i-1]
//    		//此时rest的话，说明前一天是sell
//    		rest[i] = Math.max(sell[i-1], Math.max(buy[i-1],rest[i-1]));
//    		System.out.println(rest[i]);
//    	}
//    	return sell[len];
//    }
	
		//2
	   public int maxProfit(int[] prices) {
	    	if(prices==null || prices.length<=1) return 0;
	    	
	    	//分别存储当前业务  所得最优收益
	    	int len = prices.length;
	    	int[] buy = new int[len+1];
	    	int[] sell = new int[len+1];
	    	buy[0] = Integer.MIN_VALUE;
	    	sell[0] = 0;
	    	sell[1] = 0;
	    	//顺序是rest\buy\sell\rest
	    	for(int i=1;i<=len;i++){
	    		//与前一天的收益进行比较，越大收益越大,说明花费越小，price越低
	    		//且保证了rest在buy之前，
	    		//此时buy的话，前一天为rest，当前收益是，
	    		if(i==1){
	    			buy[i] = Math.max(0-prices[i-1], buy[i-1] );
	    		}else{
	    			buy[i] = Math.max(sell[i-2]-prices[i-1], buy[i-1] );
	    		}
	    		
	    		System.out.print(buy[i]+" ");
	    		//与之前的sell时候的收益进行比较，此时卖出的话，收益越大越好
	    		sell[i] = Math.max(buy[i-1]+prices[i-1], sell[i-1]);
	    		System.out.println(sell[i]+" ");
	    		//去最大值.最新的一次的sell[i-1]
	    		//此时rest的话，说明前一天是sell
	    	}
	    	return sell[len];
	    }
	
//    public int maxProfit(int[] prices) {
//        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
//        for (int price : prices) {
//            prev_buy = buy;
//            buy = Math.max(prev_sell - price, prev_buy);
////            System.out.print(prev_buy+" ");
////            System.out.print(buy+" ");
//            prev_sell = sell;
//            sell = Math.max(prev_buy + price, prev_sell);
////            System.out.print(prev_sell+" ");
////            System.out.println(sell);
//        }
//        return sell;
//    }
    
    public static void main(String [] args){
//    	1, 2, 3, 0, 2
    	int[] nums = {1, 2,3, 0,2};
    	BestTimeToBuyAndSellStockWithCooldownProblem309 b = 
    			new BestTimeToBuyAndSellStockWithCooldownProblem309();
    	System.out.println(b.maxProfit(nums));
    }
}
