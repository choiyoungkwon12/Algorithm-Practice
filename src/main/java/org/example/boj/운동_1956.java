package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플로이드 워셜
 * - 모든 시작점에서 모든 경로에 대한 최단거리 찾기
 * - i -> j, j -> i 로 가는 최단 경로 모두 초기값 987654321 이 아니면 사이클 발생한다는 뜻.
 * - 중간에 어떤 경로를 지나가는것과는 상관없이 사이클 발생.
 * - 그래서 모든 경로에 대한 탐색 후 가장 작은 사이클 찾기
 * - 초기값을 Integer.MAX_VALUE로 하게 되면 Math.min(answer, arr[i][j] + arr[j][i]) 이 로직에서 arr[i][j] + arr[j][i] 에서 오버플로우가 발생하여 -21억~ 숫자가 되고 값이 이상하게 나오게 됨.
 */
public class 운동_1956 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int INF = 987654321;
        int answer = 987654321;
        int[][] arr = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }
        // 플로이드 와샬 알고리즘 수행
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (i == j) {
                        continue;
                    }
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) {
                    continue;
                }

                if (arr[i][j] != INF && arr[j][i] != INF) {
                    answer = Math.min(answer, arr[i][j] + arr[j][i]);
                }
            }
        }

        answer = (answer == INF) ? -1 : answer;
        System.out.println(answer);
    }
}
