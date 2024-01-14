package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 두용액_2470 {
    private static List<Integer> list = new ArrayList<>();
    private static int rIndex, lIndex, answer, answerL, answerR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(list);
        lIndex = 0;
        rIndex = list.size() - 1;
        answer = Integer.MAX_VALUE;
        answerL = lIndex;
        answerR = rIndex;
        search();
        Integer l = list.get(answerL);
        Integer r = list.get(answerR);
        System.out.println(l + " " + r);
    }

    private static void search() {
        // -99 -98 -98 0 98 9천만 1억
        // + 인경우 -> 오른쪽 인덱스에서 범위 좁힘
        // - 인 경우 -> 왼쪽 인덱스에서 범위
        // 같으면 안됨
        while (rIndex > lIndex) {
            Integer right = list.get(rIndex);
            Integer left = list.get(lIndex);
            int sum = right + left;
            if (sum == 0) {
                answerL = lIndex;
                answerR = rIndex;
                break;
            }

            if (Math.abs(sum) < answer) {
                answer = Math.abs(sum);
                answerL = lIndex;
                answerR = rIndex;
            }

            if (sum > 0) {
                rIndex--;
            } else {
                lIndex++;
            }

        }

    }
}
