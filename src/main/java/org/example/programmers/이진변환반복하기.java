package org.example.programmers;

import java.util.Arrays;

public class 이진변환반복하기 {
    public static void main(String[] args) {
        이진변환반복하기 s = new 이진변환반복하기();
        System.out.println(Arrays.toString(s.solution("110010101001")));
        System.out.println(Arrays.toString(s.solution("01110")));
        System.out.println(Arrays.toString(s.solution("1111111")));
    }
    public int[] solution(String s) {
        int[] answer = {};
        int count = 0;
        int zeroCount = 0;
        while (!s.equals("1")) {
            count++;

            int before = s.length();
            s = s.replaceAll("0", "");
            int after = s.length();
            zeroCount += before - after;

            s = Integer.toBinaryString(after);
        }
        answer = new int[]{count, zeroCount};
        return answer;
    }
}
