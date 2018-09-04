package com.xxp.leetcode.Medium;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
        int[] factorials = new int[n];
        char[] chs = new char[n];
        int factor = 1, factorial = 1;
        int num = k;
        for(int i=0; i<n; i++){
            factorial *= factor;
            factorials[i] = factorial;
            factor++;
            chs[i] = (char)(i+'1');
        }
        for(int i=0; i<n-1; i++){
        	num = num % factorials[n-1-i];
        	if(num == 0) {
        		for(int off=0; off<(n-i)/2; off++) {
        			char temp = chs[i+off];
        			chs[i+off] = chs[n-1-off];
        			chs[n-1-off] = temp;
        		}
        		break;
        	}
        	if(num == 1){
        		break;
        	}
            int j = (num-1)/factorials[n-2-i];
            char temp = chs[i+j];
            for(int l=i+j-1; l>=i; l--){
                chs[l+1] = chs[l];
            }
            chs[i] = temp;
        }
        return new String(chs);
    }
}
