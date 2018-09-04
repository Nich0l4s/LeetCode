package com.xxp.leetcode.Medium;

import java.util.LinkedList;

public class SimplifyPath {
	public String simplifyPath(String path) {
		LinkedList<String> list = new LinkedList<>(); 
		int off = 0, next = 0;
        while(off <= path.length()){
            if(off == path.length() || path.charAt(off) == '/'){
                String sub = path.substring(next, off);
                next = off + 1;
                if(sub.equals("..")){
                    if(list.size() > 0) list.removeLast();
                }
                else if (!sub.equals("") && !sub.equals(".")){
                    list.add(sub);
                }
            }
            off++;
        }
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append("/");
            sb.append(str);
        }
        return sb.length() == 0 ? "/" : sb.toString();
	}
	
	
	public String simplifyPath2(String path) {
		char[] p = path.toCharArray();
        char[] simple = new char[p.length];
        int[] starts = new int[p.length];
        int i = 0,j = 0, k = 0;
        while(i < p.length){
            if(p[i] == '/'){
                starts[k] = j;
                simple[j++] = ('/');
                i++;
                while(i<p.length && p[i] == '/'){
                    i++;
                }
            }
            else if(p[i] == '.' && (i + 1 >= p.length || p[i+1] == '/')){
                i += 1;
                j--;
            }
            else if(p[i] == '.' && p[i+1] == '.' && (i+2 >= p.length || p[i+2] == '/')){
                if(k>0) k--;
                j = starts[k];
                i += 2;
            }
            else{
                while(i<p.length && p[i] != '/'){
                    simple[j++] = p[i++];
                }
                k++;
            }
        }
        if(j > 0 && simple[j-1] == '/') j--;
        return j == 0 ? "/" : new String(simple, 0, j);
	}
}
