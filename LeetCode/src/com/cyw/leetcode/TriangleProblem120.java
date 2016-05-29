package com.cyw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TriangleProblem120 {
	//Dp 需要考虑全面
	//只能移动到i或者i+1
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()<=0) return 0;
        //triangle是金字塔的样式，数目是从上面到下面逐步递增
        int listNum = triangle.size();
        int[][] triCache = new int[listNum][listNum];

        //一个斜向下的三角形
        triCache[0][0] = triangle.get(0).get(0);
        for(int i=1;i<listNum;i++){
        	int len = triangle.get(i).size();
        	for(int j=0;j<len;j++){
        		if(j==0) triCache[i][j] = triCache[i-1][j]+triangle.get(i).get(j);
        		else if(j==i) triCache[i][j] = triCache[i-1][j-1]+triangle.get(i).get(j);
        		else triCache[i][j] = Math.min(triCache[i-1][j]+triangle.get(i).get(j),
        				triCache[i-1][j-1]+triangle.get(i).get(j) );
        	}
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<listNum;i++){
        	min = Math.min(min, triCache[listNum-1][i]);
        }
        return min;
    }
    
    public static void main(String [] args){
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	ArrayList<Integer> l1 = new ArrayList<Integer>();
//    	[[1],[2,3]]		[[-1],[2,3],[1,-1,-3]]
    	ArrayList<Integer> l2 = new ArrayList<Integer>();
    	ArrayList<Integer> l3 = new ArrayList<Integer>();
    	l1.add(-1);
    	l2.add(2);
    	l2.add(3);
    	l3.add(1);
    	l3.add(-1);
    	l3.add(-3);
    	list.add(l1);
    	list.add(l2);
    	list.add(l3);
    	
    	TriangleProblem120 tr = new TriangleProblem120();
    	System.out.println(tr.minimumTotal(list));
    }
}
