package com.cyw.swordoffer;

/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author cyw
 *
 */
public class BSTConvertToDoublyLinkedList {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	/**
	 * 法1，使用数组，存储中序遍历的顺序结果，并对数组中每一个结点左右指针进行调整
	 * 法2、使用中序遍历，不过返回的是 一个已经将子树转换成排序好了的双向链表，递归
	 * @param pRootOfTree
	 * @return
	 */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)return null;
        
        convertBSTToDLL(pRootOfTree);
        
        //返回头结点
        while(pRootOfTree.left!=null) pRootOfTree = pRootOfTree.left;
        return pRootOfTree;
    }
    
    //返回的是根节点
    public void convertBSTToDLL(TreeNode pRootOfTree){
        if(pRootOfTree==null || (pRootOfTree.left==null && pRootOfTree.right==null))
        	return;
        
        TreeNode pLeft = pRootOfTree.left;
        TreeNode pRight = pRootOfTree.right;
        
        if(pRootOfTree.left!=null) {
        	convertBSTToDLL(pLeft);
        	while(pLeft.right!=null) pLeft = pLeft.right;
        	pRootOfTree.left = pLeft;
            pLeft.right = pRootOfTree;
        }
        if(pRootOfTree.right!=null) {
        	 convertBSTToDLL(pRight);
        	 while(pRight.left!=null) pRight = pRight.left;
             pRootOfTree.right = pRight;
             pRight.left = pRootOfTree;
        }
        
        //若pLeft==null
//        while(pLeft.right!=null) pLeft = pLeft.right;
//        while(pRight.left!=null) pRight = pRight.left;
    }
    
    public static void main(String [] args){
    	TreeNode root = new TreeNode(8);
    	root.left = new TreeNode(5);
    	root.right = new TreeNode(9);
//    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(7);
    	
    	BSTConvertToDoublyLinkedList btl = new BSTConvertToDoublyLinkedList();
    	TreeNode re = btl.Convert(root);
    	System.out.print(re.val);
    	while(re.right!=null) {
    		re = re.right;
    		System.out.print(re.val);
    	}
    }
}
