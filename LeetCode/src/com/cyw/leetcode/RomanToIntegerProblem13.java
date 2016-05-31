package com.cyw.leetcode;

import java.util.HashMap;

public class RomanToIntegerProblem13 {

	public static void main(String[] args) {

	}
	/**
	 * I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)
	 * 右加左减。同级的只能理解为右
	 * 位于大数的后面时就作为加数；位于大数的前面就作为减数
	 * @param s
	 * @return
	 */
    public int romanToInt(String s) {
        if(s==null || s.length()<=0) return 0;
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        int len = s.length();
        int sum = dict.get(s.charAt(len-1));
        int pre = sum;
        //与前一个字符进行比较
        for(int i=len-2;i>=0;i--){
        	int tem = dict.get(s.charAt(i));
        	if(tem>=pre) sum += tem;
        	else if(tem<pre) sum -= tem;
        	pre = tem;
        }
        return sum;
    }
}
