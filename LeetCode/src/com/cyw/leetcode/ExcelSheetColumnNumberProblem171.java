package com.cyw.leetcode;

public class ExcelSheetColumnNumberProblem171 {

	public static void main(String[] args) {
		System.out.println('Z'-'A');
	}
	/**
	 * Given a column title as appear in an Excel sheet, return its corresponding column number.
	 * @param s
	 * @return
	 */
    public int titleToNumber(String s) {
        if(s==null || s.length()<=0) return 0;
        int len = s.length();
        s = s.toUpperCase();
        int sum = 0;
        for(int i=0;i<len;i++){
        	int tem = s.charAt(i)-'A'+1;
        	if(tem<0 || tem>26) return 0;
        	sum = sum*26+tem;
        }
        return sum;
    }
}
