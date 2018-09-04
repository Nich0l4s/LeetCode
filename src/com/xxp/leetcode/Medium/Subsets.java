package com.xxp.leetcode.Medium;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        int[] ends = new int[nums.length];
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> empty = new ArrayList<>();
        res.add(empty);
        int last = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(last == 0) res.add(Arrays.asList(nums[j]));
                else{
                    for(int k=ends[j]+1; k<last; k++){
                        ArrayList<Integer> l = new ArrayList<>();
                        l.add(nums[j]);
                        l.addAll(res.get(k));
                        res.add(l);
                    } 
                }
                ends[j] = res.size()-1;
            }
            last = res.size();
        }
        return res;
    }
	public List<List<Integer>> subsets2(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i : nums){
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> set : res){
                ArrayList<Integer> l = new ArrayList<>(set);
                l.add(i);
                temp.add(l);
            }
            res.addAll(temp);
        }
        return res;
    }
}
