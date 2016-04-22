package com.cyw.swordoffer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下矩阵： 
 * 1 2 3 4 
 * 5 6 7 8 
 * 9 10 11 12 
 * 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author cyw
 *
 */
public class PrintMatrixClockwise {
	/**
	 * 法1、循环
	 * 
	 * 递归
	 * 注意：打印一圈的时候，这4步的前提条件。
	 * 循环停止的条件
	 * @param matrix
	 * @return
	 */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null || matrix.length <= 0 || matrix[0].length<=0) 
        	return new ArrayList<Integer>();
        
        int start = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        //循环停止的条件
        while(row>start*2 && col>start*2){
        	result.addAll(printMatrixInCircle(matrix, start));
        	start++;
        }
        return result;
    }
    
    
    public ArrayList<Integer> printMatrixInCircle(int[][] matrix, int start){
    //打印一圈的时候，这4步的前提条件。
        if(matrix==null || matrix.length <= 0 || matrix[0].length<=0)
        	return new ArrayList<Integer>();
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        int row = matrix.length;
        int col = matrix[0].length;
        int endX = col-1-start;
        int endY = row-1-start;//行
        //第一步是必然会执行的，从左到右，前提条件是start<=endX，行不变，列变，至少一行一列
        if(start>endX) return result;
        for(int i=start;i<=endX;i++){
        	result.add(matrix[start][i]);
        }
        
//        第二步，start<endY，至少两行一列
        if(start>=endY) return result;
        for(int i=start+1;i<=endY;i++){
        	result.add(matrix[i][endX]);
        }
        
        //第三步，endY不变，start<endX，至少两行两列
        if(start>=endX) return result;
        for(int i=endX-1;i>=start;i--){
        	result.add(matrix[endY][i]);
        }
        
        //第四步，三行两列至少，start不变，satrt<endY-1
        if(start>=endY-1) return result;
        for(int i=endY-1;i>start;i--){
        	result.add(matrix[i][start]);
        }
        return result;
    }
    
    public static void main(String [] args){
    	PrintMatrixClockwise pm = new PrintMatrixClockwise();
    	int[][] matrix = {
    			 {1,2, 3, 4 },
    			 {5, 6, 7, 8 },
    			 {9 ,10, 11, 12 },
    			 {13 ,14 ,15, 16} 
    	};
    	ArrayList<Integer> ar = pm.printMatrix(matrix);
    	int len = ar.size();
    	for(int i=0;i<len;i++){
    		System.out.print(ar.get(i)+" ");
    	}
//    	1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
//    	错1：1 2 3 4 4 8 12 16 16 15 14 13 13 9 5 1 6 7 7 11 11 10 
//    	错2：1 2 3 4 8 12 16 15 14 13 9 5 1 6 7 11 10 
//    	正确：1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
    }
}
