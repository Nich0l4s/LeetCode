package com.xxp.leetcode.Easy;

public class ClimbingStairs {
	public int climbStairs(int n) {
        int i = 2;
        int n1 = 1, n2 = 2;
        while(i<n){
            n1 = n1 + n2;
            n2 = n2 + n1;
            i += 2;
        }
        return n%2 == 1 ? n1 : n2;
    }
	public int climbStairs2(int n) {
        return (int)Math.round(2/(5-Math.sqrt(5))*Math.pow((1+Math.sqrt(5))/2, n)+(3-Math.sqrt(5))/2*Math.pow((1-Math.sqrt(5))/2, n));
    }
}
