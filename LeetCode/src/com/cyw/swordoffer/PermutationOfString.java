package com.cyw.swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。 
 * 结果请按字母顺序输出。 
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @author cyw
 *
 */
public class PermutationOfString {
	/**
	 * 递归。子问题.全排列
	 * 第一个位置的字符，即吧第一个字符和后面所有的字符  交换
	 * n!
	 * @param str
	 * @return
	 */
    public ArrayList<String> Permutation(String str) {
        if(str==null || str.length()<=0) return new ArrayList<String>();
        
        ArrayList<String> result = new ArrayList<String>();
        StringBuffer string = new StringBuffer(str);
        permutationOfString(string, 0, result);
        Collections.sort(result);
//        result.sort(null);
        return result;
    }
    
    public void permutationOfString(StringBuffer str, int start, ArrayList<String> result){
    	if(str==null || start<0 || result==null) return;
    	
    	int len = str.length();
    	if(start>=len-1){
    		result.add(str.toString());
    		return;
    	}
//    	包括与自己替换
    	for(int i=start;i<len;i++){
    		char temp = str.charAt(i);
    		if(i>start && temp==str.charAt(start)) continue;
    		str.setCharAt(i, str.charAt(start));
    		str.setCharAt(start, temp);
    		
    		permutationOfString(str, start+1, result);
    		
    		temp = str.charAt(i);
    		str.setCharAt(i, str.charAt(start));
    		str.setCharAt(start, temp);
    		
    	}
    }
    
    public static void main(String [] args){
    	PermutationOfString pos = new PermutationOfString();
    	ArrayList<String> result = pos.Permutation("abc");
    	Iterator<String> it = result.iterator();
    	while(it.hasNext()){
    		System.out.println(it.next());
    	}
    }
}
