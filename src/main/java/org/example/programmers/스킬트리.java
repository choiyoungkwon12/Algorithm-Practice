package org.example.programmers;

import java.util.ArrayList;
import java.util.List;

public class 스킬트리 {

    public static void main(String[] args) {
        스킬트리 s = new 스킬트리();
        int solution = s.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println(solution);
    }

    public int solution(String skill, String[] skill_trees) {
        List<Character> skillOrders = new ArrayList<>();
        for (int i = 0; i < skill.length(); i++) {
            skillOrders.add(skill.charAt(i));
        }

        int result = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            String skillTree = skill_trees[i];
            int index = 0;
            boolean resultPlus = true;
            for (int j = 0; j < skillTree.length(); j++) {
                Character c = skillOrders.get(index);
                char tree = skillTree.charAt(j);

                if (c != tree) {
                    if (skillOrders.contains(tree)) {
                        int i1 = skillOrders.indexOf(tree);
                        if (index < i1) {
                            resultPlus = false;
                            break;
                        }
                    }
                }

                if (c == tree) {
                    index++;
                }

                if (index == skillOrders.size()) {
                    break;
                }
            }
            if (resultPlus) {
                result++;
            }
        }
        return result;
    }
}
