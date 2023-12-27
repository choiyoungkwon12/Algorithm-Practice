package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기_1759 {
    private static String[] strings;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        strings = new String[c];
        visited = new boolean[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            String character = st.nextToken();
            strings[i] = character;
        }
        Arrays.sort(strings);

        combination(0, c, l);
    }

    private static void combination(int start, int n, int r) {
        if (r == 0) {
            print(n);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    private static void print(int n) {
        StringBuilder sb = new StringBuilder();
        int consonant = 0;
        int vowel = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                if (strings[i].equals("a") || strings[i].equals("e") || strings[i].equals("o") || strings[i].equals("i") || strings[i].equals("u")) {
                    consonant++;
                } else {
                    vowel++;
                }
                sb.append(strings[i]);
            }
        }
        if (consonant >= 1 && vowel >= 2) {
            System.out.println(sb);
        }
    }
}
