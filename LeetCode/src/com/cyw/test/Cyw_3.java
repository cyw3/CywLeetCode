package com.cyw.test;

import java.util.HashMap;
import java.util.Map;

public class Cyw_3 {
	/*
	 * Longest Substring Without Repeating Characters 
	 * 滑动窗口法
	 * 
	 */
    public static int lengthOfLongestSubstring(String s) {
    	
    	int ans=0,start=0,end=0;
    	int length = s.length();
    	Map<String, Integer> countMap = new HashMap<String, Integer>();
    	
    	for(int i=0;i<length;i++){
    		end++;
    		countMap.put(s.charAt(i)+"", countMap.getOrDefault(s.charAt(i)+"", 0)+1);
    		//相当于截去重复了的一段。
    		//遍历该字符串中的所有不重复字符串。把原字符串分为一段一段的。
    		while(countMap.get(s.charAt(i)+"") > 1){
    			countMap.put(s.charAt(start)+"", countMap.get(s.charAt(start)+"")-1);
    			start++;
    		}
    		//关键是这个，将每一个不重复的字符串的长度 与 最长的 相比 将最长的长度存入ans之中
    		ans = Math.max(ans, end-start);
    	}
    	return ans;
    	
//    	int longest = 1;
//    	int length = s.length();
//    	int[] str = new int[length];
//    	for(int i=0;i<length-longest;i++){
//    		int index1 = s.indexOf(s.charAt(i));
//    		str[i] = s.indexOf(s.charAt(i), index1);
//    		if(longest <= str[i]-i){
//    			longest = str[i]-i;
//    		}
//    	}
//		return 0;
    }
    
    public static void main(String [] args){
    	System.out.println(lengthOfLongestSubstring("woowshicabeyqwwshicabe"));
    }
    
}
