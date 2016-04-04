package com.cyw.algorithms;

import java.util.*;
import java.math.*;

/**
 * java.math包中的BigInteger和BigDecimal用来支持大数运算，
 * 这两个类可以处理包含任意长度数字序列的数值。
 * BigInteger实现了任意精度的整数运算，BigDecimal实现了任意精度的浮点数运算。
 * @author cyw
 *
 */
public class BigIntegerOp {
	//测试：9876543210987 1234567890
    public static void main(String args[]){
       Scanner cin = new Scanner(System.in);
       BigInteger a, b;
      
       //以文件EOF结束
       while (cin.hasNext()){
           a = cin.nextBigInteger();
           b = cin.nextBigInteger();
          
           System.out.println(a.add(b)); //大整数加法
           System.out.println(a.subtract(b)); //大整数减法
           System.out.println(a.multiply(b)); //大整数乘法
           System.out.println(a.divide(b)); //大整数除法(取整)
           System.out.println(a.remainder(b)); //大整数取模
          
           //大整数的比较
           if( a.compareTo(b) == 0 ) System.out.println("a == b"); //大整数a==b
           else if( a.compareTo(b) > 0 ) System.out.println("a > b"); //大整数a>b
           else if( a.compareTo(b) < 0 ) System.out.println("a < b"); //大整数a<b
          
           //大整数绝对值
           System.out.println(a.abs()); //大整数a的绝对值
          
           //大整数的幂
           int exponent=10;
           System.out.println(a.pow(exponent)); //大整数a的exponent次幂
          
           //返回大整数十进制的字符串表示
           System.out.println(a.toString());
          
           //返回大整数p进制的字符串表示
           int p=8;
           System.out.println(a.toString(p));
       }
    }
}