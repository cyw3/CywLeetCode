package com.cyw.test;

public class Cyw_328 {
	/**
	 * Definition for singly-linked list.
	 * 一次处理奇偶
	 */
    public ListNode oddEvenList(ListNode head) {
    	
    	if(head==null||head.next==null) return head;
    	
    	//奇
    	ListNode odd = head;
    	ListNode oddHead = head;
    	//偶
    	ListNode even = head.next;
    	ListNode evenHead = head.next;
    	
    	while( even!=null && even.next!=null ){
    		odd.next = even.next;
    		odd = odd.next;
    		even.next = odd.next;
    		even = even.next;
    	}
    	odd.next = evenHead;
    	
		return oddHead;
    }
    
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
}
