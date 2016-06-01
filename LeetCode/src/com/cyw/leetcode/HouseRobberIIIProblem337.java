package com.cyw.leetcode;

import com.cyw.leetcode.InvertBinaryTreeProblem226.TreeNode;

/**
 1、二叉树
 2、相连的结点不能偷。即是间隔的层不能偷
 @author cyw
 *
 */
public class HouseRobberIIIProblem337 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
//		root.right = new TreeNode(5);
		root.left.left = new TreeNode(2);
//		root.left.right = new TreeNode(3);
//		root.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(3);
		
		HouseRobberIIIProblem337 ho = new HouseRobberIIIProblem337();
		System.out.println(ho.rob(root));
		
	}
	/**
	 * Depth-first Search Algorithm
	 * @param root
	 * @return
	 */
    public int rob(TreeNode root) {
    	if(root==null) return 0;
    	if(root.left==null && root.right==null) return root.val;
    	//二叉树的递归
    	//偷该户
    	int rob = root.val;
    	//不偷该户
    	int noRob = 0;
    	if(root.left!=null){
    		//相连的不偷，以此又是一个完整的子结构
    		rob += rob(root.left.left) + rob(root.left.right);
    		noRob += rob(root.left);
    	}
    	if(root.right!=null){
    		rob += rob(root.right.left) + rob(root.right.right);
    		noRob += rob(root.right);
    	}
    	return Math.max(rob, noRob);
    }
    public static class TreeNode {
    	     int val;
    	     TreeNode left;
    	     TreeNode right;
    	     TreeNode(int x) { val = x; }
    	 }
}
