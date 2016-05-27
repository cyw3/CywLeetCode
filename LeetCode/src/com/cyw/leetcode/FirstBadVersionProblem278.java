package com.cyw.leetcode;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */
public class FirstBadVersionProblem278 {
	//二分查找  Time Limit Exceeded 
    public int firstBadVersion(int n) {
        if(n<=0) return 0;
        if(isBadVersion(1)) return 1;
        if(!isBadVersion(n)) return 0;
        
        int start=1;
        int end=n;
        while(start<end){
//        	1\
//        	   int mid = start + (end-start) / 2;
//            if(isBadVersion(mid)){
//            	end = mid-1;
//            	if(!isBadVersion(end)) return mid;
//            }else{
//            	start = mid+1;
//            	if(isBadVersion(start)) return mid+1;
//            }
        	
        	//2\
        	int mid = start + (end-start) / 2;
        	if(isBadVersion(mid)) end=mid;
        	else start=mid+1;	//关键是除以2之后，都是向下取整
        }
        return start;
    }
    
    
    boolean isBadVersion(int version){
    	return false;
    }
}
