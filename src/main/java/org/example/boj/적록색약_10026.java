package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 적록색약_10026 {
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int result = bfs();
        Arrays.stream(visited).forEach(booleans -> Arrays.fill(booleans, false));
        int result1 = bfsWithSameRG();
        System.out.println(result + " " + result1);
    }

    private static int bfs() {
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!visited[i][j]) {
                    queue.add(new Node(map[i][j], i, j));
                    visited[i][j] = true;
                    count++;
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = node.r + dx[k];
                            int ny = node.c + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[node.c].length && !visited[nx][ny]) {
                                if (map[nx][ny] == map[node.r][node.c]) {
                                    queue.add(new Node(map[nx][ny], nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static int bfsWithSameRG() {
        int count = 0;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!visited[i][j]) {
                    queue.add(new Node(map[i][j], i, j));
                    visited[i][j] = true;
                    count++;
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = node.r + dx[k];
                            int ny = node.c + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[node.c].length && !visited[nx][ny]) {
                                if ((map[nx][ny] == map[node.r][node.c]) || ((map[node.r][node.c] == 'R' || map[node.r][node.c] == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G'))) {
                                    queue.add(new Node(map[nx][ny], nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static class Node {
        char current;
        int r;
        int c;

        public Node(char current, int r, int c) {
            this.current = current;
            this.r = r;
            this.c = c;
        }
    }
}
