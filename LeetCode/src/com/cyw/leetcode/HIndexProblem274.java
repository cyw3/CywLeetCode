package com.cyw.leetcode;

/**
 * https://leetcode.com/problems/h-index/
 * 给定研究人员的文章引用次数的数组（每一篇文章的引用次数都是非负整数），
 * 编写函数计算该研究人员的h指数。

根据维基百科对h指数的定义：“一名科学家的h指数是指其发表的N篇论文中，
有h篇论文分别被引用了至少h次，其余N-h篇的引用次数均不超过h次”。

例如，给定引用次数数组 = [3, 0, 6, 1, 5]，这意味着研究人员总共有5篇论文，
每篇分别获得了3, 0, 6, 1, 5次引用。由于研究人员有3篇论文分别至少获得了3次引用，
且其余两篇的引用次数不超过3次，因而其h指数是3。
 * @author cyw
 *
 */
public class HIndexProblem274 {
	/**
	 * sort
	 * counting sort
	 * @param citations
	 * @return
	 */
    public int hIndex(int[] citations) {
        if(citations==null || citations.length<=0) return 0;
        int len = citations.length;
        int[] cita = new int[len+1];
        for(int i=0;i<len;i++){
        	if(citations[i]<len) cita[citations[i]]++;
        	else cita[len]++;
        }
        for(int i=len-1;i>=0;i--){
        	cita[i] += cita[i+1];
        }
        int max;
        for(int i=len;i>=0;i--){
        	if(cita[i]>=i) return i;
        }
        return 0;
    }
    
    /*
     * 
     public int hIndex(int[] citations) {
	    int n = citations.length, tot=0;
	    int[] arr = new int[n+1];
	    for (int i=0; i<n; i++) {
	        if (citations[i]>=n) arr[n]++;
	        else arr[citations[i]]++;
	    }
	    for (int i=n; i>=0; i--) {
	        tot += arr[i];
	        if (tot>=i) return i;
	    }
	    return 0;
	}
     */

}
