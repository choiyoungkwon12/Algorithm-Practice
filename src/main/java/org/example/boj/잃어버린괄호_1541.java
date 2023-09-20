package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 그리디 - 주어진 입력의 결과를 가장 작은 수로 만드려면 가장 큰 값들을 빼면 된다.
// ex. 55 - 50 + 40 일때, - 이후 다음 - 까지 수를 모두 더 한 후 빼면 가장 작은 수가 된디.
public class 잃어버린괄호_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] strings = input.split("-");
        String[] strings1 = strings[0].split("\\+");
        int answer = 0;
        for (String value : strings1) {
            int s = Integer.parseInt(value);
            answer += s;
        }
        for (int i = 1; i < strings.length; i++) {
            String string = strings[i];
            int sum = 0;
            String[] numbers = string.split("\\+");
            for (int j = 0; j < numbers.length; j++) {
                int number = Integer.parseInt(numbers[j]);
                sum += number;
            }
            answer -= sum;
        }
        System.out.println(answer);
    }
}
