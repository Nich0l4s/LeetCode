package com.xxp.leetcode.Hard;

public class RegularExpressionMatching {
	public boolean isMatching(String s, String p) {
		if (p.isEmpty())
			return s.isEmpty();
		boolean match = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
		if (1 < p.length() && p.charAt(1) == '*') {
			return match && isMatching(s.substring(1), p) || isMatching(s, p.substring(2));
		} else
			return match && isMatching(s.substring(1), p.substring(1));
	}
}
