package com.cyw.algorithms.sort;

/**
 * 快速排序
 * 分治方法 theta(nlgn)，这是比较排序算法的下界
 * 
 * 最坏情况：theta(n^2),此时已经完全有序。这是可以使用随机算法，设置一个随机的主元
 * 将数组A[p..r]划分为两部分(可能为空)子数组A[p..q-1] 和 A[q+1..r]，使得A[p..q-1]中的每一个元素都小于
 * 等于A[q], 而A[q]小于等于A[q+1..r]中的每一个元素
 * @author cyw
 *
 */
public class QuickSort {
	public static int[] quickSort(int[] A, int p, int r){
		if(p<r){
			int[] B = new int[A.length];
			int[] C = new int[A.length];
			int q=partition(A, p, r);
			B = quickSort(A, p, q-1);
			C = quickSort(A, q+1, r);
			
			for(int i=p;i<q;i++){
				A[i] = B[i];
			}
			for(int i=q+1;i<=r;i++){
				A[i] = C[i];
			}
			return A;
		}
		return A;
	}

	//A[r]为主元x
	private static int partition(int[] A, int p, int r) {
		int x=A[r];
		int i=p-1;
		for(int j=p;j<=r-1;j++){
			if(A[j]<=x){
				i++;
				//exchange A[i] with A[j]
				A[i] = A[i] ^ A[j];
				A[j] = A[i] ^ A[j];
				A[i] = A[i] ^ A[j];
			}
		}
		A[i+1] = A[i+1] ^ A[r];
		A[r] = A[i+1] ^ A[r];
		A[i+1] = A[i+1] ^ A[r];
		return i+1;
	}
	
	public static void main(String [] args){
		int[] A = {5, 2, 4, 6, 1, 3};
		int[] B = quickSort(A, 0, A.length-1);
		for(int i=0;i<B.length;i++){
			System.out.print(B[i]);
		}
	}
}
