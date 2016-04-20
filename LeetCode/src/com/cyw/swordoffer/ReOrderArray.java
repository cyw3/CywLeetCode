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
	 * 时间复杂度O(n)，空间复杂度O(n)
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
     * 法2、原址操作。时间复杂度是O(n^2)
     * 遍历，遇到一个偶数便将该偶数之后的数前移一位，然后把该偶数移到 空出来的一位，也是最后一位。
     */
    public static void reOrderArray2(int [] array) {
    	if(array==null || array.length<=0)
    		return;
    	
    	int len = array.length;
    	int tail = len-1;
    	int head = 0;
    	int temp = array[0];
    	while(head<=tail){
    		//偶数
    		if((array[head] & 0x1) != 1){
    			temp = array[head];
    			for(int i=head+1;i<len;i++){
    				array[i-1] = array[i];
    			}
    			array[len-1] = temp;
    			tail--;
    			head--;
    			System.out.println("tail:"+tail);
    		}
    		head++;
    		System.out.println("head:"+head);
    	}
    	return;
    }
    
  //二、若不要求：保证奇数和奇数，偶数和偶数之间的相对位置不变。
    /**
     * 维护两个指针（1偶2奇直到相遇），交换
     * @param array
     */
    public static void reOrderArray3(int [] array) {
    	if(array==null || array.length<=0)
    		return;
    	
    	int len = array.length;
    	int start = 0;
    	int end = len-1;
    	while(start<end){
    		//直到遇到偶数
    		while(start<end && (array[start] & 0x1)==1)
    			start++;
    		//直到遇到奇数
    		while(start<end && (array[end] & 0x1)==0)
    			end--;
    		//交换
    		if(start<end){
    			array[start] = array[start]^array[end];
        		array[end] = array[start]^array[end];
        		array[start] = array[start]^array[end];
    		}
    	}
    	return;
    }
    
    //具有扩展性的.此处的可以定义一个带有特定自定义判定标准的类，并实例化，传参到这个方法中，在调用特定方法。
//    或者，使用接口
    public static void reOrderArray4(int [] array, Stanstart st) {
    	if(array==null || array.length<=0)
    		return;
    	
    	int len = array.length;
    	int start = 0;
    	int end = len-1;
    	while(start<end){
    		//直到遇到偶数
    		while(start<end && !st.func(array[start]))
    			start++;
    		//直到遇到奇数
    		while(start<end && st.func(array[end]))
    			end--;
    		//交换
    		if(start<end){
    			array[start] = array[start]^array[end];
        		array[end] = array[start]^array[end];
        		array[start] = array[start]^array[end];
    		}
    	}
    	return;
    }
    public class Stanstart{
        //判定标准,可自定义
//    	isEven
        public boolean func(int a){
        	//是否是偶数
        	//是
        	if((a & 0x1)==0)
        		return true;
        	else
        		return false;
        }
    }
    

    
    
    public static void main(String [] args){
//    	[2,4,6,1,3,5,7]——》[1,3,5,7,2,4,6]
    	int[] test = {2,4,6,1,3,5,7};
    	reOrderArray3(test);
    	for(int i=0;i<test.length;i++){
    		System.out.print(test[i]);
    	}
//    	int a=1,b=2;
//    	a = a^b;
//    	b = a^b;
//    	a = a^b;
//    	System.out.println("a:"+a);
//    	System.out.println("b:"+b);
    }
}
