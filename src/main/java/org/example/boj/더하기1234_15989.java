package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 더하기1234_15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;


        for (int i = 4; i < 10001; i++) {
            dp[i][1] = 1; // 1로 만듬
            dp[i][2] = dp[i-2][2] + dp[i-2][1]; // 2로 시작
            dp[i][3] = dp[i-3][3] + dp[i-3][2] + dp[i-3][1]; // 3으로 시작
        }

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }

    }
}
