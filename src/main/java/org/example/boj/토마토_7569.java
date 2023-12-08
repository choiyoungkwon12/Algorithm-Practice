package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {
    private static int[] dx;
    private static int[] dy;
    private static int[][] map;
    private static int m,n,h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        dx = new int[]{0, 0, -1, 1, 0, 0};
        dy = new int[]{1, -1, 0, 0, n, -n};
        map = new int[n * h][m];


        Queue<Node> queue = new LinkedList<>();
        boolean full = true;
        for (int j = 0; j < n * h; j++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    queue.add(new Node(k, j));
                }
                if (value == 0) {
                    full = false;
                }
                map[j][k] = value;
            }
        }

        if (full) {
            System.out.println(0);
            return;
        }

        bfs(queue);
        int result = -2;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0){
                    System.out.println(-1);
                    return;
                } else {
                    result = Math.max(result, map[i][j]);
                }
            }
        }


        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        System.out.println(result - 1);
    }


    private static void bfs(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                 int nx = node.x + dx[i];
                 int ny = node.y + dy[i];

                int i1 = node.y / n;

                 if (nx >= 0 && ny >= (i1 * n) && nx < map[0].length && ny < ((i1 + 1) * n)) {
                     if (map[ny][nx] == 0) {
                         map[ny][nx] = map[node.y][node.x] + 1;
                         queue.add(new Node(nx, ny));
                     }
                 }
            }

            for (int i = 4; i < 6; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < map[0].length && ny < map.length) {
                    if (map[ny][nx] == 0) {
                        map[ny][nx] = map[node.y][node.x] + 1;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

