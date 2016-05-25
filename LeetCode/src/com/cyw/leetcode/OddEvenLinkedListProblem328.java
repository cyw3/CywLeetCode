package com.cyw.leetcode;

public class OddEvenLinkedListProblem328 {
	/**
	 * Definition for singly-linked list.
	 * һ�δ�����ż
	 */
    public ListNode oddEvenList(ListNode head) {
    	
    	if(head==null||head.next==null) return head;
    	
    	//��
    	ListNode odd = head;
    	ListNode oddHead = head;
    	//ż
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
