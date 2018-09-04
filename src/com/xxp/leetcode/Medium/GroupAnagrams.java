package com.xxp.leetcode.Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
                101 };
        HashMap<Integer, Integer> indexes = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            int key = 1;
            for (char c : str.toCharArray()) {
                key *= primes[c - 'a'];
            }
            List<String> list;
            if (indexes.containsKey(key)) {
                int index = indexes.get(key);
                list = res.get(index);
            } else {
                list = new ArrayList<>();
                res.add(list);
                indexes.put(key, res.size() - 1);
            }
            list.add(str);
        }
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        char[][] chs = new char[n][];
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < n; i++) {
            chs[i] = strs[i].toCharArray();
            Arrays.sort(chs[i]);
            String s = new String(chs[i]);
            if (map.containsKey(s)) {
                map.get(s).add(strs[i]);
            } else {
                ArrayList<String> l = new ArrayList<String>();
                l.add(strs[i]);
                map.put(s, l);
            }
        }
        List<List<String>> list = new ArrayList<List<String>>(map.values());
        return list;
    }
}