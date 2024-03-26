package org.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 줄서는방법 {
    public static void main(String[] args) {
        줄서는방법 s = new 줄서는방법();
        System.out.println(Arrays.toString(s.solution(3, 5)));
    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        long f = 1;
        for(int i=1; i<=n; i++) {
            list.add(i);
            f *= i;
        }

        k--;
        int idx = 0;
        while(idx < n) {
            f /= n - idx;
            answer[idx++] = list.remove((int) (k / f));
            k %= f;
        }

        return answer;
    }
}
