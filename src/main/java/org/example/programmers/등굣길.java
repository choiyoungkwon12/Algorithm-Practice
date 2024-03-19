package org.example.programmers;

import java.util.Arrays;

public class 등굣길 {
    public static void main(String[] args) {
        등굣길 s = new 등굣길();
        System.out.println(s.solution(4, 3, new int[][]{{2, 2}}));
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        for (int i = 0; i < puddles.length; i++) {
            int[] puddle = puddles[i];
            int c = puddle[0] - 1;
            int r = puddle[1] - 1;
            map[r][c] = -1;
        }

        int fill = 1;
        for (int i = 0; i < n; i++) {
            if (map[i][0] != -1) {
                map[i][0] = fill;
            }
            if (map[i][0] == -1) {
                fill = 0;
            }
        }
        fill = 1;
        for (int i = 0; i < m; i++) {
            if (map[0][i] != -1) {
                map[0][i] = fill;
            }
            if (map[0][i] == -1) {
                fill = 0;
            }
        }

        for (int i = 1; i < map.length; i++) {
            int[] ints = map[i];
            for (int j = 1; j < ints.length; j++) {
                int preRow = i - 1;
                int preCol = j - 1;
                if (map[i][j] == -1) {
                    continue;
                }
                if (map[i][preCol] > 0) {
                    map[i][j] += map[i][preCol] % 1000000007;
                }
                if (map[preRow][j] > 0) {
                    map[i][j] += map[preRow][j] % 1000000007;
                }
            }
        }
        return map[n - 1][m - 1] % 1000000007;
    }
}
