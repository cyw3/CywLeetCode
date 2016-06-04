package com.cyw.algorithms.sort;

import java.util.TreeSet;

/**
 * 利用了Java集合框架中的TreeSet。将待排序元素一个一个的插入到一个开始为空的TreeSet对象之中
 * @author cyw
 *
 */
public class TreeSort {

	/**
	 * TreeSet不允许有重复元素
	 * avTime O(nlgn);worstTime O(nlgn)
	 * @param a
	 */
	public static void treeSort(Object[] a){
		TreeSet tree = new TreeSet();
		for(int i=0;i<a.length;i++)
			tree.add(a[i]);
		tree.toArray(a);
	}
}
