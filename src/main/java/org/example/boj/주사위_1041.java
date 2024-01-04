package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class 주사위_1041 {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        if (n == 1) {
            list.sort(Comparator.comparingInt(o -> o));
            int sum = list.stream().mapToInt(value -> value).sum();
            int maxValue = list.stream()
                    .mapToInt(x -> x)
                    .max()
                    .orElseThrow(NoSuchElementException::new);
            System.out.println(sum - maxValue);
            return;
        }

        long oneSquare = (4L * ((long) (n - 2) * (n - 1))) + ((n - 2L) * (n - 2L));
        long one = oneSquare * getOneValue();
//        System.out.println("oneSquare = " + oneSquare + " , value = " + getOneValue());

        long twoSquare = 8L * n - 12;
        long two = twoSquare * (long) getTwoValue();
//        System.out.println("twosquare = " + twoSquare + " , value = " + getTwoValue());

        long three = 4 * (long) getThreeValue();
//        System.out.println("twosquare = " + twoSquare + " , threevalue = " + getThreeValue());
        System.out.println(one + two + three);

    }

    private static int getOneValue() {
        return list.stream()
                .mapToInt(x -> x)
                .min()
                .orElseThrow(NoSuchElementException::new);
    }

    private static int getTwoValue() {
        /*
        a - 0
        b - 1
        c - 2
        d - 3
        e - 4
        f - 5
         */
        // 0,4 0,1 1,5 4,5
        // 3,4 3,0 3,1 3,5
        // 2,4 2,0 2,1 2,5
        List<int[]> twoList = new ArrayList<>();
        twoList.add(new int[]{0, 4});
        twoList.add(new int[]{0, 1});
        twoList.add(new int[]{1, 5});
        twoList.add(new int[]{4, 5});
        twoList.add(new int[]{3, 4});
        twoList.add(new int[]{3, 0});
        twoList.add(new int[]{3, 1});
        twoList.add(new int[]{3, 5});
        twoList.add(new int[]{2, 4});
        twoList.add(new int[]{2, 0});
        twoList.add(new int[]{2, 1});
        twoList.add(new int[]{2, 5});

        int min = Integer.MAX_VALUE;
        for (int[] ints : twoList) {
            int i1 = list.get(ints[0]);
            int i2 = list.get(ints[1]);
            min = Math.min(min, (i1 + i2));
        }
        return min;
    }

    /*
        a - 0
        b - 1
        c - 2
        d - 3
        e - 4
        f - 5
         */
    private static int getThreeValue() {
        List<int[]> threeList = new ArrayList<>();
        /*
        EAC
        EAD
        DAB
        CAB

        ECF
        EDF
        BFC
        BFD
         */
        threeList.add(new int[]{4, 0, 2});
        threeList.add(new int[]{4, 0, 3});
        threeList.add(new int[]{3, 0, 1});
        threeList.add(new int[]{2, 0, 1});
        threeList.add(new int[]{4, 2, 5});
        threeList.add(new int[]{4, 3, 5});
        threeList.add(new int[]{1, 5, 2});
        threeList.add(new int[]{1, 5, 3});

        int min = Integer.MAX_VALUE;
        for (int[] ints : threeList) {
            int i1 = list.get(ints[0]);
            int i2 = list.get(ints[1]);
            int i3 = list.get(ints[2]);
            min = Math.min(min, (i1 + i2 + i3));
        }
        return min;
    }
}
