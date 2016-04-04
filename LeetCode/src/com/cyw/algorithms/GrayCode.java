package com.cyw.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author cyw
 */
public class GrayCode {
	
    public static String[] getGray(int n)
    {
    	String[] Gray = {"0", "1"};
        if(n == 1)
            return Gray;
        String[] LastRank = getGray(n - 1);
        List<String> ThisRank = new LinkedList<String>();
        for(int i = 0; i < LastRank.length; i++)
            ThisRank.add("0"+ LastRank[i]);
        for(int i = LastRank.length - 1; i >= 0; i--)
            ThisRank.add("1"+ LastRank[i]);
        
        String[] result = new String[ThisRank.size()];
        for(int i=0;i<ThisRank.size();i++){
        	result[i] = ThisRank.get(i);
        }
        return result;
    }
    
    public static void main(String [] args){
    	String[] str = getGray(4);
    	for(int i=0;i<str.length;i++){
    		System.out.println(str[i]);
    	}
    }

}
