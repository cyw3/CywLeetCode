package com.cyw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesIIProblem95 {
	 public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	 
	 /**
	  * 1、分治法，递归
	  * 2、DP
	  * https://leetcode.com/problems/unique-binary-search-trees-ii/
	  * @param n
	  * @return
	  */
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList<TreeNode>();
        List<TreeNode>[] list = new List[n+1];
        list[0] = new ArrayList<TreeNode>();
        list[0].add(null);
        
        for(int len=1;len<=n;len++){
        	list[len] = new ArrayList<TreeNode>();
        	for(int rootNum=0;rootNum<len;rootNum++){
        		//Left tree
        		for(TreeNode left: list[rootNum]){
        			for(TreeNode right:list[len-1-rootNum]){
        				TreeNode root = new TreeNode(rootNum+1);
        				root.left = left;
        				root.right = modifyNum(right, rootNum+1);
        				list[len].add(root);
        			}
        		}
        	}
        }
        return list[n];
    }
    
    public TreeNode modifyNum(TreeNode ro, int start){
    	if(ro==null) return null;
    	TreeNode root = new TreeNode(ro.val+start);
    	root.left = modifyNum(ro.left, start);
    	root.right = modifyNum(ro.right, start);
    	return root;
    }
}
