package com.cyw.swordoffer;

public class MinNumberInRotateArray {
	/**
	 * 旋转数组的最小数字
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	 * 输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
	 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
	 * @param array 旋转数组
	 * @return
	 */
    public int minNumberInRotateArray(int [] array) {
    	int len = array.length;
    	if(array==null||len==0){  
    		return 0;
    	}
    	int i=len-1;
    	for(;i>0;i--){
    		if(array[i-1]>array[i])
    			break;
    	}
		return array[i];
    }
}
