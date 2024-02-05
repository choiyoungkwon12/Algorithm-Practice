package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 연속합_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[list.size()];
        dp[0] = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (dp[i - 1] + list.get(i) < list.get(i)) {
                dp[i] = list.get(i);
            } else {
                dp[i] = dp[i - 1] + list.get(i);
            }
        }

        int result = Arrays.stream(dp).max().getAsInt();
        System.out.println(result);
    }
}
