package com.xxp.leetcode.Easy;

public class ReverseInteger {
	public int get(int x) {
		int rev = 0;
        for(int base=10; x<=-10 || x>=10; x/=10){
            rev *= base;
            rev += x%10;
        }
        if((rev>=0 && rev>(Integer.MAX_VALUE-x)/10) || (rev<0 && rev<(Integer.MIN_VALUE-x)/10)){
            return 0;
        }
        else return rev*10 + x;
	}
}
