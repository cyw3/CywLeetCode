package com.cyw.leetcode;

public class CreateMaximumNumberProblem321 {

	public static void main(String[] args) {

	}
	/** 	
	 * 优先选大数。不够k的话，就退而求其次，往前查找。直到剩下的整数的个数==k
	 * @param nums1
	 * @param nums2
	 * @param k
	 * @return
	 */
	/*
	 :
这题的意思是
:
从两个数组按照原本的index 各自选出数字
:
然后组成的数字最大
:
开一个栈
:
每次往里面压入最大的数
:
但是要注意判断栈的深度要为k
:
A数组取i个 B数组取K-i个
:
嗯虽然思路很简单
:
就是贪心
:
但是代码很麻烦。。
:
或者还有一种思路是 两个数组分别贪心 然后merge
我:
贪心是要 优先取最大值是吗
:
嗯是的 就是比如当A取i个的时候 你开一个len为i的stack
:
然后往里面压
:
保证压进去的要比栈顶小
:
大的话就弹出栈顶 继续比
:
但是这里要注意 stack.len + A.len - k > i
:
这样就可以取到A取i个 B取k-i个的时候 两个数组单独的最优数组
:
然后两个merge
:
然后i: 0->k开始遍历
:
找到结果
:
复杂度大概K(N+M)
	 */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1==null || nums2==null || (nums1.length<=0 && nums2.length<=0)) return new int[0];
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[k];
        int index1 = 0;
        int index2 = 0;
//        int indexK = 0;
        for(int i=0;i<k;i++){
        	if(len1-index1+len2-index2==k-i) break;
        	
        }
        
        //比对，较大值写入result
        
    }
}
