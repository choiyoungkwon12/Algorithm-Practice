package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 10분 만에 포기 -> 데이터 넣고 bfs 돌릴때,
// 처음 익은 토마토 위치를 어떻게 설정 하는지(처음 익은 토마토 위치가 여러개 일 수 있음)
// 설정한 위치에서 시작해서 어떻게 bfs 돌려서 상자의 모든 곳에 도달할 수 있을때까지 날짜를 카운팅하는지를 모르겠어서 막힘.
// ------------------------------
// 처음 시작할때, 큐에 모두 익은 토마토 위치(x,y)를 넣고 큐가 비워질때까지 반복 실행.
// 날짜 카운팅은 안익은 -> 익은 토마토로 변할때 이전 값 +1을 해서 계산해서 가지고 있다가 마지막에 날짜 계산(시작이 1이었기 때문에 걸린 날짜는 -1)
public class 토마토_7576 {
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n, m;

    static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        map = new int[n][m];

        // 익은 토마토 담을 큐
        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;
                if (number == 1) {
                    queue.add(new Tomato(i, j));
                }
            }
        }
        int bfs = bfs(queue);
        System.out.println(bfs);
    }

    private static int bfs(Queue<Tomato> queue) {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            int x = tomato.x;
            int y = tomato.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 조건
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // 0인 경우에만 이전 토마토 + 1 이니까 겹쳐서 더 나중에 온 경우는 생각 x
                    // 익은 토마토와 인접해있는 토마토가 익지 않은 토마토인 경우
                    if (map[nx][ny] == 0) {
                        // 이전 토마토 + 1
                        map[nx][ny] = map[x][y] + 1;
                        queue.add(new Tomato(nx, ny));
                    }
                }
            }
        }

        // 익지 않은 토마토 하나라도 있으면 -1, 모두 익었으면 가장 큰 값 -1
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                result = Math.max(result, map[i][j]);
            }
        }

        return result - 1;
    }
}
