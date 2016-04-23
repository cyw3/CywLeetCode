package com.cyw.swordoffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author cyw
 *
 */
public class PrintTreeFromTopToBottom {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	/**
	 * 树的遍历算法
	 * 法1、广度优先搜索，队列，迭代、循环
	 * BlockingQueue
	 * LinkedList
	 * deque 双向队列
	 * @param root
	 * @return
	 */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null)return new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        queue.add(root);
        TreeNode tempNode = null;
        while(!queue.isEmpty()){
        	tempNode = queue.remove();
        	result.add(tempNode.val);
        	if(tempNode.left!=null)queue.add(tempNode.left);
        	if(tempNode.right!=null)queue.add(tempNode.right);
        }
        return result;
    }
    
    public static void main(String [] args){
//    	Queue<Integer> queue = new LinkedList<Integer>();
//    	queue.add(1);
//    	queue.add(4);
//    	queue.add(3);
//    	while(!queue.isEmpty()){
//    		System.out.println(queue.remove());
//    	}
//    	PrintTreeFromTopToBottom pt = new PrintTreeFromTopToBottom();
//    	ArrayList<Integer> result = pt.PrintFromTopToBottom(root);
    }
}
