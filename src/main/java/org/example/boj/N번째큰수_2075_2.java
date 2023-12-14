

package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N번째큰수_2075_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // integer라 기본적으로 오름차순정렬
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                Integer num = Integer.valueOf(st.nextToken());

                // 큐 사이즈를 최대 n으로 유지하면서 만약 새로운 수가 큐의 가장 작은 수보다 크다면 교체
                if (queue.size() == n) {
                    if (queue.peek() < num) {
                        queue.poll();
                        queue.add(num);
                    }
                } else {
                    queue.add(num);
                }
            }
        }
        // 가장 큰 n개의 수만 들어있기 때문에 그 중 가장 작은 수를 뽑으면 n번째 큰수가됨
        System.out.println(queue.poll());
    }
}
