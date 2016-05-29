package com.cyw.leetcode;

/**
 * Given n, how many structurally unique BST's (binary search trees) 
 * that store values 1...n?
 * 有多少存储1-n的二叉搜索树
 * @author cyw
 *
 */
public class UniqueBinarySearchTreesProblem96 {
	//可以使用递归 自底向上的dp。基于有序序列的个数，左右子树的结点个数
    public int numTrees(int n) {
    	//从1开始
        if(n<=0) return 0;
        //一个缓存表
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        
        //迭代
        for(int i=2;i<=n;i++){
        	int sum = 0;
        	//树的根节点依次为0-i
        	for(int j=0;j<=i-1;j++){
        		sum += cache[j] * cache[i-1-j];
        	}
        	cache[i] = sum;
        }
        //输出
        return cache[n];
    }
    
    public static void main(String [] args){
    	UniqueBinarySearchTreesProblem96 un = new UniqueBinarySearchTreesProblem96();
    	System.out.println(un.numTrees(4));
    }
}
