package com.cyw.algorithms;


//	第二种方法是，把求的值放在足够大的数组中

import java.util.*;

public class BigIntegerOp2 {

	public static void main(String[] args) throws Exception{
		Scanner cin = new Scanner(System.in);
		String a = "";
		String b = "";
		
		while(cin.hasNext()){
			a = cin.next();
			b = cin.next();
			System.out.println(add(a,b));
		}
	}
	
	public static String add(String a, String b){
		char[][] c = null;
		int len = -1;
		int maxlen = -1;
		if(a.length()<=b.length()){
			c = new char[][]{a.toCharArray(), b.toCharArray()};
			len = a.length();
			maxlen = b.length();
		}else{
			c = new char[][]{b.toCharArray(), a.toCharArray()};
			len = b.length();
			maxlen = a.length();
		}
		
		char[] result = new char[maxlen+1];
		int temp = -1;
		int ltem = 0;
		System.out.println("len:"+len);
		for(int i=len-1;i>=0;i--){
			temp = (c[0][i]-48) + (c[1][maxlen+i-len]-48)  + ltem;
			result[maxlen+i-len+1] = (char)(temp%10 + 48);
			System.out.println("i:"+result[maxlen+i-len+1]);
			ltem = temp/10;
		}
		
		
		for(int i=maxlen-len-1;i>=0;i--){
			temp = c[1][i]-48 + ltem;
			result[i+1] = (char)(temp%10 + 48);
			ltem = temp/10;
		}
		
		result[0] = (char)(ltem+48);
		String re = new String(result);
		if(result[0]=='0'){
			return re.substring(1, re.length());
		}
		return re;
	}
}