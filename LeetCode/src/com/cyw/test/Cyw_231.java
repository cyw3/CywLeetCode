package com.cyw.test;

public class Cyw_231 {
    public boolean isPowerOfTwo(int n) {
   	 //如果一个整数是2的幂，那么它的二进制形式最高位为1，其余各位为0
       return (n > 0 && ((n&(n - 1))==0));
   }
}
