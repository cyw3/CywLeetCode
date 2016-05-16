package com.cyw.algorithms.divideandconquer;

import java.util.Scanner;

/**
 * 输入正整数n（n的有效位数<=240），去掉其中任意s个数字之后，
 * 剩下的数字按原左右次序组成一个新的正整数。使这个正整数最小
 * @author cyw
 *
 */
public class StrMin {

	//思路是，因为前面的数对结果的影响比较大，所以要从左往右。
	//也就是 去掉山峰，
	//去掉从左边开始数, 左边大于右边的那个数，然后去掉 左边的数
	//178543、3113006292
	//char[]需要自定义toString方法，转换成String
	public static void   consequance(char[] str ,int n){
		if(str==null || str.length<=0 || n<=0 || str.length<n) return;
		
		char del=str[0];
		int i=1;
		//获取实际的字符串的长度。不包括串尾的空格
		int len = str.length;
		if(str[len-1]==' ') {
			for(int j=0;j<len;j++){
				if(str[j]==' ') {
					len = j;
					break;
				}
			}
		}
		//搜索山峰
		for(;i<len;i++) {
		  if(del<=str[i])
			  del=str[i];
		  else break;
		}
		//前移
		for(;i<len;i++){
			str[i-1] = str[i];
		}
		//
		str[len-1]=' ';
		n--;
		consequance(str,n);
	}
	
	public static void main(String [] args){
	   System.out.println("输入一个字符串:");
	   Scanner scanner = new Scanner(System.in); 
//	   StringBuffer sb=new StringBuffer();
	   String line = scanner.nextLine(); 
	   char a[]=line.toCharArray(); 
	   System.out.print(a); 
	   System.out.println("输入删除的位数n:");
	   Scanner input = new Scanner(System.in);
	   int n = input.nextInt();
	   consequance(a,n);
	   System.out.print(a); 
	}

}
