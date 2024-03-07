package org.example.programmers;

import java.util.Arrays;

public class n개의최소공배수 {
    public static void main(String[] args) {
        n개의최소공배수 s = new n개의최소공배수();
        System.out.println(s.solution(new int[]{2, 6, 8, 14}));
        System.out.println(s.solution(new int[]{1,2,3}));
    }

    public int solution(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        while (true) {
            boolean check = true;
            for (int i1 : arr) {
                int i2 = max % i1;
                if (i2 != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                break;
            }
            max++;
        }
        return max;
    }
}
