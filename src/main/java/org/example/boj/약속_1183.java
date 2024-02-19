package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약속_1183 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] hps = new int[n + 1];
        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int hp = Integer.parseInt(st1.nextToken());
            int happy = Integer.parseInt(st2.nextToken());
            hps[i] = hp;
            values[i] = happy;
        }

        int k = 99;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (hps[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j-hps[i]] + values[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);

    }
}
