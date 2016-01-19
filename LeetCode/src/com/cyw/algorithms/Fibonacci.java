package com.cyw.algorithms;

/**
 * ì³²¨ÄÇÆõÊý
 * @author cyw
 *
 */
public class Fibonacci {

	public int fib(int n){
		if(n<2){
			return n;
		}else{
			return fib(n-1)+fib(n-2);
		}
	}
	
	public static void main(String [] args){
		System.out.println(new Fibonacci().fib(10));
	}
}
