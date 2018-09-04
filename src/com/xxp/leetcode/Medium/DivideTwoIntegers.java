package com.xxp.leetcode.Medium;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
        if(divisor == 1) return dividend;
        if(divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE :-dividend;
        int res = negativeDivide(-Math.abs(dividend), -Math.abs(divisor));
        return Integer.signum(dividend) == Integer.signum(divisor) ? res : -res;
    }
    private int negativeDivide(int d1, int divisor){
        if(d1 > divisor) return 0;
        int quotient = 0;
        int bq = 1;
        int diff = d1;
        for(int i=divisor; diff < i && i<0; i+=i){
        	diff -= i;
            quotient +=bq;
            bq += bq;
        }
        return quotient + negativeDivide(diff, divisor);
    }
}
