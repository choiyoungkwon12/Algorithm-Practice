package org.example.programmers;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12899
 */
public class 나라124의숫자_12899 {
    public static void main(String[] args) {
        나라124의숫자_12899 s = new 나라124의숫자_12899();
        System.out.println(s.solution(1));
        System.out.println(s.solution(2));
        System.out.println(s.solution(3));
        System.out.println(s.solution(4));
    }
    //n을 1,2,4 로 표현 ->
    // 1 , 10 11 100 101
    // 11 -> 42 , 12 -> 44 ,
    /*
    111
    112
    114
    121
    122
    124
    141
    142
    144
    1자리 -> 3
    2자리 -> 9
    3자리 -> 27
    4자리 -> 81
    100
    ...
    3의 제곱
    n의 구간이 어딘지 일단 확인 -> 자리수 확인
    123 이면 4자리까지 합보다 크니까 5지리에서 3번째 수
    그 구간에서의 124 조합은 구하기
    나머지


     */
    public String solution(int n) {
        int digit = 0;
        int sum = 0;
        while (true) {
            digit++;
            double pow = Math.pow(3, digit);
            sum += (int) pow;
            if (sum >= n){
                sum-= (int) pow;
                break;
            }
        }
//        System.out.println(digit); // 두자리수의
//        System.out.println(sum);
        int order = n - sum;
//        System.out.println(order); // 몇번째 수인지


        String number = findNumber(digit, order);
//        System.out.println(number);
        return number;
    }

    // 주어진 자리수와 순서에 따라 해당 숫자를 찾는 메소드
    public static String findNumber(int digits, int order) {
        // "1", "2", "4"로 이루어진 숫자들의 조합을 저장할 변수
        StringBuilder result = new StringBuilder();

        // 주어진 자리수에 대해 가능한 모든 조합을 찾음
        for(int i = 0; i < digits; i++) {
            // 현재 자리수에 대한 숫자를 결정
            int currentDigit = (order - 1) / (int)Math.pow(3, digits - i - 1) % 3;
            // 결정된 숫자에 따라 결과에 추가
            if(currentDigit == 0) result.append("1");
            else if(currentDigit == 1) result.append("2");
            else result.append("4");
        }

        return result.toString();
    }

}
