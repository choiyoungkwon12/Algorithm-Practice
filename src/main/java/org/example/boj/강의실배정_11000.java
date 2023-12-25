package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 시작 시간으로 오름차순 정렬, 같으면 종료시간 기준 오름차순
// 우선순위큐에 종료시간 넣고
public class 강의실배정_11000 {
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

        list.sort((n1, n2) -> n1.start != n2.start ? n1.start - n2.start : n1.end - n2.end);
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(list.get(0).end);
        for (int i = 1; i < list.size(); i++) {
            Node next = list.get(i);
            if (queue.peek() <= next.start) {
                queue.poll();
            }
            queue.add(next.end);
        }
        System.out.println(queue.size());

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
