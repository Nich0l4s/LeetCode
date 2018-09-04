package com.xxp.leetcode.Medium;

public class SortColors {
	public void sortColors(int[] nums) {
        int red = -1, white = -1, blue = -1;
        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0){
                nums[++blue] = 2;
                nums[++white] = 1;
                nums[++red] = 0;
            }
            else if(nums[i] == 1){
                nums[++blue] = 2;
                nums[++white] = 1;
            }
            else blue++;
        }
    }
}
