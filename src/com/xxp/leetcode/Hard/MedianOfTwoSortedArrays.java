package com.xxp.leetcode.Hard;

public class MedianOfTwoSortedArrays {
	public double find(int[] nums1, int[] nums2) {
		double median = 0;
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length, n = nums2.length;
        int iMin = 0, iMax = m;
        int i=0, j=0;
        while(iMin<=iMax){
            i = (iMin + iMax)/2;
            j = (m + n + 1)/2 - i;
            if(iMin < i && nums1[i-1] > nums2[j] ){
                iMax = i - 1;
            }
            else if(i < iMax && nums1[i] < nums2[j-1]){
                iMin = i + 1;
            }
            else{
                int maxLeft = 0;
                if(i == 0) maxLeft = nums2[j-1];
                else if(j == 0) maxLeft = nums1[i-1];
                else maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                if((m+n)%2 == 1) median = maxLeft;
                else{
                    int minRight = 0;
                    if(i == m) minRight = nums2[j];
                    else if(j == n) minRight = nums1[i];
                    else minRight = Math.min(nums1[i], nums2[j]);
                    median = 0.5*(maxLeft + minRight); 
                }
                break;
            }
        }
        return median;
	}
}
