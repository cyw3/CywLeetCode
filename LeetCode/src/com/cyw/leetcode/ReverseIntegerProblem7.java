package com.cyw.leetcode;

public class ReverseIntegerProblem7 {
	/*
	 * Reverse digits of an integer.
	 * Example1: x = 123, return 321
	 * Example2: x = -123, return -321
	 */
    public static int reverse(int x) {
    	
    	//when x is larger than Integer.MAX_VALUE
    	//for example,9646324351
    	//Integer.MAX_VAVLUE=2e31-1,MIN_VALUE =-2e31
    	
		 int rev = 0;
		 while(x!=0)
		 {
			 //���ڿ�Ҫ���߽��ʱ�����10 ��������������⡣���Լ�������������
			 //������ת�����ֽӽ�Integer.MAX_VALUE����Integer.MAX_VALUE�ı�С��10ʱ���������0
			 if (rev != 0 && Integer.MAX_VALUE / rev < 10
	                   && Integer.MAX_VALUE / rev > -10)
	               return 0;
			 rev = rev*10 + x%10;
			 x = x/10;
		 }
		 
		 return rev;	
    	
//    	�ڶ�
//        int negative=1;  
//        if( x<0 ) {  
//            negative = -1;  
//            x = -x;  
//        }  
//          
//        long y = x%10;  
//          
//        while( x/10 != 0 ) {  
//            x /= 10;  
//            y *= 10;  
//            y += x%10;  
//        }  
//          
//        if(y>Integer.MAX_VALUE) {  
//            return -1;  
//        } else {  
//            return (int) (negative*y);  
//        }  
    	
//    	��һ
//    	if(x<0){
//        	Integer in = -x;
//        	String str = new StringBuffer(in.toString()).reverse().toString();
//    		return -(Integer.parseInt(str));
//    	}
//    	Integer in = x;
//    	String str = new StringBuffer(in.toString()).reverse().toString();
//		return Integer.parseInt(str);
    }
    
    public static void main(String [] args){
//    	System.out.println(Integer.MIN_VALUE==(1<<63));
//    	System.out.println(Integer.MAX_VALUE);
//    	System.out.println(-8>>1);
//    	Integer in = 123;
//    	System.out.println(in.toString());
//    	System.out.println(Integer.parseUnsignedInt("9646324351"));
    	System.out.println(reverse(-123));
    }

}
