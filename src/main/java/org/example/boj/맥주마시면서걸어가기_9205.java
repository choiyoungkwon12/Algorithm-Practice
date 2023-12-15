package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기_9205 {
    private static Node end;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n];
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            Node start = new Node(startX, startY);
            List<Node> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Node node = new Node(x, y);
                list.add(node);
            }

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            end = new Node(endX, endY);
            if (bfs(start, list)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }
    }

    private static boolean bfs(Node start, List<Node> list) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        boolean result = false;

        // 굳이 편의점을 거치지 않더라도 바로 도착지에 도착할 수 있는지
        if (Math.abs(end.x - start.x) + Math.abs(end.y - start.y) <= 1000) {
            return true;
        }


        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int i = 0; i < list.size(); i++) {
                Node nextNode = list.get(i);

                if (Math.abs(current.x - nextNode.x) + Math.abs(current.y - nextNode.y) <= 1000 && !visited[i]) {
                    queue.add(nextNode);
                    visited[i] = true;
                    if(Math.abs(end.x - nextNode.x) + Math.abs(end.y - nextNode.y) <= 1000) {
                        result = true;
                    }
                }
            }
        }
        return result;
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
