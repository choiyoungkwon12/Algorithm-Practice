package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 로또_6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean check = false;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            if (tc == 0) {
                break;
            }
            if (!check) {
                check = true;
            } else {
                System.out.println();
            }

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < tc; i++) {
                list.add(Integer.valueOf(st.nextToken()));
            }
            combination(0, tc, list, new ArrayList<>());

        }
    }

    private static void combination(int start, int n, List<Integer> list, List<Integer> result) {
        if (result.size() == 6) {
            print(result);
        }
        for (int i = start; i < n; i++) {
            result.add(list.get(i));
            combination(i + 1, n, list, result);
            result.remove(result.size() - 1);
        }
    }

    private static void print(List<Integer> result) {
        result.forEach(i -> System.out.printf("%d ", i));
        System.out.println();
    }
}
