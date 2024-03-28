package org.example.programmers;

import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        괄호회전하기 s = new 괄호회전하기();
        System.out.println(s.solution("[](){}"));
        System.out.println(s.solution("}]()[{"));
        System.out.println(s.solution("[)(]"));
    }

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i) + s.substring(0, i);
            if (isCorrect(substring)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isCorrect(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String s1 = String.valueOf(s.charAt(i));
            if (!stack.isEmpty()) {
                if (stack.peek().equals("{") && s1.equals("}")) {
                    stack.pop();
                    continue;
                }
                if (stack.peek().equals("[") && s1.equals("]")) {
                    stack.pop();
                    continue;
                }
                if (stack.peek().equals("(") && s1.equals(")")) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(s1);
        }
        return stack.isEmpty();
    }
}
