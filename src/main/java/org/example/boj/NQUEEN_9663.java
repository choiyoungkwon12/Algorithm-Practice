package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQUEEN_9663 {
    private static int[] map;
    private static int n;
    private static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n];
        nQueen(0);
        System.out.println(count);
    }


    public static void nQueen(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        // 인덱스 = 열, 값 = 행의 위치
        for (int i = 0; i < n; i++) {
            map[depth] = i;
            if (possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
             if (map[col] == map[i]){
                 return false;
             }

             if (Math.abs(col - i) == Math.abs(map[col] - map[i])) {
                 return false;
             }
        }
        return true;
    }
}
