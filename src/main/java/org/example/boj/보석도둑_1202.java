package org.example.boj;

import java.io.*;
import java.util.*;

public class 보석도둑_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Node> jewelry = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelry.add(new Node(m, v));
        }

        // 보석을 무게 기준으로 오름차순 정렬
        jewelry.sort(Comparator.comparingInt(o -> o.m));

        List<Integer> bag = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            bag.add(Integer.valueOf(br.readLine()));
        }

        // 가방을 무게 제한에 따라 오름차순 정렬
        Collections.sort(bag);

        long result = 0;
        int j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            while (j < n && jewelry.get(j).m <= bag.get(i)) {
                pq.add(jewelry.get(j).v);
                j++;
            }
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }

    static class Node {
        int m;
        int v;

        public Node(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
