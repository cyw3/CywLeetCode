package com.cyw.leetcode;

public class Solution {
    public static boolean isPowerOfThree(int n) {
    	
//    	�����,ȡ����е�������ȥ��С����Ȼ��˷����жϵ����Ƿ����
//    	logx(y) =loge(x) / loge(y)�����׹�ʽ
//    	log() ��ln()
    		return Math.pow(3,Math.round(Math.log(n)/Math.log(3)))==n && n>0;
    	
//    	boolean result = false;
//        if(n%3==0 && n!=1){
//        	result = isPowerOfThree(n/3);
//        }
//        else if(n==1){
//        	return true;
//        }else
//        	return false;
//        if(result)
//        	return true;
//        else 
//        	return false;
    }
    /*
��2��
�����ֵ�map����num[i]��i��ӳ�䡣
������������i��Ŀ�����ġ���������ʱֻ�����map[target - num[i]]�Ƿ���ڼ��ɡ�
ʱ�临�Ӷȣ�O��n������Ϊdict�Ĵ�ȡ����ΪO(1)
class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        map = dict()
        size = len(num)
        for x in range(size):
            map[num[x]] = x
        for x in range(size):
            idx1 = x
            idx2 = map.get(target - num[x])
            if idx2:
                return idx1 + 1, idx2 + 1
     */
    public static int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        int length = nums.length;
        boolean status = false;
        int i=0,j=1;
        for(;i<length-1;i++){
        	for(j=i+1;j<length;j++){
        		if(nums[i]+nums[j]==target){
        			status = true;
        			break;
        		}
        	}
    		if(status){
    			break;
    		}
        }
//        if(nums[i]<=nums[j]){
//        	result[0]=++i;
//        	result[1]=++j;
//        }else{
//        	result[0]=++j;
//        	result[1]=++i;
//        }
    	result[0]=++i;
    	result[1]=++j;
        return result;
        
    }
    
    public static boolean isPowerOfTwo(int n) {
    	 //���һ��������2���ݣ���ô���Ķ�������ʽ���λΪ1�������λΪ0
        return (n > 0 && ((n&(n - 1))==0));
    }
    
    public static void main(String [] args){
    	
//    	System.out.println();
    	
    	int[] num = {-1,-2,-3,-4,-5};
    	int[] result = twoSum(num,-8);
    	System.out.println(result[0]+" ;"+result[1]);
    	
    	if(isPowerOfThree(27))
    		System.out.println("True");
    	else
    		System.out.println("False");
    }
}