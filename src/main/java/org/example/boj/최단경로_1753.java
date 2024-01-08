package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 최단경로_1753 {
    private static int[] distance;
    private static boolean[] visited;
    private static List<List<Node>> list = new ArrayList<>();
    private static int v,e,startEdge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        distance = new int[v+1];
        visited = new boolean[v+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        startEdge = Integer.parseInt(br.readLine());
        distance[startEdge] = 0;
//        visited[startEdge] = true;

        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
        }

        dijkstra();
        for (int i = 1; i < distance.length; i++) {
            int i1 = distance[i];
            if (i1 == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(i1);
            }
        }
    }

    /*
    엣지 선택 -> 갈수있는 엣지 가중치와 현재 해당 엣지의 가중치 비교 후 더 작으면 최단거리 배열 변경
    -> 선택하지 않은 최단거리 배열 중 가장 작은 거 선택해서 갈 수 있는 엣지 가져와서 비교
     */
    private static void dijkstra() {
        for (int i = 0; i < distance.length; i++) {
            int index = selectNext();
            List<Node> nodes = list.get(index);
            for (Node node : nodes) {
                if (distance[node.end] > distance[index] + node.weight) {
                    distance[node.end] = distance[index] + node.weight;
                }
            }
        }

    }

    private static int selectNext() {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < distance.length; i++) {
            int i1 = distance[i];
            if (i1 < min && !visited[i]) {
                min = i1;
                index = i;
            }
        }
        visited[index] = true;
        return index;
    }

    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
