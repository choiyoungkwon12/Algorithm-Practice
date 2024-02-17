package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 좋다_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

//        3
//        0 0 1

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            list.add(number);
        }
        list.sort(Comparator.comparingInt(o -> o));

        // 정렬
        // 투포인터

        int result = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                if (i == left || i == right) {
                    if (i == left) {
                        left++;
                    } else {
                        right--;
                    }
                } else {
                    int now = list.get(left) + list.get(right);
                    if (now == list.get(i)) {
                        result++;
                        break;
                    } else if (now > list.get(i)) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
