package com.cyw.algorithms.sort;

/**
 * 插入排序
 * @author cyw
 * 
 * 一般用于元素个数小于7的子数组的排序
 * 
 * 具有最坏运行时间theta(n^2)
 * 基本思路是：
 * 		排序一首扑克牌。
 * 		开始时，左手为空，并且桌上牌面朝下
 * 		每次从桌上牌面拿走一张牌 ，从右至左比较，插到合适的位置
 */
public class InsertionSort {

	//原址排序
	//1、
//	public static int[] insertionSort(int[] A){
//		int key = 0 ;
//		for(int j=1;j<A.length;j++){
//			key = A[j];
//			int i = j-1;
//			while(i>=0 && A[i]>key){
//				A[i+1]=A[i];
//				i--;
//			}
//			A[i+1] = key;
//		}
//		return A;
//	}
	
	//2\
	public static void insertionSort(int[] x, int off, int len){
		if(x==null || off<0 || off+len>x.length) return;
		for(int i=off;i<off+len;i++)
			for(int j=i;j>off&&x[j-1]>x[j];j--)
				swap(x, j, j-1);
		
	}
	
	private static void swap(int[] x, int a, int b) {
		int tem = x[a];
		x[a] = x[b];
		x[b] = tem;
	}

	//test
	public static void main(String [] args){
		int[] A = new int[]{5, 2, 4, 6, 1, 3};
		insertionSort(A, 0, A.length);
		for(int i=0;i<A.length;i++){
		System.out.print(A[i]);
	}
		
//		int[] B = insertionSort(A);
//		for(int i=0;i<B.length;i++){
//			System.out.print(B[i]);
//		}
	}
}
