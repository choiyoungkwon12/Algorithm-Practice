package org.example.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망둘로나누기 {
    public static void main(String[] args) {
        전력망둘로나누기 s = new 전력망둘로나누기();
        int solution = s.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
        System.out.println(solution);
    }

    static int[][] graph;

    public int solution(int n, int[][] wires) {
        // n 개 들어오고 n-1 개의 전선이 들어옴
        // 트리 정보 저장
        // 하나씩 제거
        // 2개로 나누어지는데 송전탑의 갯수 차이를 계속 갱신
        int answer = n;
        graph = new int[n + 1][n + 1];

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        for (int[] wire : wires) {
            int wire1 = wire[0];
            int wire2 = wire[1];

            graph[wire1][wire2] = 0;
            graph[wire2][wire1] = 0;

            answer = Math.min(answer, bfs(n, wire1));

            graph[wire1][wire2] = 1;
            graph[wire2][wire1] = 1;
        }


        return answer;
    }

    private int bfs(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int point = queue.poll();
            visited[point] = true;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }
                if (graph[point][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        // 한쪽만 갯수를 구하면 나머지 그룹의 갯수는 자동으로 계산 가능
        return Math.abs(cnt - (n - cnt));
    }
}
