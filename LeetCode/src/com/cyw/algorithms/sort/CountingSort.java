package com.cyw.algorithms.sort;

/**
 * 计数排序
 * @author cyw
 *
 */
public class CountingSort {

	//k是说A数组中的数值均在0到k的范围内
	public static int[] countingSort(int[] A, int k){
		int[] C = new int[k];
		for(int i=0;i<k;i++){
			C[i]=0;
		}
		for(int j=0;j<A.length;j++){
			//以元素值作为索引下标，记录数值出现的次数
			C[A[j]] ++;
		}
		
		for(int i=0;i<k;i++){
			//确定小于x的元素的个数，即即将存放的位置
			C[i]=C[i] +C[i-1];
		}
		int[] B = new int[A.length];
		for(int j=A.length-1;j>=0;j--){
			B[C[A[j]]] = A[j];
			//应对相同的数值，按位置递减
			C[A[j]]--;
		}
		return B;
	}
}
