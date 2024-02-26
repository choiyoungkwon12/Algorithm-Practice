package org.example.programmers;

import java.io.IOException;
import java.util.Arrays;

public class 최솟값만들기_12941 {
    public static void main(String[] args) throws IOException {
        최솟값만들기_12941 s = new 최솟값만들기_12941();
        System.out.println(s.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(s.solution(new int[]{1, 2}, new int[]{3, 4}));
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int i1 = A[i];
            int i2 = B[B.length - 1 - i];
            sum += (i1 * i2);
        }

        return sum;
    }
}
