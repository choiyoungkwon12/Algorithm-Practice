package org.example.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public static void main(String[] args) {
        네트워크 s = new 네트워크();
        int solution = s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(solution);
    }

    private static boolean[] visited;
    private static int[][] maps;
    private static int count = 0;


    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        maps = computers;

        for (int i = 0; i < n; i++) {
            // 방문하지 않은 노드만 bfs 실행
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }
        return count;
    }

    // 0~ n까지 순회
    // 네트워크로 연결된 컴퓨터를 bfs로 찾는다 -> 모두 bfs가 끝나면 count ++
    // 방문하지 않은 노드 모두 방문처리 될때 까지(n까지) 끝나면 count 리턴

    private void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            Integer value = queue.poll();

            for (int j = 0; j < maps.length; j++) {
                if (!visited[j] && maps[value][j] == 1) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}
