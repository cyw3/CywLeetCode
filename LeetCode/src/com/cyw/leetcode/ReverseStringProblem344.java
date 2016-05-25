package com.cyw.leetcode;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * Given s = "hello", return "olleh".
 * @author cyw
 *
 */
public class ReverseStringProblem344 {
    public String reverseString(String s) {
    	char[] ch=s.toCharArray();
    	int len = ch.length>>1;
    	int leng = ch.length;
    	for(int i=0;i<len;i++){
//    		ch[i] = (char) (ch[i] + ch[leng-1-i]);
//    		ch[leng-1-i] = (char) (ch[i]-ch[leng-1-i]);
//    		ch[i] = (char) (ch[i]-ch[leng-1-i]);
    		ch[i] = (char) (ch[i] ^ ch[leng-1-i]);
    		ch[leng-1-i] = (char) (ch[i]^ch[leng-1-i]);
    		ch[i] = (char) (ch[i]^ch[leng-1-i]);
    	}
    	String s1 = new String(ch);
        return s1;
    }
    
    public static void main(String [] args){
    	ReverseStringProblem344 rs = new ReverseStringProblem344();
//    	System.out.println(5>>1);
    	System.out.println(rs.reverseString("hello"));
    }
}
