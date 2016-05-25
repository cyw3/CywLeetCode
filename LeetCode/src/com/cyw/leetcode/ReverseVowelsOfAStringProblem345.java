package com.cyw.leetcode;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Given s = "leetcode", return "leotcede".
 * @author cyw
 * 使用两个指针，头尾
 */
public class ReverseVowelsOfAStringProblem345 {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = ch.length-1;
        while(start<end){
        	while(start>=0 && start<end&& 
        			ch[start]!='a'&&ch[start]!='A' &&
        			ch[start]!='e' && ch[start]!='E' &&
        			ch[start]!='i' && ch[start]!='I' &&
        			ch[start]!='o' && ch[start]!='O' &&
        			ch[start]!='u' && ch[start]!='U')
        		start++;
//        	System.out.println("start:"+start);
        	while(start<end&&end< ch.length && 
        			ch[end]!='a'&&ch[end]!='A' &&
        			ch[end]!='e' && ch[end]!='E' &&
        			ch[end]!='i' && ch[end]!='I' &&
        			ch[end]!='o' && ch[end]!='O' &&
        			ch[end]!='u' && ch[end]!='U')
        		end--;
//        	System.out.println("end:"+end);
        	if(start<end){
        		ch[start] = (char) (ch[start]^ch[end]);
        		ch[end] = (char) (ch[start]^ch[end]);
        		ch[start] = (char) (ch[start]^ch[end]);
        		start++;
        		end--;
        	}
        }
        return new String(ch);
    }
    
    public static void main(String [] args){
    	ReverseVowelsOfAStringProblem345 rs = new ReverseVowelsOfAStringProblem345();
//    	System.out.println(5>>1);
    	System.out.println(rs.reverseVowels("leetcode"));
    }
}
