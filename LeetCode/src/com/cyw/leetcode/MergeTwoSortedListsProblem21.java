package com.cyw.leetcode;

/**
 * https://leetcode.com/problemset/algorithms/
 * @author cyw
 *
 */
public class MergeTwoSortedListsProblem21 {
	//升序
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head = null;// l1.val<l2.val?l1:l2;
        ListNode index1 = l1;
        ListNode index2 = l2;
        if(l1.val<l2.val){
        	head = l1;
        	index1 = index1.next;
        }else{
        	head = l2;
        	index2 = index2.next;
        }
        ListNode temp = head;
        
        while(index1!=null && index2!=null){
        	if(index1.val>=index2.val){
        		temp.next = index2;
        		index2 = index2.next;
        		temp = temp.next;
        	}else{
        		temp.next = index1;
        		index1 = index1.next;
        		temp = temp.next;
        	}
        }
        if(index1==null && index2==null) return head;
        if(index1==null) 
        	temp.next = index2;
        if(index2==null) temp.next = index1;
        return head;
    }
    public class ListNode {
    	     int val;
    	     ListNode next;
    	     ListNode(int x) { val = x; }
    	 }
}
