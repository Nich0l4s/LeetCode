package com.xxp.leetcode.Medium;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) {
        	sb[i] = new StringBuilder();
        }
        int row = 0;
        int inc = 1;
        for(int i=0; i<s.length(); i++){
            sb[row].append(s.charAt(i));
            if(row == 0) inc = 1;
            else if(row == numRows - 1) inc = -1;
            row += inc;
        }
        for(int i=1; i<numRows; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
