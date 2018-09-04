package com.xxp.leetcode.Medium;

import com.xxp.leetcode.Common.ListNode;

public class AddTwoNumbers {
	public ListNode Add(ListNode l1, ListNode l2) {
		 int carry = 0;
	        ListNode preHead = new ListNode(0);
	        ListNode current = preHead;
	        while(l1 != null || l2 != null || carry != 0){
	            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
	            current.next = new ListNode(sum % 10);
	            carry = sum / 10;
	            current = current.next;
	            l1 = l1!=null ? l1.next:l1;
	            l2 = l2!=null ? l2.next:l2;
	        }
	        return preHead.next;
	}
}
