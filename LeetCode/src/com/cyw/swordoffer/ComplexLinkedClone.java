package com.cyw.swordoffer;

import java.util.HashMap;

//分解问题的能力
/**
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点）。
 * @author cyw
 *
 */
public class ComplexLinkedClone {
	public static class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;
	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	/**
	 * 法1、O(n^2),先复制next，成为一条复制链表，在对每一个结点的random 从头开始遍历
	 * 寻找相应的结点，以此循环
	 * 法2、O(n)同样是先使用next简历一个复制链表，同时 使用hashmap保存链表与复制链表各相应
	 * 节点对应关系，在根据这一关系建立random的关系。以空间换时间
	 * 
	 * 法3：
	 * 1、拷贝每一个结点的内容，并将每一个复制结点连到源节点后面
	 * 2、根据各结点的random结点的下一个结点也是 复制结点的复制random结点，建立 random的关系
	 * 3、将这个长链表分解为两个短链表，奇数结点为一个链表，偶数结点为一个链表
	 * @param pHead
	 * @return
	 */
	//法2、
    public RandomListNode Clone2(RandomListNode pHead){
        if(pHead==null) return null;
        
        HashMap<RandomListNode, RandomListNode> link = 
        		new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode pCloneHead = cloneList(pHead, link);
        cloneRandom(pHead, pCloneHead, link);
        return pCloneHead;
    }
    
    //复制链表，将对应关系存入哈希表
    public RandomListNode cloneList(RandomListNode pHead, 
    		HashMap<RandomListNode, RandomListNode> link){
    	if(pHead==null || link==null) return null;
    	RandomListNode pTem = pHead;
    	RandomListNode pClone = new RandomListNode(pTem.label);
    	RandomListNode pCloneHead = pClone;
    	link.put(pTem, pClone);
    	
    	while(pTem.next!=null){
    		pTem = pTem.next;
    		pClone.next = new RandomListNode(pTem.label);
    		pClone = pClone.next;
    		link.put(pTem, pClone);
    	}
    	return pCloneHead;
    }
    
    //复制random
    public void cloneRandom(RandomListNode pHead, 
    		RandomListNode pCloneHead,
    		HashMap<RandomListNode, RandomListNode> link){
    	if(pHead==null || pCloneHead==null || link==null)return;
    	RandomListNode pTem = pHead;
    	RandomListNode pClone = pCloneHead;
    	if(pTem.random!=null) pClone.random = link.get(pTem.random);
    	
    	while(pTem.next!=null){
    		pTem = pTem.next;
    		pClone = pClone.next;
    		if(pTem.random!=null) pClone.random = link.get(pTem.random);
    	}
    }
	
	//法3
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null) return null;
        
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reconnectCloneList(pHead);
    }
    
    public void cloneNodes(RandomListNode pHead){
    	if(pHead==null) return;
    	
    	RandomListNode pClone = null;
    	while(pHead.next!=null){
    		pClone = new RandomListNode(pHead.label);
    		pClone.next = pHead.next;
    		pHead.next = pClone;
    		
    		pHead = pClone.next;
    	}
    	pClone = new RandomListNode(pHead.label);
    	pHead.next = pClone;
    }
    public void connectRandomNodes(RandomListNode pHead){
    	if(pHead==null) return;
    	RandomListNode pNow = pHead;
    	RandomListNode pClone = pNow.next;
    	if(pNow.random!=null) pClone.random = pNow.random.next;
    	while(pClone.next!=null){
    		pNow = pClone.next;
    		pClone = pNow.next;
    		//如果这个结点的random为null
    		if(pNow.random!=null) pClone.random = pNow.random.next;
    	}
    }
//    3、将这个长链表分解为两个短链表，奇数结点为一个链表，偶数结点为一个链表
    public RandomListNode reconnectCloneList(RandomListNode pHead){
    	if(pHead==null) return null;
    	RandomListNode pNow = pHead;
    	RandomListNode pCloneHead = pNow.next;
    	RandomListNode pClone = pNow.next;
    	
    	pNow.next = null;
    	while(pClone.next!=null){
    		pNow.next = pClone.next;
    		pNow = pNow.next;
    		pClone.next = pNow.next;
    		pClone = pClone.next;
    		pNow.next = null;
    	}
    	
    	return pCloneHead;
    }
    
    public static void main(String [] args){
    	
    	RandomListNode rl = new RandomListNode(1);
    	rl.next = new RandomListNode(2);
    	rl.next.next = new RandomListNode(3);
    	rl.next.next.next = new RandomListNode(4);
    	rl.next.next.next.next = new RandomListNode(5);
    	//设置random
    	rl.next.random = rl.next.next.next.next;
    	rl.next.next.random = rl.next.next;
    	rl.next.next.next.random = rl.next; 
    	
    	ComplexLinkedClone clc = new ComplexLinkedClone();
    	
    	RandomListNode pCloneHead = clc.Clone2(rl);
    	//打印链表
        RandomListNode tem = pCloneHead;
        System.out.print(tem.label);
        while(tem.next!=null){
        	tem = tem.next;
            System.out.print(tem.label);
        }
        System.out.println();
        
      //打印链表的 random
        tem = pCloneHead;
        if(tem.random!=null) System.out.print(tem.random.label);
        else System.out.print("null");
        while(tem.next!=null){
        	tem = tem.next;
        	if(tem.random!=null) System.out.print(tem.random.label);
            else System.out.print("null");
        }
        System.out.println();
    }
}
