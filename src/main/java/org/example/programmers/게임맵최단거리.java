package org.example.programmers;

import java.util.LinkedList;
import java.util.Queue;

// 풀이 14분 걸림
// bfs 문제로 1,1 시작 -> n,m 가는 가장 최단 거리 찾는 문제
// 시작 시점 큐에 넣고, 큐에 있는 지점과 인접한 지점이 유효 범위 안에 있으면서 1이면, 이전 지점 + 1해주고 해당 지점을 다시 큐에 넣음

public class 게임맵최단거리 {
    public static void main(String[] args) {
        게임맵최단거리 s = new 게임맵최단거리();
        int solution = s.solution(
                new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                }
        );

        System.out.println("solution = " + solution);
    }

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static int[][] table;
    private static int n, m;

    public int solution(int[][] maps) {
        table = maps;
        n = maps.length;
        m = maps[0].length;
        bfs();
        if (table[n - 1][m - 1] > 1) {
            return table[n - 1][m - 1];
        }
        return -1;
    }

    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (table[nx][ny] == 1) {
                        queue.add(new Point(nx, ny));
                        table[nx][ny] = table[p.x][p.y] + 1;
                    }
                }
            }
        }
    }
}
