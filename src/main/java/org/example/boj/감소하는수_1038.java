package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는수_1038 {
    private static final List<Long> list = new ArrayList<>();
    private static final long max = 9876543210L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 10) {
            System.out.println(n);
        } else {
            for (long i = 0; i < 10; i++) {
                calculate(i);
            }

            Collections.sort(list);

            if (list.size() <= n) {
                System.out.println(-1);
            } else {
                System.out.println(list.get(n));
            }
        }


    }

    private static void calculate(long num) {

        if (num > max) {
            return;
        }

        list.add(num);

        // 재귀를 이용해서 감소하는 숫자를 만든다.
        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) {
                calculate((num * 10) + (long) i);
            }
        }
    }
}
