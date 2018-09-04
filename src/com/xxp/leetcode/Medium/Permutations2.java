package com.xxp.leetcode.Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2{
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return list;
        Arrays.sort(nums);
        ArrayList<Integer> l = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        permuteUnique(nums, list, l, used);
        return list;
    }
    private void permuteUnique(int[] nums, List<List<Integer>> list, List<Integer> l, boolean[] used){
        if(l.size() == nums.length){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i]) continue;
            used[i] = true;
            l.add(nums[i]);
            permuteUnique(nums, list, l, used);
            used[i] = false;
            l.remove(l.size()-1);
            while(i+1<nums.length && nums[i] == nums[i+1]){
                i++;
            }
        }
    }
}