package com.cyw.swordoffer;

public class DeleteNode {
	
	//前提是，要删除的结点确实在该链表之中。否则还得需要O(n)的时间进行确认
	
	public class ListNode{
		public int var;
		public ListNode next;
	}

	/**
	 * 法1、顺序遍历，得到待删除的节点nodeToBeDelete的前一节点，然后执行删除O(n)
	 * 法2、O(1)直接使用nodeToBeDelete后面的节点，进行复制，删除。注意考虑边界值，比如
	 * 头结点、尾节点
	 * 把下一个结点的内容复制到需要删除的结点上覆盖该结点原有的内容，再把下一个结点删除，
	 * 如若删除的结点是尾节点，需要遍历得到其前序结点，删除。
	 * 链表中只有一个结点时，在删除该节点时候，还需要把头结点设置为null
	 * 
	 * @param ListHead
	 * @param nodeToBeDelete
	 */
	public void deleteNode(ListNode listHead, ListNode nodeToBeDelete){
		if(listHead==null || nodeToBeDelete == null)
			return;
		
		//判断是否是尾结点
		if(nodeToBeDelete.next==null){
			//是尾节点
			
			//判断该链表是否只有一个结点
//			int count = 1;
//			ListNode listTe = listHead;
//			while(listTe.next!=null)
//				count++;
			//该链表只有一个节点
			if(listHead==nodeToBeDelete){
				listHead = null;
				return;
			}
			
			//有多个结点
			//遍历寻找该结点的前序结点
			ListNode listTe = listHead;
			while(listTe.next!=nodeToBeDelete){
				listTe = listTe.next;
			}
			
			//删除该结点。修改next,链接
			listTe.next = null;
			nodeToBeDelete = null;
			return;
		}else{
			//将待删除的结点的下一个结点内容复制到待删除结点
			ListNode listNext = nodeToBeDelete.next;
			nodeToBeDelete.var = listNext.var;
			//把下一个结点删除
			nodeToBeDelete.next = listNext.next;
			listNext = null;
		}
	}
}
