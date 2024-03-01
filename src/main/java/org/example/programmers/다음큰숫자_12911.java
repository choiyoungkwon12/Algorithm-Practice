package org.example.programmers;

public class 다음큰숫자_12911 {
    public static void main(String[] args) {
        다음큰숫자_12911 s = new 다음큰숫자_12911();
        System.out.println(s.solution(78));
    }
    public int solution(int n) {
        int answer = 0;

        int nBinaryOneCount = Integer.toBinaryString(n).replace("0","").length();
        while (answer == 0) {
            n++;
            int count = Integer.toBinaryString(n).replace("0","").length();
            if (nBinaryOneCount == count) {
                answer = n;
            }
        }

        return answer;
    }
}
