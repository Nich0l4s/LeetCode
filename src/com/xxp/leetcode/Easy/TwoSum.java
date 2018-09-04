package com.xxp.leetcode.Easy;
import java.util.HashMap;

public class TwoSum {
	public int[] Search(int[] numbers, int target) {
		int[] a = {1, 2};
		return a;
	}
	public int[] SearchMap(int[] numbers, int target) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i<numbers.length; i++) {
			if(hm.containsKey(target - numbers[i])) {
				return new int[] {hm.get(target - numbers[i]), i};
			} 
			else {
				hm.put(numbers[i], i);
			}
		}
		return new int[] {-1, -1};
	}
}
