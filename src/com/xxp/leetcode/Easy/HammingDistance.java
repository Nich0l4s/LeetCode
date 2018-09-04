package com.xxp.leetcode.Easy;

public class HammingDistance {
	public int distance(int x, int y) {
		int num = x ^ y;
		int sum = 0;
		while (num != 0) {
			System.out.println(num);
			sum += (num & 1);
			num = num >> 1;
		}
		return sum;
	}
}
