package com.cyw.swordoffer;

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * @author cyw
 *
 */
public class RectCover {
	//1、最忧子结构		2、子问题重叠
	//所以，也是动态规划的问题
	//其实也是减一减二的问题，也是斐波那契数列
    public int RectCover(int target) {
    	if(target<=0)
    		return 0;
    	if(target==1)
    		return 1;
    	if(target==2)
    		return 2;
    	
    	int[] temp = new int[target+1];
    	temp[0] = 0;
    	temp[1] = 1;
    	temp[2] = 2;
    	
    	int i = 3;
    	while(i<=target){
    		temp[i] = temp[i-1]+temp[i-2];
    		i++;
    	}
    	return temp[target];
    }
}
