package com.cyw.test;

public class Cyw_2 {
	/**
	 * Definition for singly-linked list.
	 * 断开
	 */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	/*
    	 * 第二种
    	 */
    	ListNode head = new ListNode(0);
    	ListNode l = head;
    	int temp = 0;
    	while(l1!=null || l2!=null || temp!=0){
    		int sum = temp;
    		temp = 0;
    		if(l1!=null){
    			sum += l1.val;
    			l1 = l1.next;
    		}
    		if(l2!=null){
    			sum += l2.val;
    			l2 = l2.next;
    		}
    		if(sum>9){
    			temp = 1;
    			sum -= 10;
    		}
    		l.next = new ListNode(sum);
    		l = l.next;
    	}
    	return head.next;
    	
    	
    	
    	
    	
    	/*
    	 * 第一种
    	 */
//    	ListNode head = l2;
//    	int temp = 0;
//    	
//		temp += l2.val;
//		l2.val = (l1.val + temp)%10;
//		temp = (l1.val + temp)/10;
//    	
//		while(l1.next!=null || l2.next!=null){
//    		if(l1.next==null){
//    			//使链表不断
//    			l1.next = new ListNode(0);
//    		}else if(l2.next==null){
//    			l2.next = new ListNode(0);
//    		}
//    		l1 = l1.next;
//    		l2 = l2.next;
//    		
//    		temp += l2.val;
//    		l2.val = (l1.val + temp)%10;
//    		temp = (l1.val + temp)/10;
//    		
//    		System.out.println("l2:"+l2.val+" ;temp:"+temp);
//
//    	}
//    	
//    	if(temp!=0 && l2.next==null){
//    		System.out.println("tttttttttttttt");
//    		l2.next= new ListNode(temp);
//    	}
//		return head;
    }
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
	
	 public static void main(String [] args){
	    	ListNode a = new ListNode(5);
	    	a.next = new ListNode(5);
	    	ListNode b = new ListNode(5);
	    	b.next = new ListNode(4);
	    	ListNode head = addTwoNumbers(a,b);
	    	while(head!=null){
	    		System.out.println(head.val+" ;");
	    		head = head.next;
	    	}
//	    	System.out.println(head.val+" ;"+head.next.val);
	 }
	
}

