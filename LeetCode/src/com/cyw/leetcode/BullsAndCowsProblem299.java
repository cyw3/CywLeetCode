package com.cyw.leetcode;

import java.util.HashMap;

public class BullsAndCowsProblem299 {
	//包含该数字，以及该数的位置正确，为A、bulls
	//包含该数字，位置不对,B cows
	//数字相同，重复的, 
    public String getHint(String secret, String guess) {
    	if(secret==null || guess==null || secret.length()!=guess.length()) return null;
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        int bulls = 0;
        int cows = 0;
        //将secret转换成dict
        for(char ch : secret.toCharArray()){
        	dict.put(ch, dict.getOrDefault(ch, 0)+1);
        }
        
        //先计算cows，此时cows代表的是 guess包含的数字的个数
        for(char ch: guess.toCharArray()){
        	if(dict.containsKey(ch) && dict.get(ch)>0){
        		cows++;
        		dict.put(ch, dict.get(ch)-1);
        	}
        }
        
        //计算bulls
        int len = secret.length();
        for(int i=0;i<len;i++){
        	if(secret.charAt(i)==guess.charAt(i)){
        		bulls++;
        	}
        }
        
        //计算cows
        cows -= bulls;
        return bulls+"A"+cows+"B";
        
    }
    
    public static void main(String [] args){
    	BullsAndCowsProblem299 bc = new BullsAndCowsProblem299();
//    	System.out.println(bc.getHint("1807", "7810"));
    	System.out.println(bc.getHint("1123", "0111"));
    }
}
