package org.example.programmers;

import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args) {
        택배상자 s = new 택배상자();
        System.out.println(s.solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(s.solution(new int[]{3, 2, 1, 4, 5}));
        System.out.println(s.solution(new int[]{5, 4, 3, 2, 1}));
    }

    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int n = 1; n <= order.length || !stack.isEmpty(); n++) {
            int i = order[index];
            if (n == i) {
                index++;
                answer++;
            } else if (n < i) {
                stack.push(n);
            } else {
                n--;
                if (!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    if (i == pop) {
                        answer++;
                        index++;
                    } else {
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
