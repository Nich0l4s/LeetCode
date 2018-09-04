package com.xxp.leetcode.Medium;

public class IntegerToRoman {
	private String[] Thousand = { "", "M", "MM", "MMM" };
	private String[] Hundred = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
	private String[] Ten = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	private String[] One = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

	public String intToRoman(int num) {
		return Thousand[num / 1000] + Hundred[num % 1000 / 100] + Ten[num % 100 / 10] + One[num % 10];
	}
}
