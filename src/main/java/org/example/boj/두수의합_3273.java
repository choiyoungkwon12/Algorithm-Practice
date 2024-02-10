package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 두수의합_3273 {
    private static int count = 0;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }
        list.sort(Comparator.comparingInt(o -> o));
        int target = Integer.parseInt(br.readLine());

        counting(target);

        System.out.println(count);
    }
    /*
    7
    1 3 6 8 10 15 16
    15
     */

    private static void counting(int target) {
        int leftIndex = 0;
        int rightIndex = list.size() - 1;


        while (leftIndex < rightIndex) {
            Integer i1 = list.get(leftIndex);
            Integer i2 = list.get(rightIndex);

            int sum = i1 + i2;
            if (sum == target) {
                count++;
                leftIndex++;
                rightIndex--;
            }

            if (sum < target) {
                leftIndex++;
            }

            if (sum > target) {
                rightIndex--;
            }
        }
    }
}
