package com.cyw.leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
 public interface NestedInteger {
 *
     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();
 *
     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();
 *
     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
 */
//https://leetcode.com/problems/flatten-nested-list-iterator/
/**
 Use Depth-first Algorithm with stack to save the all iterator of nestedList.
 @author cyw
 *
 */
public class NestedIterator implements Iterator<Integer> {

	private Stack<Integer> nestedStack = new Stack<Integer>();
	private Iterator<Integer> iterator;
	
    public NestedIterator(List<NestedInteger> nestedList) {
    	if(nestedList==null) return;
    	recursion(nestedList);
    	iterator = nestedStack.iterator();
    }
    
    private void recursion(List<NestedInteger> nestedList){
    	if(nestedList==null) return;
    	Iterator<NestedInteger> it = nestedList.iterator();
    	while(it.hasNext()){
    		NestedInteger ni = it.next();
    		if(ni.isInteger()) nestedStack.push(ni.getInteger());
    		else{
    			recursion(ni.getList());
    		}
    	}
    }

//    @Override
    public Integer next() {
    	return iterator.next();
    }

//    @Override
    public boolean hasNext() {
    	return iterator.hasNext();
    }
    public interface NestedInteger {
	     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	     public boolean isInteger();
	     // @return the single integer that this NestedInteger holds, if it holds a single integer
	     // Return null if this NestedInteger holds a nested list
	     public Integer getInteger();
	     // @return the nested list that this NestedInteger holds, if it holds a nested list
	     // Return null if this NestedInteger holds a single integer
	     public List<NestedInteger> getList();
	 }
}

/**
 Your NestedIterator object will be instantiated and called as such:
 NestedIterator i = new NestedIterator(nestedList);
 while (i.hasNext()) v[f()] = i.next();
 */