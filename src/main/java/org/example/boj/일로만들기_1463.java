package org.example.boj;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 일로만들기_1463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 정수 N 입력 받기
        int N = scanner.nextInt();

        // DP 배열 초기화
        int[] dp = new int[N + 1];

        // DP 진행 (Bottom-Up)
        for (int i = 2; i <= N; i++) {
            // 1을 뺀 경우의 수를 먼저 계산
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);

            // 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        // 결과 출력
        System.out.println(dp[N]);

    }
}
