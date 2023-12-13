package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 점화식?

        // 최소를 선택하면 그 다음것도 최소가 된다는 보장이 어딨지?
        // 1로 묶어 그러면
        // 2>1> 3, 2>1> 2, 2>3> 1
        // 3>1> 3  3>1> 2  1>3> 1
        // 1>2> 3, 1>3> 2, 1>2> 1
        // 3>2> 3, 2>3> 2, 3>2> 1
        /*
26 40 83 1 2 1 2, 1,2,1,3 1,2,3,1 1,2,3,2 1,3,2,3 1,3,2,1 1,3,1,2 1,3,1,3
49 60 57
13 89 99
11 22 33
         */
        long result = 0;
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < 3; i++) {
            int i1 = map[0][i];
            if (min > i1) {
                index = i;
                min = i1;
            }
        }

        result += min;

        for (int i = 1; i < map.length; i++) {
            min = Integer.MAX_VALUE;
            int temp = -1;
            for (int j = 0; j < 3; j++) {
                int i1 = map[i][j];
                if (min > i1 && index != j) {
                    System.out.println("min : " + min );
                    temp = j;
                    min = i1;
                    System.out.println("i1 : " + i1);
                }
            }
            index = temp;
            result+=min;
            System.out.println();
        }
        System.out.println(result);
    }
}
