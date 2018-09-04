package com.xxp.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return res; 
        restore(s.toCharArray(), 0, 1, res, "");
        return res;
    }
    private void restore(char[] s, int idx, int order, List<String> res, String IP){
        if(order == 4){
            if(s[idx] == '0' && idx < s.length - 1) return;
        	int temp = Integer.parseInt(new String(s, idx, s.length - idx));
            if(temp>=0 && temp <= 255)
            	res.add(IP+temp);
            return;
        }
        if(s[idx] == '0') restore(s, idx+1, order+1, res, IP + "0" + (order < 4 ? "." : ""));
        else{
            int value = 0;
            for(int i=idx; i<Math.min(idx+3, s.length-(4-order)); i++){
                value *= 10;
                value += s[i] - '0';
                if(value>0 && value <= 255){
                    restore(s, i+1, order + 1, res, IP + value + (order < 4 ? "." : ""));
                }
                else break;
            }
        }
    }
    public List<String> restoreIpAddresses2(String s) {
        ArrayList<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return res; 
        int len = s.length();
        String one, two, three, four;
        for(int i=0; i<len-3; i++){
            if(!isValid(one = s.substring(0,i+1))) break;
            for(int j=i+1; j<len-2; j++){
                if(!isValid(two = s.substring(i+1,j+1))) break;
                for(int k=j+1;k<len-1; k++){
                    if(!isValid(three = s.substring(j+1,k+1))) break;
                    if(isValid(four = s.substring(k+1, len))){
                        res.add(one + "." + two + "." + three + "." + four);   
                    }
                }
            }
        }
        return res;
    }
    private boolean isValid(String str){
        if(str == null || str.length() == 0 || (str.charAt(0) == '0' && str.length() >0) || Integer.parseInt(str)>255){
            return false;
        }
        return true;
    }
}
