package com.cyw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * @author cyw
 *
 */
public class TopKFrequentElementsProblem347 {
	
	//Bucket Sort。使用桶排序
//	public List<Integer> topKFrequent(int[] nums, int k) {
//	    List<Integer>[] bucket = new List[nums.length + 1];
//	    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
//	    for (int n : nums) {
//	        frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
//	    }
//	    for (int key : frequencyMap.keySet()) {
//	        int frequency = frequencyMap.get(key);
//	        if (bucket[frequency] == null) {
//	            bucket[frequency] = new ArrayList<Integer>();
//	        }
//	        bucket[frequency].add(key);
//	    }
//
//	    List<Integer> res = new ArrayList<Integer>();
//
//	    for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
//	        if (bucket[pos] != null) {
//	            res.addAll(bucket[pos]);
//	        }
//	    }
//	    return res;
//	}
	
	/*
	 //优先队列
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();
	    List<Integer> ret = new ArrayList<>();
	    for (int n : nums) {
	        if (countMap.containsKey(n)) {
	            countMap.put(n ,countMap.get(n)+1);
	        } else {
	            countMap.put(n ,1);
	        }
	    }
	    
	    //
	   PriorityQueue<Map.Entry<Integer, Integer>> pq =
	            new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
	    pq.addAll(countMap.entrySet());

	    List<Integer> ret = new ArrayList<>();
	    for(int i = 0; i < k; i++){
	        ret.add(pq.poll().getKey());
	    }
	    return ret;
	}
	 */
	
	//但是不能处理 数目相同的，会覆盖掉
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums==null || k<=0) return new ArrayList<Integer>();
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        int len = nums.length;
        for(int i=0;i<len;i++){
        	dict.put(nums[i], dict.getOrDefault(nums[i], 0)+1);
        }
        if(dict.size()<k) return new ArrayList<Integer>();
        
//        int[] result = new int[len+1];
        List<Integer>[] result = new List[len+1];
        for(int i: dict.keySet()){
//        	result[dict.get(i)] = i;
        	if(result[dict.get(i)]==null){
        		result[dict.get(i)] = new ArrayList<Integer>();
        	}
        	result[dict.get(i)].add(i);
        }
        ArrayList<Integer> topK = new ArrayList<Integer>();
        int index = len;
        for(int i=0;i<k;){
        	while(index>=0 && result[index]==null ) index--;
        	if(index>=0 && result[index].size()>0) {
//        		topK.add(result[index]);
        		for(int re:result[index]){
        			topK.add(re);
        			i++;
        		}
        		index--;
        	}
        }
        return topK;
    }
    
    public static void main(String [] args) {
		TopKFrequentElementsProblem347 to = new TopKFrequentElementsProblem347();
		int[] nums = {1,1,1,2,2,3};//{1,2};//{1};//{1,1,1,2,2,3};
		ArrayList<Integer> list = (ArrayList<Integer>) to.topKFrequent(nums, 2);
		for(int i:list){
			System.out.print(i+" ");
		}
	}
}
