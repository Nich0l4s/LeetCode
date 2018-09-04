package com.xxp.leetcode.Easy;

public class Sqrt {
	public int mySqrt(int x) {
		double t = x / 2.0;
        double sqrtn = 0;
        while(t*t != x && t != sqrtn){
            sqrtn = t;
            t = (t + x/t) / 2;
        }
        return (int) t;
    }
}
