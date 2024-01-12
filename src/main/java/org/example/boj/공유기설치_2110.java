package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 공유기설치_2110 {
    private static List<Integer> list = new ArrayList<>();
    private static int n, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[] diff = new int[n - 1];
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(br.readLine()));
        }
        list.sort(Comparator.comparingInt(o -> o));
        for (int i = 1; i < n; i++) {
            diff[i - 1] = list.get(i) - list.get(i - 1);
        }
        process();
    }

    private static void process() {
        int max = list.get(list.size() - 1) - list.get(0);
        int min = 1;
        int answer = 0;

        while (min <= max) {
            int current = (max + min) / 2;
            List<Integer> index = new ArrayList<>();
            index.add(0);
            int afterStartIndex = list.get(0);

            for (int i = 1; i < n; i++) {
                int distance = list.get(i) - afterStartIndex;
                if (distance >= current) {
                    index.add(i);
                    afterStartIndex = list.get(i);
                }
            }

            if (c <= index.size()) {
                min = current + 1;
                answer = current;
            } else {
                max = current - 1;
            }
        }

        System.out.println(answer);

    }
}
