package com.cyw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Each element in the result must be unique.
 * @author cyw
 *
 */
public class IntersectionOfTwoArraysProblem349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length<=0 || nums2.length<=0) return new int[0];
        
        Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for(int i: nums1){
        	if(!dict.containsKey(i))
        		dict.put(i, 0);
        }
        for(int i: nums2){
        	if(dict.containsKey(i)){
        		dict.put(i, 1);
        	}
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Set key = dict.keySet();
        Iterator<Integer> it = key.iterator();
        while(it.hasNext()){
        	Integer index = it.next();
        	if(dict.get(index)>0){
        		list.add(index);
        	}
        }
        int[] expr = new int[list.size()];
        int len = list.size();
        for(int i=0;i<len;i++){
        	expr[i] = list.get(i);
        }
        return expr;
    }
}
