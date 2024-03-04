package org.example.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */
public class 예상대진표_12985 {
    public static void main(String[] args) {
        예상대진표_12985 s = new 예상대진표_12985();
        System.out.println(s.solution(8, 4, 7));
    }

    public int solution(int n, int a, int b) {
        int answer = 0;
        while (true) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
            if (a == b) {
                break;
            }
        }

        return answer;
    }
}
