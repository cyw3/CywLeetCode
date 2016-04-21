package com.cyw.swordoffer;

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：
 * 源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * @author cyw
 *
 */
public class MirrorTree {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	/**
	 * 遍历树的同时交换非叶节点的左右子节点
	 * 递归，前序遍历
	 * @param root
	 */
    public void Mirror(TreeNode root) {
        if(root == null) return;
        //是否是叶节点
        if(root.left==null&&root.right==null)return;
        
        //交换左右结点
        TreeNode tnTemp = root.left;
        root.left = root.right;
        root.right = tnTemp;
        
        //继续遍历交换
        Mirror(root.left);
        Mirror(root.right);
    }
}
