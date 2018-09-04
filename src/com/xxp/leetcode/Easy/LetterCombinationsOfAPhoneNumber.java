package com.xxp.leetcode.Easy;
import java.util.LinkedList;
import java.util.List;
public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
        String[] keys = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> l = new LinkedList<String>();
        if(digits == null || digits.length() == 0) return l;
        l.add("");
        while(l.peek().length() < digits.length()){
            String pop = l.remove();
            for(char c:keys[digits.charAt(pop.length()) - '2'].toCharArray()){
                l.add(pop+c);
            }
        }
        return l;
	}
}
