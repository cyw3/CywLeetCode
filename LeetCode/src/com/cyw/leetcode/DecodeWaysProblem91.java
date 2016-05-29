package com.cyw.leetcode;

public class DecodeWaysProblem91 {

	/**
	 A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
反编码
"12"： "AB" (1 2) or "L" (12).  反编码方式的个数
	 * @param s
	 * @return
	 */
    public int numDecodings(String s) {
    	if(s==null || s.length()<=0) return 0;
    	//1-26。其实是对字符串数的一个分段。跟IP分割一样
    	//每次取一个字符或者两个字符
    	int len = s.length();
    	int[] cache = new int[len];
    	if(s.charAt(0)!='0') cache[0] = 1;
    	else return 0;
    	if(s.length()==1) return cache[0];
    	//各位个数不能为0
    	//分割一个字符
    	if(s.charAt(1)!='0') cache[1] = cache[0];
    	else cache[1] = 0;
    	//分割两个字符  注意前面不能从0开始
    	int tem = Integer.parseInt(s.substring(0, 2));
    	if(tem>0 && tem<=26 ) cache[1] += 1;
//    	else cache[1] = 1;
    	if(cache[1]==0) return 0;
    	for(int i=2;i<len;i++){
    		//分割一个字符
    		if(s.charAt(i)!='0') cache[i] = cache[i-1];
    		else cache[i] = 0;
    		
    		//分割两个字符  注意前面不能从0开始
    		int temp = Integer.parseInt(s.substring(i-1, i+1));
    		if(temp>0 && temp<=26 && s.charAt(i-1)!='0') cache[i] += cache[i-2];
    		
    		if(cache[1]==0) return 0;
    	}
        return cache[len-1];
    }
	
	public static void main(String[] args) {
		DecodeWaysProblem91 de = new DecodeWaysProblem91();
		//自己多想一下test cases
		//12  ""  0 1 10 101  100  301 30
		System.out.println(de.numDecodings("301"));
	}

}
