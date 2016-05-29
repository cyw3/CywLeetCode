package com.cyw.leetcode;


public class SameTreeProblem100 {

	public static void main(String[] args) {

	}
	/**
	 * Given two binary trees, write a function to check if they are equal or not.
	 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
	 * 递归
	 * @param p
	 * @param q
	 * @return
	 */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        else if(p!=null && q!=null){
        	if(p.val!=q.val) return false;
            return  isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
}
