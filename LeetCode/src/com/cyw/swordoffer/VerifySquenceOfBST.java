package com.cyw.swordoffer;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author cyw
 *
 */
public class VerifySquenceOfBST {
	/**
	 * 关键是 二叉搜索树的有序性
	 * 
	 * 1、最后一个整数是树的根节点
	 * 2、根节点的左子树均小于根节点的值，右子树均大于根节点的值
	 * @param sequence
	 * @return
	 */
    public static boolean verifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length<=0)return false;
        
        int len = sequence.length;
        int root = sequence[len-1];
//        boolean result = false;
        
        int rightF = 0;//右子树的起始点
      //左子树不为空 <root
        for(;rightF<len-1;rightF++){
        	if(sequence[rightF]>root){
//        		rightF = i;
        		break;
        	}
        }
        System.out.println(rightF);
      //右子树不为空 >root
        for(int i=rightF;i<len-1;i++){
        	if(sequence[i]<root){ 
//        		System.out.println("youyouyou");
        		return false;
        	}
        }
        
        boolean leftBool = true;
        if(rightF>0){
        	int[] left = new int[rightF];
        	for(int i=0;i<rightF;i++){
        		left[i] = sequence[i];
        	}
        	leftBool = verifySquenceOfBST(left);
        }
        boolean rightBool = true;
        if(rightF<len-1){
        	int[] right = new int[len-1-rightF];
        	for(int i=0;i<len-1-rightF;i++){
        		right[i] = sequence[i+rightF];
        	}
        	rightBool = verifySquenceOfBST(right);
        }
        return (leftBool && rightBool);
    }
    
    public static void main(String [] args){
//    	[4,8,6,12,16,14,10]
//    	[4,6,7,5]
//    	[7,4,6,5]
    	int[] s = {4,6,7,5};
    	System.out.println(verifySquenceOfBST(s));
    }
}
