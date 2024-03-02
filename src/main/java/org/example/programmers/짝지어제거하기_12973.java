package org.example.programmers;

import java.util.Stack;

public class 짝지어제거하기_12973 {
    public static void main(String[] args) {
        짝지어제거하기_12973 s = new 짝지어제거하기_12973();
        System.out.println(s.solution("baabaa"));
        System.out.println(s.solution("cdcd"));
    }
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
