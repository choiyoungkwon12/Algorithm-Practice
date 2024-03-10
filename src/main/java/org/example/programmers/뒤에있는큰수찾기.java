package org.example.programmers;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에있는큰수찾기 {
    public static void main(String[] args) {
        뒤에있는큰수찾기 s = new 뒤에있는큰수찾기();
        System.out.println(Arrays.toString(s.solution(new int[]{2, 3, 3, 5})));
        System.out.println(Arrays.toString(s.solution(new int[]{9, 1, 5, 3, 6, 2})));
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Arrays.fill(answer, -1);
        for (int i = 1; i < numbers.length; i++) {
            int number = numbers[i];
            while (!stack.isEmpty() && numbers[stack.peek()] < number) {
                answer[stack.pop()] = number;
            }
            stack.push(i);
        }

        return answer;
    }
}
