package com.cyw.leetcode;


public class DeleteNodeInALinkedListProblem237 {
	/**
	 * 单向链表
	 * O(1)直接使用nodeToBeDelete后面的节点，进行复制，删除。注意考虑边界值，比如
	 * 尾节点
	 * 把下一个结点的内容复制到需要删除的结点上覆盖该结点原有的内容，再把下一个结点删除，
	 * @param node
	 */
    public void deleteNode(ListNode node) {
        if(node==null) return;
        //尾节点，需要遍历
        if(node.next==null){
        	node = null;
        	return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
        
    }
	public static void main(String[] args) {

	}
	public class ListNode{
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; }
	}

}
