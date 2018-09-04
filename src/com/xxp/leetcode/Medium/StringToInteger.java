package com.xxp.leetcode.Medium;

public class StringToInteger {
	public int get(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int sign = 1;
		int p = 0;
		int res = 0;
		while (p < str.length() && str.charAt(p) == ' ')
			p++;
		if (p < str.length()) {
			if (str.charAt(p) == '-') {
				sign = -1;
				p++;
			} else if (str.charAt(p) == '+') {
				sign = 1;
				p++;
			}
		}
		while (p < str.length() && str.charAt(p) >= '0' && str.charAt(p) <= '9') {
			int tail = (str.charAt(p) - '0') * sign;
			int temp = res * 10 + str.charAt(p) - '0';
			System.out.println(temp);
			if ((temp - tail) / 10 != res)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			res = temp;
			p++;
		}
		return res * sign;
	}
}
