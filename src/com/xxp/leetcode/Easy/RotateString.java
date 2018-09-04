package com.xxp.leetcode.Easy;

public class RotateString {
	public boolean rotateString(String A, String B) {
        if(A.length() != B.length()) return false;
        for(int offset = 0; offset < A.length(); offset++) {
        	int i = 0;
        	while(i < A.length())
        	{
        		if(A.charAt(i) != B.charAt((i + offset) % A.length())) break;
        		i++;
        	}
        	if(i == A.length()) {
        		return true;
        	}
        }
        return false;
    }
}
