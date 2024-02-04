package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int arrayNumber = array[i];
            int dpNumber = dp[i];
            for (int j = 0; j < i; j++) {
                int list1 = array[j];
                int dp2 = dp[j];
                if (arrayNumber > list1) {
                    if (dpNumber <= dp2 + 1) {
                        dp[i] = dp2 + 1;
                        dpNumber = dp[i];
                    }
                }
            }
        }

        int asInt = Arrays.stream(dp).max().getAsInt();
        System.out.println(asInt);
    }
}
