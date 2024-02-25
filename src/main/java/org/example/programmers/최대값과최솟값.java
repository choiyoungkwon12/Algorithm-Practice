package org.example.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */
public class 최대값과최솟값 {
    public static void main(String[] args) {
        최대값과최솟값 s = new 최대값과최솟값();
        System.out.println(s.solution("1 2 3 4"));
    }

    public String solution(String s) {
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            list.add(Integer.valueOf(st.nextToken()));
        }
        list.sort(Comparator.comparingInt(o -> o));
        return list.get(0) + " " + list.get(list.size() - 1);
    }
}
