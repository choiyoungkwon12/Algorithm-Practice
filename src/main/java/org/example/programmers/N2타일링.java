package org.example.programmers;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/12900

 */
public class N2타일링 {
    private static int[] arr = new int[60003];
    private static int number = 1000000007;
    public static void main(String[] args) {
        N2타일링 s = new N2타일링();
        System.out.println(s.solution(4));
    }
    public int solution(int n) {
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % number;
        }
        return arr[n-1];
    }
}
