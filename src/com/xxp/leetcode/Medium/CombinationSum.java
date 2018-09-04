package com.xxp.leetcode.Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(candidates.length == 0) return list;
        Arrays.sort(candidates);
        for(int i=Math.round((float)target/candidates[candidates.length-1]); i<=target/candidates[0]; i++){
            combination(list, new LinkedList<Integer>(), candidates, target, 0, i);
        }
        return list;
    }
    public void combination(List<List<Integer>> list, LinkedList<Integer> l, int[] candidates, int target, int start, int nums){
        if(nums == 1){
            int idx = Arrays.binarySearch(candidates, start, candidates.length, target);
            if(idx >= 0){
                List<Integer> l1 = new LinkedList<>(l);
                l1.add(candidates[idx]);
                list.add(l1);
            }
            return;
        }
        for(int i=start; i<candidates.length; i++){
            int sum = target - candidates[i];
            if(sum < candidates[i]) return;
            else{
                l.add(candidates[i]);
                combination(list, l, candidates, sum, i, nums-1);
                l.removeLast();
            }
        }
    } 
}