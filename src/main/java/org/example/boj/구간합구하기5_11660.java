package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 구간합구하기5_11660 {
    private static int[][] MAP, SUM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        MAP = new int[n + 1][n + 1];
        SUM = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int prefixSum = 0;
            for (int j = 1; j <= n; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                MAP[i][j] = i1;
                prefixSum += i1;
                SUM[i][j] = SUM[i - 1][j] + prefixSum;
            }
        }
/*
예제
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
행간 구간합
1 3 6 10
2 5 9 14
3 7 12 18
4 9 15 22
전체 기준 구간합 (해당 위치의 구간합은 해당 행 구간합 + 열은 같지만 행-1 위치의 구간합을 더한 것과 같음
1, 3, 6, 10
3, 8, 15, 24
6, 15, 27, 42
10, 24, 42, 64

y,x y,x
2,2 3,4

정답 구하는 방법은
(x2,y2) - 가장 오른쪽 아래
(x2,y1-1) - 계산에 포함되지 않는 왼쪽 열
(x1-1,y2) - 계산에 포함되지 않는 윗 행
(x1-1, y1-1) - 두번 재거된 부분

 */
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = SUM[x2][y2] - SUM[x1 - 1][y2] - SUM[x2][y1 - 1] + SUM[x1 - 1][y1 - 1];
            System.out.println(result);
        }

    }
}
