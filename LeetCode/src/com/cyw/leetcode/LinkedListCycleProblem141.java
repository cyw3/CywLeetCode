package com.cyw.leetcode;

/**
 https://leetcode.com/problems/linked-list-cycle/
 http://blog.csdn.net/thestoryofsnow/article/details/6822576
 @author cyw
 *
 */
public class LinkedListCycleProblem141 {

	/*
	//Tortoise and hare algorithm. Floyd判圈算法(Floyd Cycle Detection Algorithm)
	//O(n)
    public boolean hasCycle(ListNode head) {
        //Tortoise-and-hare algorithm
        if(head==null) return false;
        ListNode Tortoise = head.next;
        if(Tortoise==null) return false;
        ListNode hare = turtoise.next;
            if(hare == null) return false;
        while(hare!=Tortoise){
            Tortoise = turtoise.next;
            //每次移两步
            hare = hare.next;
            if(hare == null) return false;
            hare = hare.next;
            if(hare == null) return false;
        }
        return true;
    }
	*/
	
	/**
	 龟兔解法的基本思想可以用我们跑步的例子来解释，
	 如果两个人同时出发，如果赛道有环，那么快的一方总能追上慢的一方。
	 进一步想，追上时快的一方肯定比慢的一方多跑了几圈，即多跑的路的长度是圈的长度的倍数。

1、环的检测
基于上面的想法，Floyd用两个指针，一个慢指针（龟）每次前进一步，
快指针（兔）指针每次前进两步（两步或多步效果是等价的，只要一个比另一个快就行，
从后面的讨论我们可以看出这一点）。如果两者在链表头以外的某一点相遇（即相等）了，
那么说明链表有环，否则，如果（快指针）到达了链表的结尾，那么说明没环。

2、环的位置
假设起点到环的起点距离为m，已经确定有环，环的周长为n，（第一次）相遇点距离环的起点的距离是k
。那么当两者相遇时，慢指针移动的总距离为i，i = m + a n + k，因为快指针移动速度为慢指针的两倍，
那么快指针的移动距离为2i，2i = m + b n + k。其中，a和b分别为慢指针和快指针在第一次相遇时
转过的圈数。我们让两者相减（快减慢），那么有i = (b - a) n=k+m。即i是圈长度的倍数。
利用这个结论我们就可以理解Floyd解法为什么能确定环的起点。
1）将一个指针移到链表起点，
2）另一个指针不变，即距离链表起点为i处，两者同时移动，每次移动一步。当第一个指针前进了m，
即到达环起点时，另一个指针距离链表起点为i + m。(b - a) n=k+m.考虑到i为圈长度的倍数，
可以理解为指针从链表起点出发，走到环起点，然后绕环转了几圈，所以第二个指针也必然在环的起点。
即两者相遇点就是环的起点。
	 */
	public boolean hasCycle(ListNode head) {
		if(head==null) return false;
		ListNode tor = head;
		if(tor.next==null) return false;
		ListNode hare = head.next;
		while(hare.next!=null){
			tor = tor.next;
			hare = hare.next;
			if(hare.next!=null) hare = hare.next;
			else return false;
			if(hare==tor) return true;
		}
		return false;
	}
	 class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) {
		         val = x;
		         next = null;
		     }
		 }
}
