package com.cyw.swordoffer;
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;

/**
题目描述
	输入一个链表，从尾到头打印链表每个节点的值。 
输入描述:
	输入为链表的表头

输出描述:
	输出为需要打印的“新链表”的表头
	
 * @author cyw
 *
 */
public class PrintListFromTailToHead {
	
	/**
	 * 法1、使用stack
	 * 法2、递归
	 * @param listNode
	 * @return
	 */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
    	Stack<ListNode> staList = new Stack<PrintListFromTailToHead.ListNode>();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	ListNode listN = listNode;
    	while(listN!=null){
    		staList.push(listN);
    		listN = listN.next;
    	}
    	while(!staList.isEmpty()){
    		listN = staList.pop();
    		result.add(listN.val);
    	}
		return result;
    }
    
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	if(listNode==null){
    		return  new ArrayList<Integer>();
    	}
		if(listNode.next!=null){
			result = printListFromTailToHead2(listNode.next);
		}
		result.add(listNode.val);
		return result;
    }

    
    public class ListNode {
    	int val;
    	ListNode next = null;
    	ListNode(int val) {
    	    this.val = val;
    	}
    }
}