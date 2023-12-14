package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N번째큰수_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st  = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list.add(Integer.valueOf(st.nextToken()));
            }
        }
        list.sort((o1, o2) -> o2 - o1);
        Integer result = list.get(n-1);
        System.out.println(result);
    }
}
