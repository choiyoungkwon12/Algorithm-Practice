package org.example.programmers;

public class 마법의엘리베이터 {
    public static void main(String[] args) {
        마법의엘리베이터 s = new 마법의엘리베이터();
        System.out.println(s.solution(2554));
        System.out.println(s.solution(16));
    }

    public int solution(int storey) {
        int answer = 0;
        while (storey != 0) {
            int i = storey % 10;
            storey /= 10;
            if (i == 5) {
                int next = storey % 10;
                answer += 5;
                if (next >= 5) {
                    storey+=1;
                }
            } else if (i > 5) {
                answer += (10 - i);
                storey+=1;
            } else {
                answer += i;
            }
        }
        return answer;
    }
}
