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
	/**
	 * 法1、遍历O(n)
	 * 法2、二分查找法O(l	gn)
	 * 
	 */
    public int minNumberInRotateArray1(int [] array) {
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
    
    /**
     * 
     * @param array
     * @return
     * @throws Exception 
     */
    public int minNumberInRotateArray2(int [] array) throws Exception {
    	//三个指针，前中后
    	if(array==null || array.length<=0){
    		throw new Exception("array==null || array.length<=0");
    	}
    	int head = 0;
    	int last = array.length-1;
    	int mid = head;
    	
    	while(array[head]>=array[last]){
    		if(last-head==1){
    			mid = last;
    			break;
    		}
    		
    		mid = (head+last)/2;
    		if(array[mid]>=array[head]){
    			head = mid;
    		}else if(array[mid]<=array[last]){
    			last = mid;
    		}
    	}
		return array[mid];
    }
//    
//    正确做法需要分为：
//    1.数组为空
//    2.部分旋转，例如由（1,2,3,4,5）旋转为（3,4,5,1,2），此时只需要遍历数组，找到当前数比前面的数小的数即可。
//    3.完全旋转，例如由（1,2,3,4,5）旋转为（1,2,3,4,5），此时第一个数最小。
    public int minNumberInRotateArray3(int[] rotateArray) {
 
        //数组为空时
        if(rotateArray.length == 0)
            return -1;
        //前部分数据旋转
        for(int i = 0; i < rotateArray.length - 1; i++){
            if (rotateArray[i] > rotateArray[i + 1])
                return rotateArray[i + 1];
        }
        //全部数据旋转，相当于没有旋转，最小数即为第一个数
        return rotateArray[0];
    }
}
