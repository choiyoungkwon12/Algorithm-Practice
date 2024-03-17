package org.example.programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class 야근지수 {
    public static void main(String[] args) {
        야근지수 s = new 야근지수();
        System.out.println(s.solution(4, new int[]{4, 3, 3}));

    }

    public long solution(int n, int[] works) {
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.work - o1.work);
        for (int work : works) {
            queue.add(new Node(work));
        }

        while (n > 0 && !queue.isEmpty()) {
            Node node = queue.poll();
            node.work = node.work - 1;
            if (node.work != 0) {
                queue.add(node);
            }
            n -= 1;
        }
        System.out.println(queue);
        long answer = queue.stream().mapToLong(value -> (long) Math.pow(value.work, 2)).sum();
        return answer;
    }

    private static class Node {
        int work;

        public Node(int work) {
            this.work = work;
        }
    }

}
