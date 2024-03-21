package org.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 튜플 {
    public static void main(String[] args) {
        튜플 s = new 튜플();
        System.out.println(Arrays.toString(s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    }

    public int[] solution(String s) {
        String[] strings = s.split("},");
        List<List<Integer>> collect = Arrays.stream(strings)
                .map(s1 -> s1.replace("{", ""))
                .map(s1 -> s1.replace("}", ""))
                .map(s1 -> s1.split(","))
                .map(s1 -> Arrays.stream(s1).map(Integer::parseInt).collect(Collectors.toList()))
                .collect(Collectors.toList());

        collect.sort((o1, o2) -> o1.size() - o2.size());

        Set<Integer> set = new HashSet<>();

        List<Integer> list = new ArrayList<>();
        for (List<Integer> integers : collect) {
            for (Integer i1 : integers) {
                if (!set.contains(i1)) {
                    set.add(i1);
                    list.add(i1);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
