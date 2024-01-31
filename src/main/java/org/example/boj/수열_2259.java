package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수열_2259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        int a = Integer.parseInt(st.nextToken());

        list.add(a);

        for (int i = 1; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            list.add(list.get(i - 1) + number);
        }

        int max = list.get(k - 1);
        for (int i = 1; i <= list.size() - k; i++) {
            int sum = list.get(i + k - 1) - list.get(i - 1);
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
