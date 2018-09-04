package com.xxp.leetcode.Hard;

import com.xxp.leetcode.Common.ListNode;

public class MergeKSortsLists {
	public ListNode mergeKLists(ListNode[] lists) {
		return mergeKLists(lists, lists.length);
	}

	private ListNode mergeKLists(ListNode[] lists, int n) {
		int min = Integer.MAX_VALUE, index = 0;
		for (int i = 0; i < n;) {
			if (lists[i] == null) {
				lists[i] = lists[n - 1];
				lists[n - 1] = null;
				n--;
			} else {
				if (lists[i].val < min) {
					min = lists[i].val;
					index = i;
				}
				i++;
			}
		}
		if (n == 0)
			return null;
		if (n == 1)
			return lists[0];
		ListNode node = lists[index];
		lists[index] = lists[index].next;
		node.next = mergeKLists(lists, n);
		return node;
	}

}
