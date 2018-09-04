package com.xxp.leetcode.Medium;

public class LongestPalindromicSubstring {
	public String getLongestPalindrome(String s) {
		if (s.length() <= 1)
			return s;
		char[] sPad = new char[s.length() * 2 + 1];
		int[] p = new int[sPad.length];
		for (int i = 0; i < s.length(); i++) {
			sPad[i * 2] = '#';
			sPad[i * 2 + 1] = s.charAt(i);
		}
		sPad[sPad.length - 1] = '#';
		int c = 0, right = 0;
		p[0] = 0;
		for (int i = 1; i < sPad.length; i++) {
			p[i] = i < right ? Math.min(p[2 * c - i], right - i) : 0;
			while (i + p[i] + 1 < sPad.length && i - p[i] - 1 >= 0 && sPad[i + p[i] + 1] == sPad[i - p[i] - 1]) {
				p[i]++;
			}
			if (i + p[i] > right) {
				c = i;
				right = c + p[c];
			}
		}
		int index = 0, max = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i] > max) {
				max = p[i];
				index = i;
			}
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i <= p[index]; i++) {
			sb.append(sPad[index - p[index] + 2 * i - 1]);
		}
		return sb.toString();
	}
}
