package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 보물_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(Integer.valueOf(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(a);
        b.sort((o1, o2) -> o2 - o1);
        int result = 0;

        for (int i = 0; i < n; i++) {
            Integer i1 = a.get(i);
            Integer i2 = b.get(i);
            result += i1 * i2;
        }
        System.out.println(result);
    }
}
