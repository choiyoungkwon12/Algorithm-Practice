package org.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 다익스트라인걸 알고 시작했는데도 불구하고 구현을 못함.. -> 5분만에 포기
// 합승, 따로가는것중 뭐가 더 최단거리인지를 어떻게 구현하는지 모르겠음
public class 합승택시요금 {
    private static List<List<Edge>> graph;
    static final int MAX = 20000001; // 200 * 100000

    public static void main(String[] args) {
        합승택시요금 s = new 합승택시요금();
        int solution = s.solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
        System.out.println(solution);
    }


    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Edge(fare[1], fare[2]));
            graph.get(fare[1]).add(new Edge(fare[0], fare[2]));
        }
        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        int[] start = new int[n + 1];
        Arrays.fill(startA, MAX);
        Arrays.fill(startB, MAX);
        Arrays.fill(start, MAX);
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        }

        return answer;
    }

    private int[] dijkstra(int start, int[] costs) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        costs[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int nIndex = now.index;
            int nCost = now.cost;

            if (nCost > costs[nIndex]) {
                continue;
            }

            List<Edge> edges = graph.get(nIndex);
            for (Edge edge : edges) {
                int cost = costs[nIndex] + edge.cost;
                if (cost < costs[edge.index]) {
                    costs[edge.index] = cost;
                    pq.offer(new Edge(edge.index, cost));
                }
            }
        }
        return costs;
    }
}

class Edge implements Comparable<Edge> {
    int index;
    int cost;

    public Edge(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}
