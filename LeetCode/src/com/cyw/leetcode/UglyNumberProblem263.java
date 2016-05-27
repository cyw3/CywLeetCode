package com.cyw.leetcode;

/**
 * 质因数只有2,3,5
 * 1是ugly number
 * @author cyw
 *
 */
public class UglyNumberProblem263 {
    public boolean isUgly(int num) {
        if(num<=0) return false;
        while(num>1){
        	if(num%2==0){
        		num = num/2;
        	}else if(num%3==0){
        		num = num/3;
        	}else if(num%5==0){
        		num = num/5;
        	}else{
        		return false;
        	}
        }
        return true;
    }
}
