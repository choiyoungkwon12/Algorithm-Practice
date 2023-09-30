package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 지름길_1446 {
    private static List<Node> nodes = new ArrayList<>();
    private static int n, d;
    static int result = Integer.MAX_VALUE;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (s > d || e > d) {
                continue;
            }
            nodes.add(new Node(s, e, v));
        }
        check = new boolean[nodes.size()];
        dfs(0, d, 0);
        System.out.println(result);
    }

    private static void dfs(int now, int end, int distance) {
        if (now > end) {
            return;
        }
        if (now == end) {
            result = Math.min(result, distance);
            return;
        } else {
            result = Math.min(result, distance + (end - now));
        }

        for (int i = 0; i < nodes.size(); i++) {
            if (!check[i]) {
                Node node = nodes.get(i);
                if (node.start == now) {
                    check[i] = true;
                    dfs(node.end, d, distance + node.value);
                    check[i] = false;
                }
            }
        }
        dfs(now + 1, d, distance + 1);
    }

    static class Node {
        int start;
        int end;
        int value;

        public Node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

}