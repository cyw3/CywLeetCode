package com.cyw.swordoffer;

import java.util.Stack;
import java.util.ArrayList;

/**
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * @author cyw
 *
 */
public class IsPopOrder {
	
	/**
	 * 辅助栈，把第一个序列中的数字一次压入该辅助栈，并按照第二个序列的顺序一次从栈中弹出
	 * 有，直接弹出；无，搜索尚未入栈的数字，入栈
	 * 
	 * 如果下一个弹出的数字刚好是栈顶数字，则直接弹出；否则，我们把压栈序列还没有入栈的
	 * 数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。
	 * 如果所有的数字都已入栈，仍然还没有找到下一个需要弹出的数字，则说明这个序列不是一个弹出序列
	 * 
	 * @param pushA
	 * @param popA
	 * @return
	 */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA==null || popA==null || pushA.length<=0 || pushA.length!=popA.length) 
        	return false;
        Stack<Integer> dataStack = new Stack<Integer>();
        int len = pushA.length;
//        boolean result = false;
        int flag = -1;
        for(int i=0;i<len;i++){
        	int tem = popA[i];
        	//若在栈中
        	if(!dataStack.isEmpty() && dataStack.lastElement()==tem) {
        		dataStack.pop();
        		continue;
        	}
        	int j=flag+1;
        	for(;j<len;j++) {
        		if(tem==pushA[j])break;
        	}
        	//没有找到
        	if(j>=len) return false;
        	
        	for(int k=flag+1;k<=j-1;k++){
        		dataStack.push(pushA[k]);
        	}
        	flag = j;
        }
        return true;
    }
    
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        if(pushA==null || popA==null || pushA.length<=0 || pushA.length!=popA.length) 
        	return false;
        
        ArrayList<Integer> data = new ArrayList<Integer>();
        int pointerDt = -1;
        int pointerPush = 0;
        int len = popA.length;
        for(int i=0;i<len;i++){
        	int temp = popA[i];
        	
        	while(data.isEmpty() || data.get(pointerDt)!=temp){
        		if(pointerPush>=len){
        			return false;
        		}
        		data.add(pushA[pointerPush]);
        		pointerDt++;
        		pointerPush++;
        	}
        	data.remove(pointerDt);
        	pointerDt--;
        }
        if(!data.isEmpty())return false;
        return true;
    }
    
    public static void main(String [] args){
    	IsPopOrder ip = new IsPopOrder();
    	int[] pushA = {1,2,3,4,5};
    	int[] popA = {4,5,3,2,1};
//    	int[] popA = {4,3,5,1,2};
    	System.out.println(ip.IsPopOrder2(pushA, popA));
    }
}
