package org.example.programmers;

public class 피보나치수_12945 {
    public static void main(String[] args) {
        피보나치수_12945 s = new 피보나치수_12945();
        System.out.println(s.solution(3));
        System.out.println(s.solution(5));
    }

    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}
