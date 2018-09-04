package com.xxp.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        combine(res, list, n, 1, k);
        return res;
    }
    private void combine(List<List<Integer>> res, ArrayList<Integer> list, int n, int m, int k){
        if(k == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=m; i <= n-k + 1; i++){
            list.add(i);
            combine(res, list, n, i+1, k-1);
            list.remove(list.size()-1);
        }
    }
}
