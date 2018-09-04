package com.xxp.leetcode.Medium;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        int pivot = l;
        l = 0;
        r = nums.length -1;
        while(l<=r){
            int mid = (l+r)/2;
            int realMid = (mid + pivot) % nums.length;
            if(nums[realMid] == target){
                return realMid;
            }
            else if(target > nums[realMid]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return -1;
    }
	public int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l<=r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] <= nums[r]){
                if(target <= nums[r] && target > nums[mid]){
                    l = mid + 1;
                }
                else r = mid - 1;
            }
            else if(nums[mid] > nums[r]){
                if(target < nums[mid] && target > nums[r]){
                    r = mid - 1;
                }
                else l = mid + 1;
            }
        }
        return -1;
    }
}
