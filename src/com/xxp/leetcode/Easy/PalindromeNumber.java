package com.xxp.leetcode.Easy;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if(x<0) return false;
        int n = 0, num = x;
        while(num !=0){
            num /= 10;
            n++;
        }
        int rev = 0;
        for(int i=0, j=x; i<n/2; i++){
            rev *= 10;
            rev += j%10;
            j /= 10;
        }
        return rev == x/(int)Math.pow(10, (n+1)/2);
    }
}
