package com.cyw.algorithms.sort;

/**
 * 分治法
 * @author cyw
 * 归并排序
 */
public class MergeSort {

	/*
	 * A[p..q]   A[q+1..r]
	 * 
	 * 在牌底安放一个 哨兵牌 检查该堆是否为空
	 * 
	 * theta(n)
	 * 		分解待排序的n个元素的序列成个具有n/2个元素的子序列
	 * 		当待排序的序列长度为1时，递归开始“回升”
	 * 
	 * 类似于扑克牌排序。
	 * 假设桌上有两对牌面朝上的牌，没对都已经排好序，最小的牌在牌顶
	 * 每次选出两堆牌中顶上两张牌的较小的一张。
	 */
	public static int[] merge(int[] A, int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		//分为左右序列
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for(int i=0;i<n1;i++){
			L[i] = A[p+i];
		}
		for(int i=0;i<n2;i++){
			R[i] = A[q+1+i];
		}
		L[n1]=Integer.MAX_VALUE;
		R[n2]=Integer.MAX_VALUE;
		
		int i=0;
		int j=0;
		for(int k=p;k<=r;k++){
			if(L[i]<R[j]){
				A[k] = L[i];
				i++;
			}else{
				A[k] = R[j];
				j++;
			}
		}
		
		return A;
	}

	//theta(nlg(n))
	private static int[] mergeSort(int[] A, int p, int r) {
		int q = 0;
		if(p<r){
			q = (p+r)/2;
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
		return A;
	}
	
	public static void main(String [] args){
		int[] A = new int[]{5, 2, 4, 6, 1, 3};
		int[] B = mergeSort(A,0,5);
		for(int i=0;i<B.length;i++){
			System.out.print(B[i]);
		}
		
//		int x = 10;
//		int y = 20;
//		x = x ^ y;
//		y = x ^ y;
//		x = x ^ y;
//		System.out.println(x+";"+y);
	}

}
