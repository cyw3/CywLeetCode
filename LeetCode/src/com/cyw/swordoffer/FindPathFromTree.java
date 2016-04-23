package com.cyw.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author cyw
 *
 */
public class FindPathFromTree {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	/**
	 * 递归  前序遍历
	 * 栈
	 * 回溯法
	 * 
	 * 前序遍历二叉树，并将结点添加到路径之中，累加该结点的值，与target比较
	 * 成，则添加到返回值中
	 * 不成，则回溯到父结点，并将该结点从路径之中删除
	 * @param root
	 * @param target
	 * @return
	 */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null) return new ArrayList<ArrayList<Integer>>();
        
        Vector<TreeNode> path = new Vector<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int sum =0 ;
        findPath(root,path,sum,target,result);
        return result;
    }
    
    public void findPath(
    		TreeNode root,
    		Vector<TreeNode> path, 
    		int sum, 
    		int target, 
    		ArrayList<ArrayList<Integer>> result){
//    	ArrayList<Integer> a = new ArrayList<Integer>();
//    	a.add(1);
//    	a.add(2);
//    	result.add(a);
    	if(root==null || path==null || result==null)return;
    	path.add(root);
    	sum += root.val;
    	
    	//是否是叶节点
    	if(root.left==null && root.right==null){
    		//是否sum==target
    		if(sum==target){
    			ArrayList<Integer> ar = new ArrayList<Integer>();
				Iterator<TreeNode> it =  path.iterator();
    			while(it.hasNext()){
    				ar.add(it.next().val);
    			}
    			result.add(ar);
    		}
    	}
    	if(root.left!=null){
    		findPath(root.left, path, sum, target, result);
    	}
    	if(root.right!=null){
    		findPath(root.right, path, sum, target, result);
    	}
		sum -= root.val;
		path.remove(path.size()-1);
    }
    
    public static void main(String [] args){
    	TreeNode root = new TreeNode(10);
    	root.left = new TreeNode(5);
    	root.right = new TreeNode(12);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(7);
    	
    	FindPathFromTree fp = new FindPathFromTree();
    	
//    	fp.poll(root);
    	
    	ArrayList<ArrayList<Integer>> a = fp.FindPath(root, 22);
    	int len = a.size();
    	for(int i=0;i<len;i++){
    		ArrayList<Integer> tem = a.get(i);
    		Iterator<Integer> it = tem.iterator();
    		System.out.print(i+":");
    		while(it.hasNext()){
    			System.out.print(it.next());
    		}
    		System.out.println();
    	}
    }
    //前序遍历
    public void poll(TreeNode root){
    	if(root==null) return;
    	System.out.print(root.val);
    	if(root.left!=null) poll(root.left);
    	if(root.right!=null) poll(root.right);
    }
}
