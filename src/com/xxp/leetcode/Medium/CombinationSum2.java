package com.xxp.leetcode.Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        combination(list, l, candidates, target, 0);
        return list;
    }

    private void combination(List<List<Integer>> list, List<Integer> l, int[] candidates, int target, int start) {
        if (target == 0) {
            list.add(new ArrayList<Integer>(l));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i == start || candidates[i] != candidates[i - 1]) {
                int current = candidates[i];
                if (target < current)
                    return;
                else {
                    l.add(current);
                    combination(list, l, candidates, target - current, i + 1);
                    l.remove(l.size() - 1);
                }
            }
        }
    }
}