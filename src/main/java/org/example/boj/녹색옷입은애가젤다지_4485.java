package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 깜빡하고 시간 안잼
 * 중간에 다익스트라 구현을 몰라서 포기
 * -> 배열로 map 받고 0,0 에서 각 지점마다의 최단거리를 찾고 결국 n-1,n-1 까지의 최단거리를 찾아야하는데 각 지점마다 최단거리 찾는거를 몰랐음
 */
public class 녹색옷입은애가젤다지_4485 {
    private static int[][] map, dijk;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            map = new int[n][n];
            dijk = new int[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                st = new StringTokenizer(s);
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dijk[i][j] = Integer.MAX_VALUE;
                }
            }
            int dijkstra = dijkstra();
            System.out.println("Problem " + count + ": " + dijkstra);
            count++;
        }
    }

    private static int dijkstra() {
        dijk[0][0] = map[0][0];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0, dijk[0][0]));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nRow = node.row + dx[i];
                int nCol = node.col + dy[i];
                if (nRow < map.length && nCol < map.length && nRow >= 0 && nCol >= 0) {
                    if (dijk[nRow][nCol] > dijk[node.row][node.col] + map[nRow][nCol]) {
                        dijk[nRow][nCol] = dijk[node.row][node.col] + map[nRow][nCol];
                        pq.offer(new Node(nRow, nCol, dijk[nRow][nCol]));
                    }
                }
            }
        }
        return dijk[map.length-1][map.length-1];
    }
}

class Node implements Comparable<Node> {
    int row;
    int col;
    int cost;

    public Node(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
