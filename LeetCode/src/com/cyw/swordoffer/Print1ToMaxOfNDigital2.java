package com.cyw.swordoffer;

public class Print1ToMaxOfNDigital2 {

	/**
	 * 法2、使用递归,进行全排列
	 * 不需要使用 模拟加法
	 * @param args
	 */
	public void print1ToMaxOfNDigital2(int n){
		if(n<=0)
			return;
		
		char[] number = new char[n];
		
		print1ToMaxOfNDigitalRecursively(number,0);
		
	}
	
	public void print1ToMaxOfNDigitalRecursively(char[] number, int index){
		
		if(index==number.length){
			printNumber(number);
			return;
		}
		
		for(int i=0;i<10;i++){
			number[index] = (char) ('0' + i);
			print1ToMaxOfNDigitalRecursively(number,index+1);
		}
		return;
	}
	private void printNumber(char[] number) {
		int len = number.length;
		boolean isBeginning = false;
		for(int i=0;i<len;i++){
			if(!isBeginning && number[i]!='0') isBeginning=true;
			if(isBeginning)
				System.out.print(number[i]);
		}
		System.out.println();
	}
	
	
	public static void main(String [] args){
		Print1ToMaxOfNDigital pt = new Print1ToMaxOfNDigital();
		pt.print1ToMaxOfNDigital(2);
	}
}
