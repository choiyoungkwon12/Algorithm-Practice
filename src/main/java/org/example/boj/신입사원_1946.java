package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 신입사원_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Node> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int test = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                Node node = new Node(test, interview, true);
                list.add(node);
            }

            list.sort(Comparator.comparingInt(o -> o.paper));
            int count = 1;
            int base = list.get(0).interview;
            for (int j = 1; j < list.size(); j++) {
                Node node = list.get(j);
                if (node.interview < base) {
                    count++;
                    base = node.interview;
                }
            }

            System.out.println(count);
        }


    }

    private static class Node {
        int paper;
        int interview;
        boolean check;

        public Node(int paper, int interview, boolean check) {
            this.paper = paper;
            this.interview = interview;
            this.check = check;
        }

    }
}
