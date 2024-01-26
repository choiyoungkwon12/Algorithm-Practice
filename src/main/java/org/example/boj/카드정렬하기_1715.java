package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 카드정렬하기_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(br.readLine());
            queue.add(j);
        }

        int result = 0;
        while (!queue.isEmpty() && queue.size() >= 2){
            Integer integer1 = queue.poll();
            Integer integer2 = queue.poll();
            int sum = integer1 + integer2;
            result += sum;
            queue.add(sum);
        }
        System.out.println(result);
    }
}
