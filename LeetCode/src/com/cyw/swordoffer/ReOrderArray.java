package com.cyw.swordoffer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分。
 * @author cyw
 *
 */
public class ReOrderArray {
	//一、若要求：保证奇数和奇数，偶数和偶数之间的相对位置不变。
	/**
	 * 法1、先遍历一遍统计奇数的个数，在重新创建一个数组，copy
	 * 
	 * @param array
	 */
    public int[] reOrderArray(int [] array) {
        int len = array.length;
        int count =0 ;
        for(int i=0;i<len;i++){
        	if((array[i] & 0x1)==1)
        		count++;
        }
        
        int[] result = new int[len];
        int j=0;
        int k=0;
        for(int i=0;i<len;i++){
        	if((array[i] & 0x1)==1){
        		result[j] = array[i];
        		j++;
        	}else{
        		result[count+k] = array[i];
        		k++;
        	}
        }
        return result;
    }
    
    /**
     * 法2、原址操作。
     * 遍历，遇到一个偶数便将该偶数之后的数前移一位，然后把该偶数移到 空出来的一位，也是最后一位。
     */
    public void reOrderArray(int [] array) {
    	if(array==null || array.length<=0)
    		return;
    	
    	int len = array.length;
    	for(int i=0;i<len;i++){
    		
    	}
    }
}
