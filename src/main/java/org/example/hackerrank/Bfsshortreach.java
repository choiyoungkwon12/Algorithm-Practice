package org.example.hackerrank;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Bfsshortreach {
    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    /*
    1. 엣지에 대한 정보를 저장한다. (graph)
        - 1 번 노드에서 갈 수 있는 노드들은 1번에 저장 2번은 2번에 저장
    2. 정답을 담는 리스트 초기화 (-1)
    3. 시작을 큐에 넣고 bfs 돌림
        - 방문하지 않고, 엣지에 대한 정보(그래프)가 있으면 방문처리 및 해당 도착노드 큐에 넣음
        - 만약 거리 값이 -1 (기본값)이면 6 (그래프에서 꺼내서 세팅)
        - 거리 값이 -1 이 아니면 이전 값들 + 그래프에 작성 되어있는 값 더해서 해당 인덱스에 더함.
     4. 마지막에 시작 노드, 0번째 노드에 대한 거리 데이터 삭제 -> 시작부터 삭제하지 않고 0번부터 삭제하면 리스트라 인덱스가 하나씩 밀려서 시작 +1번 인덱스에 해당되는 값이 삭제됨 ㅠ

     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here

        List<Integer> dist = new ArrayList<>();
        IntStream.range(0, n+1).forEach(x -> dist.add(-1));

        int graph[][] = new int[n+1][n+1];
        for (List<Integer> edge : edges) {
            Integer i1 = edge.get(0);
            Integer i2 = edge.get(1);
            graph[i1][i2] = 6;
            graph[i2][i1] = 6;
        }

        boolean[] visited = new boolean[n+1];
        visited[0] = true;
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int i=0;i<n+1;i++) {
                if(!visited[i] && graph[node][i] != 0) {
                    queue.add(i);
                    visited[i] = true;
                    if(dist.get(node) == -1) {
                        dist.set(i, graph[node][i]);
                    } else {
                        dist.set(i, dist.get(node) + graph[node][i]);
                    }
                }
            }
        }
        dist.remove(s);
        dist.remove(0);

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

