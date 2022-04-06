// 문제 링크 : https://www.acmicpc.net/problem/2468
// 제출 공유 링크 : http://boj.kr/dbdb254390a947c18e4af5e3edbccb38
// 백준 안전 영역

// 각 잠길 높이 별로, 각 영역을 dfs로 방문배열하면서 살펴보면.. 최대.. 100 * 100 * 100 * 100 = 1억..?
// 음.. 입력으로 받아오는 높이를 메모이제이션으로 기록해서 살펴볼 높이에 해당하는 영역이 없으면
// 계산없이 바로 지나가도록 하면 시간초과는 안날 것 같다.

// 시간초과를 걱정했는데, 위의 방법을 써서그런지 아주- 넉넉하게 끝냈다. (188ms)

package com.baekjoon.problem.java2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 영역의 크기
        int[][] map = new int[n+2][n+2];    //  영역 배열 + 벽세우기
        boolean[] heights = new boolean[101];   // 높이 확인 배열, 특정 높이의 영역이 존재하는지 여부 배열

        // 높이 및 영역 배열 초기화
        for (int i = 1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                heights[map[i][j]] = true;
            }
        }

        int maxSafeArea = 1;    // 안전한 영역의 최대 개수
        int safeArea;   // 안전한 영역 수
        boolean[][] visited;    // 방문 배열
        for (int i = 1; i<=100; i++){
            // i 높이의 영역이 없다면 이전과 같은 안전영역일 것이므로 패스
            if (!heights[i])
                continue;

            // 변수 초기화
            visited = new boolean[n+2][n+2];
            safeArea = 0;
            
            // 영역 탐색 시작
            for (int j = 1; j<=n; j++){
                for (int k = 1; k<=n; k++){
                    // 해당 영역이 물에 잠기는 부분이라면 패스
                    if (visited[j][k] || map[j][k] <= i)
                        continue;

                    // dfs로 인접한 영역에 방문탐색을 해주고
                    visited[j][k] = true;
                    dfs(map, visited, j, k, i);
                    safeArea++;
                }
            }

            // 최대 안전영역의 수를 저장한다.
            maxSafeArea = Math.max(maxSafeArea, safeArea);
        }

        // 최대 안전영역의 수를 출력한다.
        System.out.println(maxSafeArea);
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    // 깊이 우선 탐색
    static void dfs(int[][] map, boolean[][] visited, int r, int c, int height){
        // 4방위 탐색을 진행한다.
        for (int i = 0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            // 방문을 이미 했거나 범위를 벗어나려고하면(벽에 만나면) 패스
            if (visited[nr][nc] || map[nr][nc] <= height)
                continue;

            // 방문처리를 진행하고 탐색을 이어나간다.
            visited[nr][nc] = true;
            dfs(map, visited, nr, nc, height);
        }
    }
}
