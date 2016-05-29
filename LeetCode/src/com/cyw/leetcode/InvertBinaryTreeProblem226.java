package com.cyw.leetcode;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTreeProblem226 {
	/**
	 * 生成镜像二叉树
	 * 递归，两子树指针调换
	 * @param root
	 * @return
	 */
    public TreeNode invertTree(TreeNode root) {
    	dfsInvertTree(root);
    	return root;
    }
    public void dfsInvertTree(TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        //调换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfsInvertTree(root.left);
        dfsInvertTree(root.right);
    }
    
    
	public static void main(String[] args) {

	}
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
}
