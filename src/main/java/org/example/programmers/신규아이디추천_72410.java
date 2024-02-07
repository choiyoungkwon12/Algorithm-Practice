package org.example.programmers;

public class 신규아이디추천_72410 {
    public static void main(String[] args) {
        신규아이디추천_72410 s = new 신규아이디추천_72410();
        System.out.println("==>" + s.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println("==>" + s.solution("abcdefghijklmn.p"));
        System.out.println("==>" + s.solution("=.="));
    }

    public String solution(String new_id) {
        new_id = new_id.toLowerCase();

        // [a-z][0-9][-][_][.]
        // .. -> .
        // startwith . endwith . -> x
        // " " -> a
        // 길이
        // ;;;

        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        new_id = new_id.replaceAll("^\\.|\\.$", "");

        if (new_id.isEmpty()) {
            new_id = "a";
        }

        new_id = getStep6(new_id);
        new_id = getStep7(new_id);
        return new_id;
    }

    public String getStep6(String step5) {
        String step6 = step5;
        if (step5.length() >= 16) {
            step6 = step5.substring(0, 15);
        }
        if (step6.charAt(step6.length() - 1) == '.') {
            step6 = step6.substring(0, step6.length() - 1);
        }
        return step6;
    }

    public String getStep7(String step6) {
        String step7 = step6;
        while (step7.length() < 3) {
            step7 += step6.charAt(step6.length() - 1);
        }
        return step7;
    }
}
