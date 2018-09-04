package com.xxp.leetcode.Easy;
import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		hm.put('I', 1);
		hm.put('V', 5);
		hm.put('X', 10);
		hm.put('L', 50);
		hm.put('C', 100);
		hm.put('D', 500);
		hm.put('M', 1000);
		int base = 0;
		int num = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int val = hm.get(s.charAt(i));
			if(base > val) {
				num += val * -1;
			}
			else {
				num += val;
				base = val;
			}
		}
		return num;
	}
}
