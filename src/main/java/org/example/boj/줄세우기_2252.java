package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기_2252 {
    private static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        // 위상정렬에 사용할 진입차수 저장 배열
        int[] edgeCount = new int[n + 1];

        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            edgeCount[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer no = queue.poll();
            sb.append(no).append(" ");

            List<Integer> integers = list.get(no);
            for (int i = 0; i < integers.size(); i++) {
                Integer i1 = integers.get(i);
                edgeCount[i1]--;
                if (edgeCount[i1] == 0) {
                    queue.add(i1);
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
