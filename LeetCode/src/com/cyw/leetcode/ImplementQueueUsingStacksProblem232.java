package com.cyw.leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Use two stacks to implement queue.
 * @author cyw
 *
 */
public class ImplementQueueUsingStacksProblem232 {
//	class MyQueue {
	
	private Stack<Integer> pushStack = new Stack<Integer>();
	private Stack<Integer> popStack = new Stack<Integer>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        pushStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!popStack.isEmpty()) popStack.pop();
        else{
        	while(!pushStack.isEmpty()){
        		popStack.push(pushStack.pop());
        	}
        	if(!popStack.isEmpty()) popStack.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!popStack.isEmpty()) return popStack.peek();
        else{
        	while(!pushStack.isEmpty()){
        		popStack.push(pushStack.pop());
        	}
//        	if(!popStack.isEmpty()) return popStack.peek();
//        	else throw new EmptyStackException();
        	return popStack.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(popStack.isEmpty() && pushStack.isEmpty()) return true;
        else return false;
    }
}
