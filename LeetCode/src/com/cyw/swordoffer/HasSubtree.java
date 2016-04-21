package com.cyw.swordoffer;

/**
 * 树的子结构
 * 输入两颗二叉树A，B，判断B是不是A的子结构。
 * @author cyw
 *
 */
public class HasSubtree {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	/**
	 * 方法：
	 * 1、在树A中遍历查找B的根节点
	 * 2、比对找到的A中结点R与B树，看是否结构相同，不同的话，继续遍历。
	 * 
	 * 递归
	 * @param root1
	 * @param root2 要查找的子结构
	 * @return
	 */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null) return false;
        
        boolean result = false;
        //两个根节点都不是null
        if(root1.val == root2.val)
        	result = doesTree1HasTree2(root1, root2);
        if(!result)
        	result = HasSubtree(root1.left, root2);
        if(!result)
        	result = HasSubtree(root1.right, root2);
        return result;
    }
    
    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2){
    	if(root2==null)
    		return true;
    	if(root1==null)
    		return false;
    	
    	boolean result = false;
    	if(root1.val == root2.val){
    		result = doesTree1HasTree2(root1.left, root2.left);
    		if(result) result = doesTree1HasTree2(root1.right, root2.right);
    	}
    	return result;
    }
}
