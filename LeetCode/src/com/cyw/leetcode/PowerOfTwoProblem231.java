package com.cyw.leetcode;

public class PowerOfTwoProblem231 {
    public boolean isPowerOfTwo(int n) {
   	 //���һ��������2���ݣ���ô���Ķ�������ʽ���λΪ1�������λΪ0
       return (n > 0 && ((n&(n - 1))==0));
   }
}
