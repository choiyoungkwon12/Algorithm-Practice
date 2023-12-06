package org.example.hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.hackerrank.com/challenges/torque-and-development/problem?isFullScreen=true
 * 도서관의 가격이 도로 건설 비용보다 작거나 같으면 모든 도시에 도서관 건설 (long)으로 맞춰야 함...
 * 아니면 연결 가능한 모든 도시를 탐색하고 연결된 도시에서 하나만 도서관을 건설한다고 생각해서, 도시를 잇는 도로 수 * 도로 건설 비용 + 연결된 도시 수 * 도서관 건설 비용
 */
public class RoadsAndLibraries {


    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */
    public static boolean[] visited;
    public static List<List<Integer>> map;

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        // System.out.println(n);
        // System.out.println(cities);

        if (c_lib <= c_road) {
            return (long) n * c_lib;
        }

        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < cities.size(); i++) {
            List<Integer> city = cities.get(i);
            int city1 = city.get(0);
            int city2 = city.get(1);
            map.get(city1).add(city2);
            map.get(city2).add(city1);
        }
        System.out.println(map);

        visited = new boolean[n + 1];
        long libraryCount = 0;
        long loadCost = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                libraryCount++;
                visited[i] = true;
                loadCost += bfs(i, c_road);
            }
        }

        long result = libraryCount * c_lib;
        return result + loadCost;
    }

    public static long bfs(int start, int roadCost) {
        long result = 0;
        List<Integer> list = map.get(start);
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(list);
        while (!queue.isEmpty()) {
            int city = queue.poll();
            if (!visited[city]) {
                visited[city] = true;
                List<Integer> list2 = map.get(city);
                queue.addAll(list2);
                result += roadCost;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
