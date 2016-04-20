package com.cyw.algorithms.sort;

/**
 * (二叉)堆是一个数组，可以被看成一个近似的完全的二叉树，树上的每一个节点对应数组中的一个元素。
 * 除了最底层外，该树是完全充满的，而且是从左到右填充。树的根节点是A[1]，
 * @author cyw
 *堆排序，原址排序
 */
public class HeapSort {
	
	//以下是计算得到某结点的父结点、左孩子、右孩子的下标
	public static int parent(int i){
		return i/2;
	}
	public static int left(int i){
		return 2*i;
	}
	public static int right(int i){
		return 2*i+1;
	}
	
	//最大堆性质。O(lgn)
	//递归，逐级下降
	public static int[] maxHeapify(int[] A, int i){
		int l = left(i);
		int r = right(i);
		int largest = i;
		if(l<=A.length-1 && A[l]>A[i]){
			largest = l;
		}else{
			largest=i;
		}
		if(r<=A.length-1 && A[r]>A[largest]){
			largest = r;
		}
		if(largest!=i){
			//exchange A[i] and A[largest]
			//第一种方法
			A[i] = A[i]+A[largest];
			A[largest] = A[i] - A[largest];
			A[i] = A[i]-A[largest];
			
			//第二种方法
//			A[i] = A[i] ^ A[largest];
//			A[largest] = A[i] ^ A[largest];
//			A[i] = A[i] ^ A[largest];
			
			A = maxHeapify(A, largest);
		}
		return A;
	}
	
	//建堆O（n）
	public static int[] buildMaxHeap(int[] A){
		for(int i=A.length/2-1;i>=0;i--){
			A = maxHeapify(A, i);
		}
		return A;
	}
	
//	public static int[] heapSort(int[] A){
//		A = buildMaxHeap(A);
//		for(int i=A.length-1;i<=1;i--){
//			//exchange A[i] with A[1]
//			A[i] = A[i] ^ A[1];
//			A[1] = A[i] ^ A[1];
//			A[i] = A[i] ^ A[1];
//			
//			
//		}
//	}
	
	public static void main(String [] args){
		int[] A = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8 ,7};
		int[] B = buildMaxHeap(A);
		for(int i=0;i<B.length;i++){
			System.out.print(B[i]);
		}
	}
	
	

}
