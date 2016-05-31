package com.cyw.leetcode;

public class ReverseLinkedListProblem206 {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ReverseLinkedListProblem206 re = new ReverseLinkedListProblem206();
		ListNode head = re.reverseList(node1);
		while(head!=null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}
	/**
	 * 反转单向链表，指针操作
	 * 需要三个指针，考虑头结点、尾节点的时候
	 * @param head
	 * @return
	 */
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        if(head.next.next==null) {
        	ListNode next = head.next;
        	head.next = null;
        	next.next = head;
        	return next;
        }
        ListNode now = head;
        ListNode next = head.next;
        ListNode save = next.next;
        now.next = null;
        next.next = now;
        while(save.next!=null){
        	now = next;
        	next = save;
        	save = save.next;
            next.next = now;
        }
        save.next = next;
        return save;
    }
    public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
    }
}
