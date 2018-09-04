package com.xxp.leetcode.Easy;

public class LongestCommonPrefix {

	// 横向扫描
	public String HorizontalScanning(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	// 纵向扫描
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}

	// 分治�?
	public String DivideAndConquer(String[] strs, int l, int r) {
		if (l == r)
			return strs[l];
		int mid = (l + r) / 2;
		String comPreL = DivideAndConquer(strs, l, mid);
		String comPreR = DivideAndConquer(strs, mid + 1, r);
		return comPrefix(comPreL, comPreR);
	}

	public String DivideAndConquer(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}

	private String comPrefix(String left, String right) {
		int minLen = Math.min(left.length(), right.length());
		for (int i = 0; i < minLen; i++) {
			if (left.charAt(i) != right.charAt(i))
				return left.substring(0, i);
		}
		return left.substring(0, minLen);
	}

	// 二分法，寻找上界
	public String LCPBinarySearch(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int l = 1, r = strs[0].length();
		while (l <= r) {
			int mid = (l + r) / 2;
			if (isComPre(strs, mid)) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return strs[0].substring(0, (l + r) / 2);
	}

	private boolean isComPre(String[] strs, int edge) {
		for (int i = 1; i < strs.length; i++) {
			if (!strs[i].startsWith(strs[0].substring(0, edge)))
				return false;
		}
		return true;
	}
}
