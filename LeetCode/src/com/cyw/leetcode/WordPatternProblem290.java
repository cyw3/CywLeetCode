package com.cyw.leetcode;

import java.util.HashMap;

public class WordPatternProblem290 {
	//以pattern为基准建立词典。并对应的进行匹配
    public boolean wordPattern(String pattern, String str) {
        if(pattern==null || str==null) return false;
        String[] word = str.split(" ");
        if(word.length != pattern.length()) return false;
        
        HashMap<Character, String> dict = new HashMap<Character, String>();
        int len = pattern.length();
        for(int i=0;i<len;i++){
        	char ch = pattern.charAt(i);
        	if(dict.containsKey(ch)){
        		if(!word[i].equals(dict.get(ch))) return false;
        	}else{
        		//包含的word需要与之前的不一样
        		for(char c : dict.keySet()){
        			if(dict.get(c).equals(word[i])) return false;
        		}
        		dict.put(ch, word[i]);
        	}
        }
        return true;
    }
    
    public static void main(String [] Args){
    	WordPatternProblem290 wo = new WordPatternProblem290();
    	System.out.println(wo.wordPattern("abba", "dog cat cat dog"));
    	System.out.println(wo.wordPattern("abba", "dog cat cat fish"));
    	System.out.println(wo.wordPattern("aaaa", "dog cat cat dog"));
    	System.out.println(wo.wordPattern("abba", "dog dog dog dog")); 	
    	
    }
}
