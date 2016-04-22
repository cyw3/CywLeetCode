package com.cyw.swordoffer;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 在该栈中，调用min、pop、push的时间复杂度都是O(1)
 * @author cyw
 *
 */
public class MinStack {
	
	private Stack<Integer> dataStack = null;
	private Stack<Integer> minStack = null;
	private int min = Integer.MAX_VALUE;
	
	public MinStack(){
		this.dataStack  = new Stack<Integer>();
		this.minStack = new Stack<Integer>();
	}
	
    public void push(int node) {
        dataStack.push(node);
        if(node<min)
        	min = node;
        minStack.push(min);
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return (Integer) dataStack.lastElement();
    }
    
    public int min() {
        return (Integer) minStack.lastElement();
    }
}
