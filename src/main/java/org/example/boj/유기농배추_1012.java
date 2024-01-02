package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추_1012 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            visited = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            System.out.println(bfs());
        }
    }

    // 맵 전체를 순회 하면서 1이 나오면 근처를 bfs 순회해서 visit 처리하고 count + 1. -> 맵 전체 순회
    private static int bfs() {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Queue<Node> queue = new LinkedList<>();
                int i1 = map[i][j];
                if (i1 == 1) {
                    if (!visited[i][j]) {
                        queue.add(new Node(i, j));
                        count++;
                    }
                }
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    visited[node.x][node.y] = true;
                    for (int q = 0; q < 4; q++) {
                        int nx = node.x + dx[q];
                        int ny = node.y + dy[q];
                        if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny] && map[nx][ny] == 1) {
                            visited[nx][ny] = true;
                            queue.add(new Node(nx, ny));
                        }
                    }
                }
            }
        }
        return count;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
