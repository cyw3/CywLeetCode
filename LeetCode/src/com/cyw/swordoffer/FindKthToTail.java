package com.cyw.swordoffer;

/**
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。尾节点是倒数第一个结点
 * @author cyw
 *
 * 关键是，代码的鲁棒性。程序判断输入是否合乎规范，并能够对不合要求的输入予以合理的处理
 * 防御性编程，在函数入口验证输入是否合乎要求
 * 
 * 如果不。。。会怎样
 */
public class FindKthToTail {
	
	public class ListNode {
	    int val;
	    ListNode next = null;
	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	/**
	 * 法1，两次遍历
	 * 
	 * 法2、只遍历一次，需要维持两个指针，具体步骤如下：
	 * 1、第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动
	 * 2、从第k步开始，第二个指针也开始与第一个指针同时开始向前遍历。两指针中间距离一直保持
	 * k-1步。所以当第一个指针到达尾节点时候，第二个指针正好在倒数第k个结点
	 * 
	 * 注意，如果链表结点数小于k时候.注意鲁棒性，null，尾节点是倒数第一个结点
	 * @param head
	 * @param k
	 * @return
	 */
    public ListNode FindKthToTail(ListNode head,int k) {
    	//
    	if(head==null || k==0) return null;
    	
    	ListNode listTe1 = head;
    	//第一步
    	for(int i=0;i<k-1;i++){
    		//
    		if(listTe1.next==null){
    			return null;
    		}
    		listTe1 = listTe1.next;
    	}
    	//第二步
    	ListNode listTe2 = head;
    	while(listTe1.next!=null){
    		listTe1 = listTe1.next;
    		listTe2 = listTe2.next;
    	}
    	
		return listTe2;
    }

}
