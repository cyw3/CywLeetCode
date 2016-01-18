package com.cyw.algorithms;

import java.util.Scanner;

//质数又称素数,是指在一个大于1的自然数中，除了1和此整数自身外，不能被其他自然数整除的数
public class PrimeNumber {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);// 扫描器，接收控制台输入信息

		System.out.print("请输入一个整数：");

		try {
			int num = scan.nextInt();// 取出控制台输入的信息
			if (isPrime(num)) {// 调用isPrime()方法

				System.out.println(num + "是素数！");// 若isPrime()方法返回true,输出是素数

			} else {

				System.out.println(num + "不是素数！");// 若isPrime()方法返回false,输出不是素数
			}
		} catch (Exception e) {
			System.out.println("请输入整数");// 捕捉异常，若输入的不是整数，输出异常
		}
	}

	/**
	 * <pre>
	 * 用于判断一个数是否为素数，若为素数，返回true,否则返回false
	 * </pre>
	 * 
	 * @param a
	 *            输入的值
	 * @return true、false
	 */
	public static boolean isPrime(int a) {

		boolean flag = true;

		if (a < 2) {// 素数不小于2
			return false;
		} else {

			for (int i = 2; i <= Math.sqrt(a); i++) {
				if (a % i == 0) {// 若能被整除，则说明不是素数，返回false
					flag = false;
					break;// 跳出循环
				}
			}
		}
		return flag;
	}
}

