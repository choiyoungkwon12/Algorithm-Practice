package org.example.programmers;

import java.util.Stack;

public class 올바른괄호_12909 {
    public static void main(String[] args) {
        올바른괄호_12909 s = new 올바른괄호_12909();
        System.out.println(s.solution("()()"));
        System.out.println(s.solution("(())()"));
        System.out.println(s.solution(")()("));
        System.out.println(s.solution("(()("));
    }

    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        boolean answer = false;
        boolean isFinish = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push("(");
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                stack.pop();
            }
            if (i == s.length()-1) {
                isFinish = true;
            }
        }
        if (isFinish) {
            answer = stack.isEmpty();
        }
        return answer;
    }
}
