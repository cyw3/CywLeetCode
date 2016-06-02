package com.cyw.leetcode;

public class RemoveDuplicatesFromSortedListProblem83 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head = new RemoveDuplicatesFromSortedListProblem83().deleteDuplicates(head);
//		System.out.println(1);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	/**
	 * Input is 有序链表、
	 * @param head
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode node = head;
        while(node!=null && node.next!=null){
//        while(node.next!=null){
        	ListNode next = node.next;
//        	if(node.val==next.val){
//        		node.next = next.next;
//        		next.next = null;
//        	}
//        	node = next;

        	while(next!=null && node.val==next.val){
        		next = next.next;
        	}
        	node.next = next;
        	node = next;
        	
        }
        return head;
    }
    public static class ListNode {
    	     int val;
    	     ListNode next;
    	     ListNode(int x) { val = x; }
    	 }
}
