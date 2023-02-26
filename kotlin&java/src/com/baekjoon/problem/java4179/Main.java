// 문제 링크 : https://www.acmicpc.net/problem/4179
// 제출 공유 링크 : http://boj.kr/30088c3ff97e45deb0c922109c1a5328
// 백준 불!

// 직장 바꾸는게 어떻겠니 지훈아..?

// 저번에 뭐였지.. 고슴도치가 범람하는 물에서 생존할 수 있냐는.. 탈출이라는 백준문제인가?랑 똑같다..
// 불이.. 한곳에서 발생한다는 조건이 없어서 여러개 있다는 조건으로 진행하겠다.

package com.baekjoon.problem.java4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());   // 미로의 세로 길이
        int c = Integer.parseInt(st.nextToken());   // 미로의 가로 길이
        int[][] map = new int[r][c];    // 미로 배열 (0: 빈칸 1: 지훈이 갈 수 있는 곳 2:불이 붙은 곳 3: 벽)
        Queue<int[]> fires = new LinkedList<>();    // 불이 번지고 있는 곳
        Queue<int[]> jQueue = new LinkedList<>();    // 지훈이 가장 멀리 갈 수 있는 곳

        // 큐와 미로 초기화
        for (int i = 0; i<r; i++){
            String s = br.readLine();
            for (int j = 0; j<c; j++){
                char ch = s.charAt(j);
                if (ch == '.') {
                    map[i][j] = 0;
                }else if (ch == 'J'){
                    map[i][j] = 1;
                    jQueue.add(new int[]{i, j});
                }else if (ch == 'F'){
                    map[i][j] = 2;
                    fires.add(new int[]{i, j});
                }else{
                    map[i][j] = 3;
                }
            }
        }

        // 4방위 탐색
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        int time = 0;   // 탈출시간
        while(!jQueue.isEmpty()){
            time++;

            // 불의 레벨 우선 탐색
            int qSize = fires.size();
            for (int i = 0; i<qSize; i++){
                int[] current = fires.poll();

                // 4방위 탐색
                for (int j = 0; j<4; j++){
                    int nr = current[0] + dr[j];
                    int nc = current[1] + dc[j];

                    // 이미 불이 있거나 벽이 있다면 패스
                    if (nr < 0 || nr >= r || nc < 0 || nc >=c || map[nr][nc] >= 2)
                        continue;

                    map[nr][nc] = 2;
                    fires.add(new int[] {nr, nc});
                }
            }

            // 지훈의 레벨 우선 탐색
            qSize = jQueue.size();
            for (int i = 0; i<qSize; i++){
                int[] current = jQueue.poll();

                // 맵의 가장자리에 있다면 미로를 탈출한다.
                if (current[0] == 0 || current[0] == r-1 || current[1] == 0 || current[1] == c-1) {
                    System.out.println(time);
                    return;
                }

                // 4방위 탐색
                for (int j = 0; j<4; j++){
                    int nr = current[0] + dr[j];
                    int nc = current[1] + dc[j];

                    // 이전에 방문한 경험이 있거나 불이 있거나 벽이 있다면 패스
                    if (map[nr][nc] >= 1)
                        continue;

                    map[nr][nc] = 1;
                    jQueue.add(new int[] {nr, nc});
                }
            }
        }

        // 탈출하지 못했다..
        System.out.println("IMPOSSIBLE");
    }
}
