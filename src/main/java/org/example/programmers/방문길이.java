package org.example.programmers;

public class 방문길이 {

    private static int dr[] = {-1, 0, 1, 0};
    private static int dc[] = {0, -1, 0, 1};

    public static void main(String[] args) {
        방문길이 s = new 방문길이();
        System.out.println(s.solution("ULURRDLLU"));
    }

    public int solution(String dirs) {
        int answer = 0;
        int map[][] = new int[11][11];
        boolean visit[][][] = new boolean[11][11][4];
        int r = 5;
        int c = 5;

        for (int i = 0; i < dirs.length(); i++) {
            String command = String.valueOf(dirs.charAt(i));
            int d = 0;
            if (command.equals("U")) {
                d = 0;
            }
            if (command.equals("L")) {
                d = 1;
            }
            if (command.equals("D")) {
                d = 2;
            }
            if (command.equals("R")) {
                d = 3;
            }
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= 11 || nc >= 11) {
                continue;
            }

            if (!visit[nr][nc][d]) {
                visit[nr][nc][d] = true;
                d = (d % 2 == 0) ? 2 - d : 4 - d;
                visit[r][c][d] = true;
                answer++;
            }

            r = nr;
            c = nc;
        }
        return answer;
    }
}