package org.example.programmers;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        입국심사 s = new 입국심사();
        System.out.println(s.solution(6, new int[]{7, 10}));
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = times[times.length-1] * (long)n;
        long answer = 0;
        while (left <= right) {
            long sum = 0;
            long mid = (left + right)/2;
            for (int time : times) {
                sum += (mid / time);
            }
            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
