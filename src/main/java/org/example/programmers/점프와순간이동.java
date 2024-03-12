package org.example.programmers;

public class 점프와순간이동 {
    public static void main(String[] args) {
        점프와순간이동 s = new 점프와순간이동();
        System.out.println(s.solution(5000));
    }

    public int solution(int n) {
        int ans = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                ans++;
            }
            n /= 2;
        }
        return ans;
    }
}
