package org.example.programmers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/138476
 */
public class 귤고르기_138476 {
    public static void main(String[] args) throws IOException {
        귤고르기_138476 s = new 귤고르기_138476();
        System.out.println(s.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(s.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(s.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i1 : tangerine) {
            map.put(i1, map.getOrDefault(i1, 0) + 1);
        }

        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            queue.add(new Node(key, value));
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            k-=node.value;
            answer++;
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }

    private static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
