package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 도키도키_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            queue.add(a);
        }

        int count = 1;
        while (!queue.isEmpty()) {
            Integer integer = queue.peek();

            if (count == integer) {
                queue.poll();
                count++;
            } else if (!stack.isEmpty() && stack.peek() == count) {
                stack.pop();
                count++;
            } else {
                stack.add(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop != count) {
                System.out.println("Sad");
                return;
            }
            count++;
        }
        System.out.println("Nice");
    }
}
