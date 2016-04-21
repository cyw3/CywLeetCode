package com.cyw.swordoffer;

/**
 * 反转链表
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * @author cyw
 * 
 * 提前想好test case测试用例
 *
 */
public class ReverseList {
	
	public class ListNode {
	    int val;
	    ListNode next = null;
	    ListNode(int val) {
	        this.val = val;
	    }
	}
	/**
	 * 法1、使用栈、或者数组
	 * 法2、调整指针的方向。需要维护三个指针，分别是当前遍历到的结点、
	 * 他的前一个结点以及后一个结点
	 * 
	 * 测试用例：
	 * 输入的链表头指针为null
	 * 输入的链表只有一个结点
	 * 输入的链表有多个结点
	 * @param head
	 * @return
	 */
    public ListNode ReverseList(ListNode head) {
//    	输入的链表头指针为null
    	if(head==null)
    		return null;
//    	输入的链表只有一个结点
    	if(head.next==null)
    		return head;
//    	输入的链表有多个结点
    	ListNode preNode = head;
    	ListNode nowNode = head.next;
    	ListNode postNode = null;
    	preNode.next = null;
    	while(nowNode.next!=null){
    		postNode = nowNode.next;
    		//调整指针方向,此时链表出现断裂
    		nowNode.next = preNode;
    		
    		preNode = nowNode;
    		nowNode = postNode;
    	}
    	//到达尾节点的时候，此时nowNode与postNode在同一个结点尾节点，preNode为其前一个结点
    	nowNode.next = preNode;
    	return nowNode;
    }
}
