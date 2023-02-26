// 이전에 푼 방법이 너무 잘 기억나긴 하는데..
// 오늘날짜로 푼 것 캡쳐하라고 하시니 풀었다.

// 분명히 bfs 방문탐색으로 했었는데 그 방법이 가장 빨라서; 그 방법으로 한 번 더 풀어보겠다.
// 에.. 예전에 어떻게 했었냐..? 기억이가 안나는건가.. 나는건가?

// 아.. dfs에 bfs를 가미해서 풀었던것 같아서 중간에 바꿔서 풀었는데,
// 이전코드랑 비교하니까.. 놀라운 정도로 같ㄷ..

package com.baekjoon.problem.java2636;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    static int n, m;
    static Queue<int[]> q;
    static boolean[][] map, visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 세로 길이
        m = sc.nextInt();   // 가로 길이
        map = new boolean[n][m];    // 판 배열
        visited = new boolean[n][m];    // 방문 배열

        // 판 초기화
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                map[i][j] = sc.nextInt()==1;
            }
        }

        // bfs를 위한 큐
        q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;



        int time = -1;   // 치즈가 모두 녹아서 없어지는 데 걸리는 시간
        int size = 0;   // 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수
        while (!q.isEmpty()){
            time++;
            size = q.size();

            // 레벨 우선 탐색
            for (int i = 0; i<size; i++) {
                int[] current = q.poll();
                int r = current[0];
                int c = current[1];
                dfs(r, c);
            }
        }

        // 걸린 시간과 크기 출력
        System.out.println(time);
        System.out.println(size);
    }

    static int[] dr = new int[] {1, -1, 0, 0};
    static int[] dc = new int[] {0, 0, 1, -1};

    static void dfs(int r, int c){
        // 4방위 탐색
        for (int j = 0; j<4; j++){
            int nr = r+dr[j];
            int nc = c+dc[j];

            // 범위를 벗어나거나 방문했었다면 패스
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc])
                continue;

            // 방문 체크를 해주고
            visited[nr][nc] = true;

            // 치즈가 있다면 큐에 넣어준다.
            // 방문체크를 하기 때문에 치즈는 없애지 않아도 된다.
            if (map[nr][nc]){
                q.add(new int[] {nr, nc});
            }else{
                dfs(nr, nc);
            }
        }
    }
}
