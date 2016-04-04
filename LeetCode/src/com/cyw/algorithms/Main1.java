package com.cyw.algorithms;

import java.util.Scanner;

public class Main1{
    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        int n, m;
        n = cin.nextInt();
        m = cin.nextInt();
        
        String str = cin.next();
        int x;
        String c = "";
        for(int i=0;i<m;i++){
        	
            x = cin.nextInt();
            c = cin.next();
            str = tran(str,x,c);
            
            System.out.println(f(str));
        }
    }
        
    public static String tran(String str, int x, String c){
		return str.substring(0, x-1) + c + str.substring(x, str.length());
    }
    
    public static int f(String str){
    	String s = str;
    	int timer = 0;
    	if(!s.contains("..")){
    		return 0;
    	}
    	int tem = s.indexOf("..");
    	while(tem!=-1){
    		s = s.substring(0, tem) + s.substring(tem+1, s.length());
    		timer++;
    		tem = s.indexOf("..");
    	}
    	return timer;
    }
}