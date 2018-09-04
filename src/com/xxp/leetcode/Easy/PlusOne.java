package com.xxp.leetcode.Easy;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        int i=digits.length-1;
        while(i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i--;
        }
        if(i>=0){
            digits[i]++;
            return digits;
        }
        else{
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
    }
}
