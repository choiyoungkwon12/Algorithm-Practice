package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물통_2251 {
    private static List<Integer[]> list, history;
    private static final List<Node> bottles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();
        history = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            bottles.add(new Node(num));
        }

        bfs();

        list.sort((o1, o2) -> o1[2] - o2[2]); // c 기준 오름차순 정렬
        StringBuilder sb = new StringBuilder();
        for (Integer[] integers : list) {
            sb.append(integers[2]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] start = {0, 0, bottles.get(2).limit};
        queue.add(start);
        history.add(start);

        while (!queue.isEmpty()) {
            Integer[] node = queue.poll();// 현재 들어있는 물
            if (node[0] == 0) { // a 가 0인 경우
                list.add(node);
            }

            for (int i = 0; i < 3; i++) { // 뺄거
                for (int j = 0; j < 3; j++) { // 넣을거
                    if (i == j) continue;
                    if (node[i] > 0 && node[j] < bottles.get(j).limit) {
                        int diff = node[i] - (bottles.get(j).limit - node[j]); // 뺄 보틀의 물의양 - (넣을 보틀의 물의 최대치 - 넣을 보틀의 현재 있는 물의 양)
                        int ns;
                        int n1;
                        if (diff > 0) { // 넣을 물병에 넣을 수 있는 최대 양이 밸 수 있는 물의 양 보다 적을 경우
                            int move = node[i] - diff; // 차이를 뺸 나머지를 옮기고
                            ns = node[i] - move;
                            n1 = node[j] + move;
                        } else { // 넣을거에 넣을 수 있는 최대 양이 뺄 수 있는 물보다 큰 경우 (물 전체를 옮기는 경우)
                            ns = 0;
                            n1 = node[j] + node[i];
                        }

                        Integer[] next = new Integer[3];
                        next[i] = ns;
                        next[j] = n1;
                        int another = 3 - j - i;
                        int n3 = node[another];
                        next[another] = n3;
                        if (notContainsHistory(next)) {
                            history.add(next); // 방문 여부 체크
                            queue.add(next);
                        }
                    }
                }
            }
        }
    }

    private static boolean notContainsHistory(Integer[] integers) {
        boolean check = true;
        for (Integer[] integers1 : history) {
            Integer i1 = integers1[0];
            Integer i2 = integers1[1];
            Integer i3 = integers1[2];

            Integer integer1 = integers[0];
            Integer integer2 = integers[1];
            Integer integer3 = integers[2];
            if (Objects.equals(i1, integer1) && Objects.equals(integer2, i2) && Objects.equals(integer3, i3)) {
                check = false;
            }
        }
        return check;
    }

    static class Node {
        int limit;

        public Node(int limit) {
            this.limit = limit;
        }
    }
}
