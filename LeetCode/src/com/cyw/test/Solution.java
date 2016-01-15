package com.cyw.test;

public class Solution {
    public static boolean isPowerOfThree(int n) {
    	
//    	求对数,取结果中的整数，去掉小数，然后乘方，判断得数是否相等
//    	logx(y) =loge(x) / loge(y)，换底公式
//    	log() 是ln()
    		return Math.pow(3,Math.round(Math.log(n)/Math.log(3)))==n && n>0;
    	
//    	boolean result = false;
//        if(n%3==0 && n!=1){
//        	result = isPowerOfThree(n/3);
//        }
//        else if(n==1){
//        	return true;
//        }else
//        	return false;
//        if(result)
//        	return true;
//        else 
//        	return false;
    }
    
    public static boolean isPowerOfTwo(int n) {
    	 //如果一个整数是2的幂，那么它的二进制形式最高位为1，其余各位为0
        return (n > 0 && ((n&(n - 1))==0));
    }
    
    public static void main(String [] args){
    	
//    	System.out.println();
    	
    	if(isPowerOfThree(27))
    		System.out.println("True");
    	else
    		System.out.println("False");
    }
}