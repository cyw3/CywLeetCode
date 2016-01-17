package com.cyw.algorithms;

public class Graph {
	
	/*
	 * Marienbad游戏
	 * 《算法基础》
	 * 回溯标志
	 * 
	 * 缺点是：
	 * 需要一次又一次的计算相同的值。会出现重复的值。
	 */
	public static boolean recwin(int i,int j){
		//假定0<=j<=i;当且仅当<i,j>是可赢节点是返回true
		for(int k=1;k<j;k++){
			if(!recwin(i-k,Math.min(2*k,i-k))){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 提高效率
	 * 使用动态规划。创建一个G布尔数组，满足当且仅当<i,j>是一个可赢的布局时，G[i,j]=true
	 * 缺点是：
	 * 浪费大量的时间计算G中永远用不到的一些像
	 */
//	public boolean[] dywin(int n){
//		boolean[] G
//		
//		return G;
//	}

	public static void main(String [] args){
		System.out.println(recwin(5,4));
	}
}
