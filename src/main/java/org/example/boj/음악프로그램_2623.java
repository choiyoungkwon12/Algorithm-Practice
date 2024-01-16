package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램_2623 {
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] edgeCount = new int[n + 1];
        visited = new boolean[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            String[] strings = s.split(" ");
            for (int j = 2; j < strings.length; j++) {
                int number = Integer.parseInt(strings[j]);
                list.get(Integer.parseInt(strings[j - 1])).add(Integer.valueOf(strings[j]));
                edgeCount[number]++;
            }
        }

        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        findDegreeZero(edgeCount, queue);

        while (!queue.isEmpty()) {
            Integer integer = queue.poll();
            answer.add(integer);
            List<Integer> integers = list.get(integer);
            for (Integer value : integers) {
                edgeCount[value]--;
            }
            findDegreeZero(edgeCount, queue);
        }
        if (answer.size() == n) {
            answer.forEach(System.out::println);
        } else {
            System.out.println(0);
        }
    }

    private static void findDegreeZero(int[] edgeCount, Queue<Integer> queue) {
        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0 && !visited[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }
    }
}
