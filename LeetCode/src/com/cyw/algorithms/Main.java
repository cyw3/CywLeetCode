package com.cyw.algorithms;

import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        int n, b;
        
        while(true){
            n = cin.nextInt();
            b = cin.nextInt();
            
            System.out.println(f(n,b));
        }
    }
    
    public static int f(int n, int b){
    	int a=0;
    	if(b>n/2){
    		a = b/2+1;
    	}else{
    		a = (n+b)/2;
    	}
    	return a;
    }
}