package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }

        list.sort((n1, n2) -> n1.end != n2.end ? n1.end - n2.end : n1.start - n2.start);
        int result = 1;
        Node pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Node next = list.get(i);
            if (pre.end <= next.start) {
                pre = next;
                result++;
            }
        }
        System.out.println(result);
    }

    static class Node{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
