package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 20분정도 풀다가 포기.-> 2~max 까지의 비가 잠긴 경우에 대한 것을 구하고, 그중 안정 영역이 많은 것을 골라야 하는데 3이하의 안전영역, 4이하의 안전영역을 구하는 방법을 까먹음
// Bfs 로 시도
// ----
// bfs 정답보다 dfs가 더 나은거 같다.


public class 안전영역_2468 {
    private static int[][] map;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                map[i][j] = i1;
                if (i1 > max) {
                    max = i1;
                }
            }
        }
        int answer = 1;
        for (int i = 0; i < max; i++) {
            visited = new boolean[n][n];
            int count = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (map[x][y] > i && !visited[x][y]) {
                        bfs(x,y,i);
                        count++;
                    }
                }
                if (answer < count) {
                    answer = count;
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int x, int y, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int cx = point[0];
            int cy = point[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length) {
                    if (!visited[nx][ny] && map[nx][ny] > target) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
