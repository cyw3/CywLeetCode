package com.cyw.algorithms.sort;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap {
	
	protected Object[] heap;
	protected int size;
	protected Comparator comparator;
	
	public Heap(){
		final int DEFAULT_INITIAL_CAPACITY = 11;
		heap = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public Heap(Comparator comparator){
		this();
		this.comparator = comparator;
	}
	
	protected int compare(Object elem1, Object elem2){
		return (comparator==null?((Comparable)elem1).compareTo(elem2):comparator.compare(elem1, elem2));
	}
	
	/**
	 * 最差是O(n)
	 * 平均时间是常量
	 * @param o
	 */
	public void add(Object o){
		if(++size==heap.length){
			Object[] newHeap = new Object[heap.length*2];
			System.arraycopy(heap, 0, newHeap, 0, size);
			heap = newHeap;
		}
		heap[size-1] = o;
		percolateUp();
	}

	/**
	 * 自底向上
	 * 最差时间是O(lgn);
	 * 平均时间是常数，小于3
	 */
	protected void percolateUp() {
		int child = size-1;
		int parent;
		Object temp;
		while(child>0){
			parent = (child-1)/2;
			if(compare(heap[parent], heap[child])<=0)
				break;
			temp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = temp;
			child = parent;
		}
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public Object getMin(){
		if(size==0)
			throw new NoSuchElementException("Heap is Empty!");
		return heap[0];
	}

	public Object removeMin(){
		if(size==0)
			throw new NoSuchElementException("Heap is Empty!");
		//与最后一个元素进行交换，接着进行调整，使其保持堆特性
		Object min = heap[0];
		heap[0] = heap[size-1];
		heap[--size] = min;
		percolateDown(0);
		return min;
	}

	/**
	 * 在对堆进行remove操作之后的调整
	 * 从上到下，从开始到最后。从i开始
	 * @param i
	 */
	protected void percolateDown(int start) {
		int parent = start;
		int child = parent*2+1;
		Object temp;
		while(child<size){
			if(child<size-1 && compare(heap[child], heap[child+1])>0)
				child++;
			if(compare(heap[parent], heap[child])<=0)
				break;
			temp = heap[parent];
			heap[parent] = heap[child];
			heap[child] = temp;
			parent = child;
			child = parent*2+1;
		}
	}
	
	/**
	 * O(nlgn)
	 * @param a
	 */
	public void heapSort(Object[] a){
		Object temp;
		int len = a.length;
		heap = a;
		size = len;
		//建立堆。从下向上。保证下面是一个堆。每次添加一个在堆顶！
		for(int i=len/2-1;i>=0;i--){
			percolateDown(i);
		}
		//得到逆向的排序结果
		while(size>0)
			removeMin();
		//反转排序
		for(int i=0;i<len/2;i++){
			temp = heap[i];
			heap[i] = heap[len-i-1];
			heap[len-1-i] = temp;
		}
	}
	
	public static void main(String [] args){
		Integer[] A = {4, 1, 3, 2, 6, 9, 0, 5, 8 ,7};
		Heap he = new Heap();
		he.heapSort(A);
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]);
		}
	}
}
