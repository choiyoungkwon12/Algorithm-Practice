package org.example.programmers;

import java.util.ArrayList;
import java.util.List;

public class 뉴스클러스터링 {
    public static void main(String[] args) {
        뉴스클러스터링 s = new 뉴스클러스터링();
        System.out.println(s.solution("FRANCE", "french"));
        System.out.println(s.solution("a+b", "french"));
    }

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        List<String> list1 = getList(str1);
        str2 = str2.toLowerCase();
        List<String> list2 = getList(str2);
        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }
        List<String> list3 = new ArrayList<>(list1);
        List<String> list4 = new ArrayList<>(list2);

        // 교집합
        List<String> intersection = new ArrayList<>();
        for (String s : list3) {
            if (list4.contains(s)) {
                list4.remove(s);
                intersection.add(s);
            }
        }

        // 합집합
        list4 = new ArrayList<>(list2);
        List<String> union = new ArrayList<>();
        for (String s : list3) {
            list4.remove(s);
            union.add(s);
        }
        if (!list4.isEmpty()) {
            union.addAll(list4);
        }

        // 자카드 유사도 계산
        double divide = (double) intersection.size() / union.size();
        divide = divide * 65536;
        return (int) divide;
    }

    private static List<String> getList(String str1) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            char c = str1.charAt(i);
            char c1 = str1.charAt(i + 1);
            if (Character.isAlphabetic(c) && Character.isAlphabetic(c1)) {
                String s = c + "" + c1;
                list.add(s);
            }
        }
        return list;
    }
}
