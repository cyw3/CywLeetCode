package com.cyw.leetcode;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Given num = 16, return true. Given num = 5, return false.
 * @author cyw
 *
 */
public class PowerOfFourProblem342 {
    public boolean isPowerOfFour(int num) {
        return Math.pow(4, Math.round(Math.log(num)/Math.log(4)))==num && num>0;
    }
    public static void main(String [] args){
    	PowerOfFourProblem342 rs = new PowerOfFourProblem342();
    	System.out.println(rs.isPowerOfFour(16));
    }
}
