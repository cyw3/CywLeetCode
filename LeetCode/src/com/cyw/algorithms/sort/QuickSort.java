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
	
	public static void main(String [] args){
		int[] A = {5, 2, 4, 6, 1, 3};
		quickSort(A, 0, A.length-1);
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]);
		}
	}
	
	/**
     * description : 快速排序
     * @param pData
     * @param left
     * @param right
     * @return
     */
    public static void quickSort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quickSort(n, left, dp - 1);
            quickSort(n, dp + 1, right);
        }
    }
    
  //方法1、A[r]为主元x，i、j为确定左右的标记
  	private static int partition(int[] A, int p, int r) {
  		int x=A[r];
  		int i=p-1;
  		int temp =0 ;
  		for(int j=p;j<=r-1;j++){
  			if(A[j]<=x){
  				i++;
  				//exchange A[i] with A[j]
//  				A[i] = A[i] ^ A[j];
//  				A[j] = A[i] ^ A[j];
//  				A[i] = A[i] ^ A[j];
  				temp = A[i];
  				A[i] = A[j];
  				A[j] = temp;
  			}
  		}
  		//exchange A[i+1] with A[r]
//  		A[i+1] = A[i+1] ^ A[r];
//  		A[r] = A[i+1] ^ A[r];
//  		A[i+1] = A[i+1] ^ A[r];
  		temp = A[i+1];
  		A[i+1] = A[r];
  		A[r] = temp;
  		return i+1;
  	}
  	
		/**
		 * 方法2、左右指针
		 */
//    public static int partition(int n[], int left, int right) {
//    	//主元
//        int pivot = n[left];
//        while (left < right) {
//            while (left < right && n[right] >= pivot)
//                right--;
//            if (left < right)
//                n[left++] = n[right];
//            while (left < right && n[left] <= pivot)
//                left++;
//            if (left < right)
//                n[right--] = n[left];
//        }
//        n[left] = pivot;
//        return left;
//    }
}
