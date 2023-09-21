package org.example.boj;

import java.io.*;
import java.util.PriorityQueue;

// 8분 문제 해결
// 우선순위 큐 정렬 기준(comparator) 정의하는 부분만 하면 사실 크게 어렵지 않은거 같고, 아무것도 없을때를 조심해야함.
public class 절대값힙_11286 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> (Math.abs(i1) - Math.abs(i2)) == 0 ? i1 - i2 : Math.abs(i1) - Math.abs(i2));

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                queue.add(num);
            } else {
                Integer integer = queue.poll();
                System.out.println(integer == null ? 0 : integer);
            }
        }
    }
}
