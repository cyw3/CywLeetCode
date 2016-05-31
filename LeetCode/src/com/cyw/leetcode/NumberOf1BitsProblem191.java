package com.cyw.leetcode;

public class NumberOf1BitsProblem191 {

	public static void main(String[] args) {
		NumberOf1BitsProblem191 nu = new NumberOf1BitsProblem191();
		System.out.println(nu.hammingWeight(2));
	}
	//汉明距离
	public int hammingWeight(int n) {
		int count = 0;
		int flag = 1;
		while(flag!=0){
			if((n&flag)!=0) count++;
			flag = flag<<1;
		}
		return count;
	}
    // you need to treat n as an unsigned value
//    public int hammingWeight(int n) {
//        if(n==0) return 0;
//        int count = 0;
//        while(n!=0){
//        	n = n&(n-1);
//        	count++;
//        }
//        return count;
//    }
}
