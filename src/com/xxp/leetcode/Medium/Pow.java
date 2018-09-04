package com.xxp.leetcode.Medium;
public class Pow{
    public double myPow(double x, int n) {
        if(x == 0.0 || x == 1.0 || n == 1) return x;
        if(n == 0) return 1;
        long pow = Math.abs((long)n);
        double res = 0.0;
        double[] p = new double[33];
        p[0] = 1.0;
        p[1] = x;
        long i = 2;
        for(int j=2; i<=pow; j++){
            p[j] = p[j-1]*p[j-1];
            res = p[j];
            i *= 2;
        }
        long dif = pow - i/2;
        for(int j=1; dif != 0; j++){
            if((dif & 1) == 1){
                res *= p[j];
            }
            dif >>= 1;
        }
        return n < 0 ? 1/res : res;
    }
}