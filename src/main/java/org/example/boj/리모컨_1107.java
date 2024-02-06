package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨_1107 {
    public static void main(String[] args) throws IOException {
        int current = 100;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int deleteN = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[] broken = new boolean[10];
        if (deleteN > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < deleteN; i++) {
                int button = Integer.parseInt(st.nextToken());
                broken[button] = true;
            }
        }

        int result = Math.abs(target - current);
        for (int select = 0; select < 1000000; select++) {
            String s = String.valueOf(select);
            int len = s.length();

            boolean check = false;
            // 전체 범위에서 하나씩 순회하면서 해당 숫자가 가능한지 버튼이 고장난게 없는지 확인
            for (int j = 0; j < len; j++) {
                if (broken[s.charAt(j) - '0']) {
                    check = true;
                    break;
                }
            }

            // 고장난 버튼이 없어서 가능하다면 최소인지 확인
            if (!check) {
                int min = Math.abs(target - select) + len;
                result = Math.min(min, result);
            }
        }
        System.out.println(result);

    }
}
