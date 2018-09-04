package com.xxp.leetcode.Easy;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        if(s.length()%2 == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            switch(c){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if(stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
	}
}
