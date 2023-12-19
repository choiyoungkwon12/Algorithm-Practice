package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_1697 {
    private static int n, k;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[1000003];

        if (n == k) {
            System.out.println(0);
            return;
        }
        if (n > k) {
            System.out.println(n - k);
            return;
        }

        bfs();

    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int current = node.current;
            int multi = current * 2;
            int minus = current - 1;
            int plus = current + 1;
            if (multi < (k * 3)) {
                if (test(multi, queue, node)) break;
                if (test(minus, queue, node)) break;
                if (test(plus, queue, node)) break;
            }
        }
    }

    private static boolean test(int next, Queue<Node> queue, Node node) {
        // -1 하다가 0보다 작아질 수 있어서 예외처리 필요
        if (next >= 0 && !visited[next]) {
            visited[next] = true;
            queue.add(new Node(next, node.time + 1));
            if (next == k) {
                System.out.println(node.time + 1);
                return true;
            }
        }
        return false;
    }

    static class Node {
        int current;
        int time;

        public Node(int current, int time) {
            this.current = current;
            this.time = time;
        }
    }
}
