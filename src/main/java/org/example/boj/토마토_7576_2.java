package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576_2 {

    private static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int map[][];
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    Tomato tomato = new Tomato(i, j);
                    queue.add(tomato);
                }
            }
        }
        bfs(queue);
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < map.length; i++) {
            int[] ints = map[i];
            for (int j = 0; j < ints.length; j++) {
                int v = ints[j];
                if (v == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, map[i][j]);
            }
        }
        System.out.println(result -1 );
    }

    private static void bfs(Queue<Tomato> queue) {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] += map[tomato.x][tomato.y] + 1;
                        queue.add(new Tomato(nx, ny));
                    }
                }
            }
        }
    }
}







