package com.cyw.swordoffer;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 题目描述
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author cyw
 *
 */
public class ReConstructBinaryTree {
	/**
	 * 递归
	 * @param pre
	 * @param in
	 * @return
	 */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	if(pre.length<=0 || in.length<=0){
    		return null;
    	}
    	TreeNode root = new TreeNode(pre[0]);
    	int i=0;
    	while(i<in.length){
    		if(in[i]==pre[0])
    			break;
    		i++;
    	}
    	
    	//左子树
    	if(i!=0){
    		int[] preLeft = new int[i];
    		for(int j=1;j<=i;j++){
        		preLeft[j-1] = pre[j];
        	}
    		
    		int[] inLeft = new int[i];
        	for(int j=0;j<i;j++){
        		inLeft[j] = in[j];
        	}
        	root.left = reConstructBinaryTree(preLeft, inLeft);
    	}
    	
    	//右子树
    	if(i!=in.length){
    		int[] preRight = new int[pre.length-i-1];
        	for(int j=i+1;j<pre.length;j++){
        		preRight[j-i-1] = pre[j];
        	}
        	
        	int[] inRight = new int[in.length-i-1];
        	for(int j=i+1;j<in.length;j++){
        		inRight[j-i-1] = in[j];
        	}
        	root.right = reConstructBinaryTree(preRight, inRight);
    	}
		return root;
    }
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
