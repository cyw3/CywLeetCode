package com.cyw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 计算两数组的交集
 * 结果中出现元素的个数，跟他在两数组中出现的个数一致
 * @author cyw
 *
 */
public class IntersectionOfTwoArraysIIProblem350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //使用hashMap，key为nums1中的值，value为词频
    	HashMap<Integer, Integer> dict1 = new HashMap<Integer, Integer>();
    	HashMap<Integer, Integer> dict2 = new HashMap<Integer, Integer>();
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	for(int i=0;i<len1;i++){
    		int temp = nums1[i];
    		if(!dict1.containsKey(temp)){
    			dict1.put(temp, 1);
    		}else{
				int val = dict1.get(temp);
				dict1.remove(temp);
				dict1.put(temp, val+1);
    		}
    	}
    	for(int i=0;i<len2;i++){
    		int temp = nums2[i];
    		if(dict2.containsKey(temp)){
				int val = dict2.get(temp);
				dict2.remove(temp);
				dict2.put(temp, val+1);
    		}else{
    			dict2.put(temp, 1);
    		}
    	}
    	
//    	HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
    	
    	
    	Set keySet = dict1.keySet();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Iterator<Integer> it = keySet.iterator();
    	while(it.hasNext()){
    		Integer index = it.next();
//    		System.out.println(index);
    		if(dict2.containsKey(index)){
        		Integer val1 = dict1.get(index);
        		Integer val2 = dict2.get(index);
        		val1 = val1<=val2?val1:val2;
        		for(int i=0;i<val1;i++){
        			list.add(index);
        		}
    		}
    		
    	}
    	int[] expr = new int[list.size()];
    	for(int i=0;i<list.size();i++){
    		expr[i] = list.get(i);
    	}
    	return expr;
    }
    
    /*
    public int[] intersect(int[] nums1, int[] nums2) {
        // 1, calculate the Map<num, count> for nums1 array
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, 1 + map.getOrDefault(num, 0));
        }

        // 2, put intersect num into array list，need to subtract 1 from Map<num, count> since intersect is the the min one
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        // 3, ArrayList to array
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    */
    public static void main(String [] args){
    	IntersectionOfTwoArraysIIProblem350 in = new IntersectionOfTwoArraysIIProblem350();
    	int[] nums1 = {1};
    	int[] nums2 = {1,1};
    	int[] re = in.intersect(nums1, nums2);
//    	int len = re.length;
    	for(int i : re){
    		System.out.println(i);
    	}
    }
}
