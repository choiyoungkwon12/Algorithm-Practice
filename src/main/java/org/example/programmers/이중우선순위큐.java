package org.example.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        이중우선순위큐 s = new 이중우선순위큐();
        String[] strings = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] string2 = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(s.solution(strings)));
        System.out.println(Arrays.toString(s.solution(string2)));
    }

    public int[] solution(String[] operations) {
        // 오름차순
        Queue<Integer> queue1 = new PriorityQueue<>((o1, o2) -> o1 - o2);

        // 내림차순
        Queue<Integer> queue2 = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            String[] strings = operation.split(" ");
            String string1 = strings[0];
            String string2 = strings[1];
            if (string1.equals("I")) {
                Integer e = Integer.valueOf(string2);
                queue1.add(e);
                queue2.add(e);
            }

            if (string1.equals("D")) {
                int i1 = Integer.parseInt(string2);
                if (!queue2.isEmpty()) {
                    if (i1 == 1) {
                        Integer remove = queue2.poll();
                        queue1.remove(remove);
                    } else {
                        Integer remove = queue1.poll();
                        queue2.remove(remove);
                    }
                }
            }
        }
        int[] answer = new int[]{0,0};
        if (!queue2.isEmpty()) {
            answer[0] = queue2.poll();
            answer[1] = queue1.poll();
        }

        return answer;
    }
}
