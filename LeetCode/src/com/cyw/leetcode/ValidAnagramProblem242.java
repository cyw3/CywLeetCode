package com.cyw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidAnagramProblem242 {

	public static void main(String[] args) {

	}
	/**
	 * Given two strings s and t, write a function to determine if t is an anagram of s.
	 * 两字符串中各字符的出现次数一致
	 * 1、使用hashMap
	 * 2、对字符串 各字符进行排序，然后相互比较
	 * @param s
	 * @param t
	 * @return
	 */
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length()<0 || t.length()<0) return false;
        if(s.length()==0 && t.length()==0) return true;
        int sLen = s.length();
        int tLen = t.length();
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i=0;i<sLen;i++){
        	char tem = s.charAt(i);
        	dict.put(tem, dict.getOrDefault(tem, 0)+1);
        }
        for(int i=0;i<tLen;i++){
        	char tem = t.charAt(i);
        	if(!dict.containsKey(tem)) return false;
        	if(dict.get(tem)<=0) return false;
        	dict.put(tem, dict.get(tem)-1);
        }
        for(char i:dict.keySet()){
        	if(dict.get(i)>0) return false;
        }
        return true;
    }
}
