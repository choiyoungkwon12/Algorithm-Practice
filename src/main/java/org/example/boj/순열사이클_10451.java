package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열사이클_10451 {
    private static int[] map;
    private static int count;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            map = new int[size + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            count = 0;
            for (int j = 1; j <= size; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[j] = num;
            }
            check = new boolean[size + 1];
            for (int j = 1; j <= size; j++) {
                if (!check[j]) {
                    dfs(j);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int i) {
        check[i] = true;
        int next = map[i];
        if (!check[next]) {
            dfs(map[i]);
        }
    }
}
