package com.cyw.test;

public class Solution {
    public static boolean isPowerOfThree(int n) {
    	
//    	求对数,取结果中的整数，去掉小数，然后乘方，判断得数是否相等
//    	logx(y) =loge(x) / loge(y)，换底公式
//    	log() 是ln()
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
法2：
利用字典map保存num[i]到i的映射。
遍历查找数字i与目标数的“互补数”时只需查找map[target - num[i]]是否存在即可。
时间复杂度：O（n），因为dict的存取开销为O(1)
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
    	 //如果一个整数是2的幂，那么它的二进制形式最高位为1，其余各位为0
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