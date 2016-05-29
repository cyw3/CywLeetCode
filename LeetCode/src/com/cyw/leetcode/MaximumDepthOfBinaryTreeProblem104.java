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
public class MaximumDepthOfBinaryTreeProblem104 {
	/**
	 * 递归
	 * @param root
	 * @return
	 */
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int count = 0;
        return dfsMaxDepth(root, count);
    }
    public int dfsMaxDepth(TreeNode root, int count){
        if(root==null) return count;
        count++;
        int max = count;
        if(root.left!=null) max = Math.max(max, dfsMaxDepth(root.left, count));
        if(root.right!=null) max = Math.max(max, dfsMaxDepth(root.right, count));
        return max;
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
