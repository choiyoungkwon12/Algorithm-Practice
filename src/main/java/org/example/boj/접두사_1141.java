package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 접두사_1141 {
    private static List<String> words = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }
        Collections.sort(words, Comparator.comparingInt(String::length));
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            String s = words.get(i);
            boolean check = false;
            for (int j = i+1; j < words.size(); j++) {
                if (words.get(j).startsWith(s)) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                count++;
            }
        }

        System.out.println(count);
    }
}
