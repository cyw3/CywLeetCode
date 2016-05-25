package com.cyw.hihocoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * TrieTree 字典树、前缀树
 * http://hihocoder.com/problemset/problem/1014
 * @author cyw
 *
 */
public class TrieTreeProblem1014 {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int n,m;	//n表示词典额大小，m表示小ho询问的次数
		ArrayList<String> dict = new ArrayList<String>();
		ArrayList<String> access = new ArrayList<String>();
		n = sc.nextInt();
		for(int i=0;i<n;i++){
			dict.add(sc.next());
		}
		m = sc.nextInt();
		for(int i=0;i<m;i++){
			access.add(sc.next());
		}
		
		if(access==null || access.size()<=0) return;
		Iterator<String> ac = access.iterator();
		while(ac.hasNext()){
			String str = ac.next();
			trieTreeCon(dict, str);
		}
	}

	/**
	 * 1\先对词典进行 构建TrieTree结构，有点像Switch结构
	 * 每一个字母为一个结点的内容
	 * @param dict
	 * @param str
	 */
	private static void trieTreeCon(ArrayList<String> dict,
			String str) {
		if(dict==null || dict.size()<=0 || str==null ||  str.length()<=0){
			System.out.println(0);
			return;
		}
		int count;//记录叶节点个数即可
		
		
		
	}
	
	//TrieTree的结点
	public static class TrieNode{
		public char ch ;
		public ArrayList<TrieNode> next;
		
		public int freq; //词典中出现该字的词频
		
		public TrieNode(char ch){
			this.ch = ch;
			this.freq = 0;
			next = new ArrayList<TrieNode>();
		}
	}
	
	//构建trie树
	public static void createTrieTree(ArrayList<String> dict){
		if(dict==null || dict.size()<=0) return;
		
		Iterator<String> it = dict.iterator();
		TrieNode root = new TrieNode('0');//根节点 ，不算入 字符串之中
		TrieNode temp = root;
		while(it.hasNext()){
			String str = it.next();
			int len =str.length();
			int size;
			for(int i=0;i<len;i++){
				char ch = str.charAt(i);
				if(temp.next.size()>0){
					size = temp.next.size();
					for(int j=0;j<size;j++){
						TrieNode tr = temp.next.get(j);
						if(tr.ch==ch){
							temp = tr;
						}
					}
				}
			}
		}
	}

}
