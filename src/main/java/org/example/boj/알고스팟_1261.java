package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 알고스팟_1261 {
    private static int[][] map;
    private static int[][] distance;
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    private static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // x
        n = Integer.parseInt(st.nextToken()); // y
        map = new int[n][m];
        distance = new int[n][m];
        for (int[] ints : distance) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        bfs();
        System.out.println(distance[n-1][m-1]);
    }

    private static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0,0});
        while (!queue.isEmpty()) {
            Integer[] integers = queue.poll();
            for (int i = 0; i < 4; i++) {
                Integer y = integers[0];
                int ny = y + dy[i];
                Integer x = integers[1];
                int nx = x + dx[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (distance[ny][nx] > distance[y][x] + map[y][x]) {
                        distance[ny][nx] = distance[y][x] + map[y][x];
                        queue.add(new Integer[]{ny,nx});
                    }
                }
            }
        }
    }

}
