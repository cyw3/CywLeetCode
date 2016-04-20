package com.cyw.swordoffer;

/**
 * 二维数组中的查找
 * @author cyw
 */
public class Array {
	/*
题目描述

在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 

输入描述:
array： 待查找的二维数组
target：查找的数字

输出描述:
查找到返回true，查找不到返回false
	 */
	/**
	 * 因为输入的二维数组是有序的，所以利用其有序性
	 * @param array
	 * @param target
	 * @return
	 */
    public static boolean Find(int [][] array,int target) {
    	
    	if(array==null)
    		return false;
    	
    	int len = array.length;
    	int subLen = array[0].length;
    	
    	for(int i=0,j=subLen-1;i<len&&j>=0;){
    		if(array[i][j]==target)
    			return true;
    		else if(array[i][j]>target)
    			j--;
    		else
    			i++;
    	}
		return false;
    }
    
    public static void main(String [] args){
    	int[][] array = {{1,2,3},{4,5,6}};
    	System.out.println(Find(array,6));
    }
}
