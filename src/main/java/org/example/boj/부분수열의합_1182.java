package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 부분수열의합_1182 {

    private static int count = 0;
    private static int n, s;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }
        dfs(0, 0);

        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }

    public static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        dfs(depth + 1, sum + list.get(depth));
        dfs(depth + 1, sum);
    }
}
