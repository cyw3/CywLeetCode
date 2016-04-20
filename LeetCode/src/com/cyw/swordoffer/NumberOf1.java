package com.cyw.swordoffer;

/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author cyw
 *
 */
public class NumberOf1 {
	
	/**
	 * 法1、使用位运算操作符，右移，与1
	 * 缺陷：因为负数要保证最高位为1，所以可能会陷入死循环；
	 * @param n
	 * @return
	 */
	public int  NumberOf1(int n) {
        int count = 0;
        while(n!=0){
        	if((n&1)==1){
        		count++;
        	}
        	n = n>>1;
        }
        return count;
    }
	
	/**
	 * 法二，基于法1，但是移位的不是输入n，而是比较的1，左移
	 * java不支持无符号整型
	 * @param n
	 * @return
	 */
	public static int  NumberOf12(int n) {
		int count = 0;
		int flag = 1;
		while(flag!=0){
			if((n & flag)!=0)
				count++;
			flag = flag << 1;
//			System.out.println(flag);
//			System.out.println("count:"+count);
		}
//		if(n<0)
//			count++;
		return count;
	}
	
	/**
	 * 法3、把一个整数减一，再和原整数做与运算，会把该整数最右边的1变成0
	 * 那么这个整数有多少1，便可以进行多少次这样的操作。
	 * @param n
	 * @return
	 */
	public static int  NumberOf13(int n) {
		int count = 0;
		while(n!=0){
			n = (n-1)&n;
			count++;
		}
		return count;
	}
	
	public static void main(String [] args){
		int n = -1;//负数使用补码，所以此时是32位的1
		System.out.println(Integer.toBinaryString(-1));
//		System.out.println(NumberOf12(n));
	}
}
