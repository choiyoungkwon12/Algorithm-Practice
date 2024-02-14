package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 거짓말_1043 {
    private static int people, party;
    private static List<List<Integer>> map = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        people = Integer.parseInt(st.nextToken());
        party = Integer.parseInt(st.nextToken());
        visited = new boolean[party];

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < t; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }
        if (t == 0) {
            System.out.println(party);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        // 파티에 오는 사람 저장
        for (int i = 0; i < party; i++) {
            map.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                Integer number = Integer.valueOf(st.nextToken());
                if (set.contains(number)) {
                    queue.add(number);
                }
                map.get(i).add(number);
            }
        }

        int count = party;
        while (!queue.isEmpty()) {
            Integer truePeople = queue.poll();
            for (int i = 0; i < map.size(); i++) {
                List<Integer> parties = map.get(i);
                if (parties.contains(truePeople) && !visited[i]) {
                    count--;
                    visited[i] = true;
                    queue.addAll(map.get(i));
                }
            }
        }

        System.out.println(count);
    }
}
