package com.cyw.algorithms;

import java.util.*;

/*
 * 将一个正整数分解质因数
 * 每个合数都可以写成几个质数相乘的形式，这几个质数就都叫做这个合数的质因数
 */
public class IntegerFactorization {

	public static void main(String[] args) {
		primeFactor();// 调用primeFactor()方法
	}

	/*
	 * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
	 * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
	 * (2)如果n>=k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数你n,重复执行第一步。&nbsp;&nbsp;&nbsp;
	 * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。&nbsp;&nbsp;
	 */
	public static void primeFactor() {// 该方法将一个正整数分解成质因数相乘的形式

		Scanner scan = new Scanner(System.in);// 接收控制台输入的信息
		System.out.print("请输入一个正整数：");

		try {
			int num = scan.nextInt();// 取出控制台输入的信息

			if (num < 2) {// 若输入的数小于2,输出提示信息

				System.out.println("必须输入不小于2的正整数！");
			} else {
				integerFactor(num);
			}
		} catch (Exception e) {
			System.out.println("必须输入正整数！");// 捕捉异常,输出必须输入整数
		}
	}
	
	/**
	 * 直接将质因数输出
	 * @param num
	 */
	public static void integerFactor(int num){

		int primeNumber = 2;// 定义最小的质数
		System.out.print(num + " = ");
		
		while (primeNumber <= num) {// 在质数小于输入的数时，进行循环

			if (primeNumber == num) {// 当质数等于输入的数时,直接输出

				System.out.print(num);
				break;// 跳出循环

			} else if (num % primeNumber == 0) {// 当输入的数与质数的余数为0时,输出这个质数

				System.out.print(primeNumber + " * ");
				num = num / primeNumber;// 把剩下的结果赋给num
				
			} else {// 在余数不为0时,质数递增。从小的开始，先算小的。自然是质数
				primeNumber++;
//				System.out.println("primeNumber:"+primeNumber);
			}
		}
	
	}
}
