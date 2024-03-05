package org.example.programmers;

import java.io.IOException;

public class 멀리뛰기_12914 {
    public static void main(String[] args) throws IOException {
        멀리뛰기_12914 s = new 멀리뛰기_12914();
        System.out.println(s.solution(4));
    }

    public long solution(int n) {
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
