package org.example.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BetweenTwoSets {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int minB = b.stream().mapToInt(Integer::intValue).min().orElse(0);

        List<Integer> commonFactors = findCommonFactors(b, minB);

        return countValidFactors(commonFactors, a);
    }

    private static List<Integer> findCommonFactors(List<Integer> b, int minB) {
        List<Integer> common = new ArrayList<>();
        for (int i = 1; i <= minB; i++) {
            if (isCommonFactor(b, i)) {
                common.add(i);
            }
        }
        return common;
    }

    private static boolean isCommonFactor(List<Integer> b, int num) {
        return b.stream().allMatch(value ->  value % num == 0);
    }

    private static int countValidFactors(List<Integer> commonFactors, List<Integer> a) {
        return (int) commonFactors.stream()
                .filter(factor -> a.stream().allMatch(value -> factor % value == 0))
                .count();
    }

    public static void main(String[] args) throws IOException {
        int totalX = getTotalX(List.of(2,4), List.of(16,32,96));
        System.out.println(totalX);
    }
}

