package org.example.programmers;

public class n진수게임 {
    public static void main(String[] args) {
        n진수게임 s = new n진수게임();
        System.out.println(s.solution(2, 4, 2, 1));
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() <= t * m) {
            String string = Integer.toString(i, n);
            sb.append(string);
            i++;
        }
        StringBuilder answer = new StringBuilder();
        for (int j = p - 1; j < sb.length(); j+=m) {
            answer.append(sb.charAt(j));
            if (answer.length() == t) {
                break;
            }
        }
        return answer.toString().toUpperCase();
    }
}
