package com.cyw.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersProblem3 {
	/*
	 * Longest Substring Without Repeating Characters 
	 * �������ڷ�
	 * 
	 */
    public static int lengthOfLongestSubstring(String s) {
    	
    	int ans=0,start=0,end=0;
    	int length = s.length();
    	Map<String, Integer> countMap = new HashMap<String, Integer>();
    	
    	for(int i=0;i<length;i++){
    		end++;
    		countMap.put(s.charAt(i)+"", countMap.getOrDefault(s.charAt(i)+"", 0)+1);
    		//�൱�ڽ�ȥ�ظ��˵�һ�Ρ�
    		//�������ַ����е����в��ظ��ַ�������ԭ�ַ�����Ϊһ��һ�εġ�
    		while(countMap.get(s.charAt(i)+"") > 1){
    			countMap.put(s.charAt(start)+"", countMap.get(s.charAt(start)+"")-1);
    			start++;
    		}
    		//�ؼ����������ÿһ�����ظ����ַ����ĳ��� �� ��� ��� ����ĳ��ȴ���ans֮��
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
