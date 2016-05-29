package com.cyw.leetcode;

public class AddDigitsProblem258 {
	/**
	 * 9的余数
	 * @param num
	 * @return
	 */
    public int addDigits(int num) {
    	if(num<=0) return 0;
    	if(num%9==0) return 9;
        return num%9;
    }
	public static void main(String[] args) {
		AddDigitsProblem258 ad = new AddDigitsProblem258();
		System.out.println(ad.addDigits(9));
	}

}
