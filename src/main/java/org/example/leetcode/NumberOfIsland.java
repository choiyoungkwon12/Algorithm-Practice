package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    private static boolean[][] visited;
    private static char[][] map;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    public int numIslands(char[][] grid) {
        int result = 0;
        visited = new boolean[grid.length][grid[0].length];
        map = grid;

        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length ; j++) {
                if(grid[i][j] == '1' && !visited[i][j])  {
                    result++;
                    visited[i][j] = true;
                    bfs(new Node(i,j));
                }
            }
        }

        return result;
    }

    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node island = queue.poll();
            for(int i = 0; i<4 ;i++) {
                int nx = island.x + dx[i];
                int ny = island.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < visited.length && ny < visited[0].length) {
                    if(!visited[nx][ny] && map[nx][ny] == '1') {
                        visited[nx][ny] = true;
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
