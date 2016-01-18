package com.cyw.algorithms;

public class Ext_Euclid {
	
	/**
	 * ·µ»ØµÄx, y, gcb(a, b)
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] getEx(int a, int b){
		int[] result = new int[3];
		if(b==0){
			result[0] = 1;
			result[1] = 0;
			result[2] = a;
			return result;
		}else{
			result = getEx(b, a%b);
			int t = result[0];
			result[0] = result[1];
			result[1] = t-(a/b)*result[1];
			return result;
		}
	}
	
	public static void main(String [] args){
		int[] result = getEx(17, 12);
		System.out.println(result[0]+" ;"+result[1]+" ;"+result[2]);
//		System.out.println(Math.pow(2,3));
	}

}
