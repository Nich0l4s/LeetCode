package com.xxp.leetcode.Medium;
public class NextPermutation {
	public void nextPermutation(int[] nums) {
        int pole = nums.length-1;
        while(pole>0 && nums[pole-1]>=nums[pole]){
            pole--;    
        }
        if(pole > 0){
            for(int i=nums.length-1; i>=pole; i--){
                if(nums[i]>nums[pole-1]){
                    int temp = nums[i];
                    nums[i] = nums[pole-1];
                    nums[pole-1] = temp;
                    break;
                }
            }
        }
        for(int i=nums.length-1, j=pole; i>j; i--,j++){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
