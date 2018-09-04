package com.xxp.leetcode.Medium;
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        permute(nums, 0, list, new ArrayList<Integer>());
        return list;
    }

    private void permute(int[] nums, int start, List<List<Integer>> list, List<Integer> l) {
        if (start == nums.length - 1) {
            ArrayList<Integer> l1 = new ArrayList<>(l);
            l1.add(nums[start]);
            list.add(l1);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            l.add(nums[start]);
            permute(nums, start + 1, list, l);
            l.remove(l.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}