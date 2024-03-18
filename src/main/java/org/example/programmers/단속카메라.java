package org.example.programmers;

import java.util.Arrays;

public class 단속카메라 {
    public static void main(String[] args) {
        단속카메라 s = new 단속카메라();
        System.out.println(s.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
        System.out.println(s.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}, {-6, -3}}));
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        System.out.println(Arrays.deepToString(routes));
        int answer = 1;
        int[] first = routes[0];
        int lastCamIndex = first[1];
        for (int i = 1; i < routes.length; i++) {
            int[] route = routes[i];
            if (route[0] > lastCamIndex) {
                answer++;
                lastCamIndex = route[1];
            }
        }

        return answer;
    }
}
