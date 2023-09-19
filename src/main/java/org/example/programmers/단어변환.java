package org.example.programmers;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

// 포기 시간 -> 10분
// 스택에 시작부터 하나씩 넣어가면서 이전 단어와 words 중 글자가 1개만 다른 단어를 탐색하면서 카운트하는 방법으로 dfs로 풀려고 했으나, 풀이 구현이 떠오르지 않아서 포기
// -----------------------
public class 단어변환 {
    public static void main(String[] args) {
        단어변환 s = new 단어변환();
//        int solution = s.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        int solution = s.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
        System.out.println("solution = " + solution);
    }

    private static String start;
    private static String end;
    private static Map<String, Node> dictionary;
    private static int count = 0;

    public int solution(String begin, String target, String[] words) {
        dictionary = Arrays.stream(words).collect(Collectors.toMap(s -> s, o -> new Node()));
        start = begin;
        end = target;
        dictionary.put(begin, new Node());
        dfs();

        return count;
    }

    private void dfs() {
        if (!dictionary.containsKey(end)) {
            count = 0;
            return;
        }

        Stack<String> stack = new Stack<>();
        stack.push(start);
        count = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            String out = stack.pop();
            // 이미 방문한 단어는 다시 사용하지 않게 하기 위함
            dictionary.get(out).checked = true;

            if (out.equals(end)) {
                count = Math.min(count, dictionary.get(out).count);
            }
            getWords(out, stack, dictionary.get(out).count);
        }
    }

    public void getWords(String key, Stack<String> stack, int parent_count) {
        int wordLength = key.length();

        // 다른 단어중 글자가 하나만 다른지 확인 후 스택에 저장
        for (String w : dictionary.keySet()) {
            if (!dictionary.get(w).checked) {
                // 다른 글자가 몇개인지 확인하는 변수
                int count = 0;
                for (int i = 0; i < wordLength; i++) {
                    if (w.charAt(i) != key.charAt(i)) {
                        count++;
                    }
                }
                if (count == 1) {
                    dictionary.get(w).count = parent_count + 1;
                    stack.add(w);
                }
            }
        }
    }

    private static class Node {
        int count;
        boolean checked;

        public Node() {
            this.count = 0;
            this.checked = false;
        }
    }
}
