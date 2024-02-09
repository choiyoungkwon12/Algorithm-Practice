package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전2_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }
        Arrays.sort(coins);

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        int result = dp[k] == 10001 ? -1 : dp[k];
        System.out.println(result);
    }
}
