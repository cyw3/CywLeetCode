package com.cyw.test;

public class Cyw_326 {
    public static boolean isPowerOfThree(int n) {
//    	求对数,取结果中的整数，去掉小数，然后乘方，判断得数是否相等
//    	logx(y) =loge(x) / loge(y)，换底公式
//    	log() 是ln()
    		return Math.pow(3,Math.round(Math.log(n)/Math.log(3)))==n && n>0;
    }
}
