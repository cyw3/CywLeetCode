package com.cyw.leetcode;

import java.util.ArrayList;

public class HappyNumberProblem202 {

	public static void main(String[] args) {
		HappyNumberProblem202 ha = new HappyNumberProblem202();
		System.out.println(ha.isHappy(2));
	}
	/**
	 * 
	 * @param n
	 * @return
	 */
    public boolean isHappy(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        ArrayList<Integer> dict = new ArrayList<Integer>();
        dict.add(n);
        while(n!=1){
        	int sum = 0;
        	while(n!=0){
        		sum += Math.pow(n%10, 2);
        		n /= 10;
        	}
        	if(dict.contains(sum)) return false;
        	else {
        		n = sum;
        		dict.add(sum);
        	}
        }
        return true;
    }
    
    /*
     public boolean isHappy(int n) {
	    int result = n;
	    while(result > 10){
	        result = 0;
	        while(n > 0){
	            int i = n % 10;
	            n = n/10;
	            result += Math.pow(i,2);
	        }
	        n = result;
	
	    } //this while loop calculates the input number and make it to a number less than and equal to 10
	// The happy numbers less than and equal to 10 are 1,7,10
	
	    if(n == 7) return true;
	    if(n == 10) return true;
	    if(result == 1) return true;
	    return false;
	}
     */
}
