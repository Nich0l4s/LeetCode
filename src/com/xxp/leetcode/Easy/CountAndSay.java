package com.xxp.leetcode.Easy;
public class CountAndSay{
    public String countAndSay(int n){
        String last = "1";
        if(n == 1) return last;
        for(int i=1; i<n; i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j=1; j<last.length(); j++){
                if(last.charAt(j) != last.charAt(j-1)){
                    sb.append(count);
                    sb.append(last.charAt(j-1));
                    count = 1;
                }
                else{
                    count++;
                }
            }
            sb.append(count);
            count = 1;
            sb.append(last.charAt(last.length()-1));
            last = sb.toString();
        }
        return last;
    }
}