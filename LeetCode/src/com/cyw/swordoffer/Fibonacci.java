package com.cyw.swordoffer;

/**
 * 斐波那契数列
 * @author cyw
 *
 *f(n)=
 *			0			n=0
 *			1			n=1
 *		f(n-1)+f(n-2)  n>1
 */
public class Fibonacci {
//	现在要求输入一个整数n，请你输出斐波那契数列的第n项。
	
	/**
	 * 1、如果使用递归，会出现效率低的问题，因为斐波那契数列可以看做一个二叉树，其中很多的节点都是重复的。
	 * 时间复杂度是以n的指数递增
	 * 2、所以，第二种方法应该是使用动态规划的思想，将重复计算的点进行存储，方便以后使用。时间复杂度是O(n)
	 * 3、时间复杂度是O(lgn)但是不够实用的方法
	 * @param n
	 * @return
	 */
    public int Fibonacci1(int n) {
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else{
			return Fibonacci1(n-1)+Fibonacci1(n-2);
		}
    }
    
    //使用自底向上的动态规划方法
    public int Fibonacci2(int n) {
    	
    	if(n==0)
    		return 0;
    	if(n==1)
    		return 1;
    	
    	int[] temp = new int[n+1];
    	temp[0] = 0;
    	temp[1] = 1;
    	int i=2;
    	while(i<n+1){
    		temp[i] = temp[i-1]+temp[i-2];
    		i++;
    	}
    	return temp[n];
    }
    
    //使用自顶向下备份递归、动态规划
//	public int Fibonacci3(int n) {
//    	if(n==0)
//    		return 0;
//    	if(n==1)
//    		return 1;
//    	
//    	int[] temp = new int[n+1];
//    	temp[0] = 0;
//    	temp[1] = 1;
//    	temp[n]=Fibonacci3(n-1)+Fibonacci3(n-2);
//    	return temp[n];
//	}
    
    /*
     * 4、时间复杂度是O(lgn)但是不够实用的方法。数学公式
     * 
     * [f(n) f(n-1);f(n-1) f(n-2)] = [1 1;1 0]^(n-1)
     */
//    public int Fibonacci4(int n) {
//    	
//    }
    
    /**
     * 题目2
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 
     * 斐波那契数列、自顶向下备份递归
     */
    public int JumpFloor(int target) {
		if(target<=0)
            return 0;
        if(target==1)
            return 1;
        if(target==2)
            return 2;
        
        int[] temp = new int[target+1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        int i = 3;
        while(i<=target){
        	temp[i] = temp[i-1] + temp[i-2];
        	i++;
        }
        return temp[target];
    }

    /*
     * 题目3 变态跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    public int JumpFloorII(int target) {
        if(target<=0)
        	return 0;
        
        int[] temp = new int[target+1];
        int i=1;
        while(i<=target){
        	for(int j=1;j<i;j++){
        		temp[i] += temp[j];
        	}
        	temp[i]++;
        	i++;
        }
        return temp[target];
    }
}
