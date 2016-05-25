package com.cyw.leetcode;

public class ZigZagConversionProblem6 {
	//Zigzag
	//z��
    public static String convert(String s, int numRows) {
    	if(numRows == 1 || numRows>=s.length()){
    		return s;
    	}
    	String[] str = new String[numRows];
    	int row = 0;
    	int step = 1;
    	for(int i=0;i<s.length();i++){
    		if(str[row]==null){
    			str[row]="";
    		}
    		str[row] += s.charAt(i)+"";
    		if(row==0){
    			step = 1;
    		}else if(row==numRows-1){
    			step = -1;
    		}
    		row +=step;
    	}
    	String result = "";
    	for(int i=0;i<numRows;i++){
    		System.out.println(str[i]);
    		result +=str[i];
    	}
		return result;
    }
    
    public static void main(String [] args){
    	System.out.println(convert("PAYPALISHIRING",3));
    }
}
