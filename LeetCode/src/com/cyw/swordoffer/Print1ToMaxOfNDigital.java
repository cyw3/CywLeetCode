package com.cyw.swordoffer;

/**
 * 输入数字n，按顺序打印从1到最大的n位十进制整数。比如输入3，则打印1、2、3，一直到最大的3
 * 位数999
 * @author cyw
 *
 *注意：需要考虑大数问题
 */
public class Print1ToMaxOfNDigital {

	public void print1ToMaxOfNDigital(int n){
		if(n<=0)
			return;
		//1、使用char[]来保存大数，每一个字符均是介于'0'到'9'之间的.各位初始化为'0'
		char[] number = new char[n];
		memset(number);
		
		//2、模拟加法，如何在O(1)时间内判断到达最大值
		while(!increment(number)){
			//3、打印，符合阅读习惯。比如前面没有0
			printNumber(number);
		}
		
	}

	//初始化为'0'
	public void memset(char[] number){
		int len = number.length;
		for(int i=0;i<len;i++){
			number[i] = '0';
		}
		System.out.println('0');
	}
	
	//模拟加法。最高位是否有进位
	private boolean increment(char[] number) {
//		if(number.length<=0)
//			return throw
		//溢出
		boolean isOverFlow = false;
		//进位
		int isTakeOver = 0;
		int len = number.length;
		
		for(int i=len-1;i>=0;i--){
			int sum = number[i] - '0' +isTakeOver;
			if(i==len-1) sum++;
			//
			if(sum>=10){
				if(i==0) isOverFlow=true;
				else{
					sum = sum-10;
					isTakeOver = 1;	
					number[i] = (char) (sum+'0');
				}
			}else{
				number[i] = (char) (sum+'0');
				break;
			}
		}
		return isOverFlow;
	}
	
	//3、打印，符合阅读习惯。比如前面没有0
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
		Print1ToMaxOfNDigital2 pt = new Print1ToMaxOfNDigital2();
		pt.print1ToMaxOfNDigital2(2);
	}
}
