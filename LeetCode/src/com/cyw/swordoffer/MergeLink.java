package com.cyw.swordoffer;

/**
 * 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * @author cyw
 *
 */
public class MergeLink {
	public class ListNode {
	    int val;
	    ListNode next = null;
	    ListNode(int val) {
	        this.val = val;
	    }
	}
	/**
	 * 输入两个单调递增的链表
	 * @param list1
	 * @param list2
	 * @return 输出两个链表合成后的链表，单调不减
	 */
	/*
	 * 法1、基于归并排序，类似于两对扑克牌，比较栈顶的牌，进行排序。
	 * 递归，有子问题
	 */
    public ListNode Merge(ListNode list1,ListNode list2) {
    	//鲁棒性
    	if(list1==null)
    		return list2;
    	else if(list2==null)
    		return list1;
    	
        //此时list1与list2都不是null
    	if(list1.val < list2.val){
    		list1.next = Merge(list1.next, list2);
    		return list1;
    	}else{
    		list2.next = Merge(list1, list2.next);
    		return list2;
    	}
    }
}
