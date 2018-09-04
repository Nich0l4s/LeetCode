package com.xxp.leetcode.Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2 && nums[i] <= 0;) {
			for (int j = i + 1, k = nums.length - 1; j < k;) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum > 0)
					k--;
				else if (sum < 0)
					j++;
				else {
					ArrayList<Integer> al = new ArrayList<Integer>();
					al.add(nums[i]);
					al.add(nums[j]);
					al.add(nums[k]);
					l.add(al);
					k--;
					j++;
				}
			}
			int next = i;
			while (next < nums.length - 2 && nums[++next] == nums[i])
				;
			i = next;
		}
		return l;
	}
}
