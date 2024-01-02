package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컴백홈_1189 {
    //    private static char[][] map;
    private static char[][] map;
    private static boolean[][] visited;
    private static int answer = 0;
    private static int k, r, c;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < c; j++) {
                char c1 = s.charAt(j);
                map[i][j] = c1;
            }
        }

        visited[r-1][0] = true;
        dfs(r - 1, 0, 1);

        System.out.println(answer);
    }

    private static void dfs(int row, int column, int depth) {
        if (row == 0 && column == c - 1) {
            if (depth == k) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = column + dy[i];
            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }
            if (visited[nx][ny] || map[nx][ny] == 'T') {
                continue;
            }
            visited[nx][ny] = true;
            dfs(nx, ny, depth+1);
            visited[nx][ny] = false;
        }
    }
}
