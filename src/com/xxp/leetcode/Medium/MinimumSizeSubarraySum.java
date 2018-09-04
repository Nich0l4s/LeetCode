package com.xxp.leetcode.Medium;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int p1 = 0, p2 = 0, sum = 0, count;
		while(p2 < nums.length && sum < s) {
			sum += nums[p2++];
		}
		if(sum < s) return 0;
		while(p2 < nums.length) {
			sum -= nums[p1++];
			if(sum < s) {
				sum += nums[p2++];
			}
		}
		while((sum -= nums[p2++]) >= s)
			;
		count = p2 - p1 + 1;
		return count;
	}
	public int minSubArrayLen2(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int[] sums = new int[nums.length+1];
        for(int i=1; i<sums.length; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
        if(sums[sums.length-1]<s) return 0;
        for(int i=1; i<sums.length; i++){
            int end = bSearch(sums, s + sums[i-1], i, sums.length);
            if(end < sums.length) min = Math.min(min, end - i + 1);
        }
        return min;
    }
    private int bSearch(int[] sums, int target, int start, int end){
        int l = start, r = end;
        while(l<r){
            int mid = l + (r - l) / 2;
            if(sums[mid] < target) l = mid + 1;
            else if(sums[mid] > target) r = mid;
            else return mid;
        }
        return l;
    }
}
