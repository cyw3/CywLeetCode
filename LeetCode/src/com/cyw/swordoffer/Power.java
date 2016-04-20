package com.cyw.swordoffer;

/**
 * 数值的''''整数''''次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author cyw
 *
 */
public class Power {
	/**
	 * 需要注意
	 * 1、代码的规范性以及完整性。指数小于1时，底数为0时
	 * 2、细节重视
	 * 当指数大于0小于1时候呢？因为这次是整数平方，所以没有考虑
	 * @param base
	 * @param exponent
	 * @return
	 */
    public double Power(double base, int exponent) {
    	if(equal(base, 0.0)&&exponent<0){
    		return 0.0;
    	}
    	
    	if(exponent==0){
    		return 1.0;
    	}
    	
    	int absExponent = Math.abs(exponent);
    	double result = powerWithabsEx(base, absExponent);
    	if(exponent<0){
    		result = 1.0/result;
    	}
    	return result;
    }
    
    /**
     * 计算机表示小数有误差。如果两个小数的差值的绝对值小于一定范围，便可以认为相等
     * @param a
     * @param b
     * @return
     */
    public boolean equal(double a, double b){
    	if(a-b>-0.0000001 && a-b<0.0000001)
    		return true;
    	else
    		return false;
    }
    
    /**
     * 遍历。有效但是不够高效
     * @param base
     * @param absEx
     * @return
     */
//    public double powerWithabsEx(double base, int absEx){
//    	double result = 1.0;
//    	for(int i=0;i<absEx;i++){
//    		result *= base;
//    	}
//    	return result;
//    }
    
    /**
     * a^n = 
     * 			a^(n/2)*a^(n/2)		n为偶数
     * 			a^((n-1)/2)*a^((n-1)/2)*a			n为奇数
     * 
     * 递归
     * @param base
     * @param absEx
     * @return
     */
    public double powerWithabsEx(double base, int absEx){
    	if(absEx==0)
    		return 1.0;
    	if(absEx==1)
    		return base;
    	//向下取整
    	double result = powerWithabsEx(base, absEx>>1);
    	result *= result;
    	//奇数
    	if((absEx & 0x1) == 1){
    		result *= base;
    	}
    	return result;
    		
    }
}
