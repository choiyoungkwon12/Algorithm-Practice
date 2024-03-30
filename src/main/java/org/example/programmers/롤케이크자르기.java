package org.example.programmers;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크자르기 {
    public static void main(String[] args) {
        롤케이크자르기 s = new 롤케이크자르기();
        System.out.println(s.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    }

    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i1 : topping) {
            map1.put(i1, map1.getOrDefault(i1, 0) + 1);
        }

        for (int i1 : topping) {
            map2.put(i1, map2.getOrDefault(i1, 0) + 1);
            map1.put(i1, map1.getOrDefault(i1, 1) - 1);
            Integer keyCount = map1.get(i1);
            if (keyCount.equals(0)) {
                map1.remove(i1);
            }
            if (map1.keySet().size() == map2.keySet().size()) {
                answer++;
            }
        }

        return answer;
    }
}
