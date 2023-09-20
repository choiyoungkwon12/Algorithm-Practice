package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 동전_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.valueOf(br.readLine()));
        }
        coins.sort((o1, o2) -> o2 - o1);
        long answer = 0;
        for (Integer i1 : coins) {
            while (k / i1 > 0) {
                answer = answer + (k / i1);
                k = k % i1;
                if (k == 0) {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
