// 문제 링크 : https://www.acmicpc.net/problem/1520
// 제출 공유 링크 : http://boj.kr/8d1b614d805246f4a078a7b1897687f0
// 백준 내리막 길

// 음.. 여유롭게 생각하고 풀어보니 잘 풀린다;;
// 메모이제이션을 활용하여 풀었다.
// 음.. memo와 map 변수명을 반대로 써서 조금;; 해결이 늦어졌다;;

package com.baekjoon.problem.java1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[][] map, memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());   // 세로 크기
        n = Integer.parseInt(st.nextToken());   // 가로 크기
        map = new int[m][n];    // 높이 배열
        memo = new int[m][n];     // 각 위치부터 m-1, n-1까지의 이동 경우의 수 저장
        // 내려오면서 이전에 있던 곳은 어차피 오르막이 되니 딱히 방문체크 안 해도된다.

        // 지도 초기화
        for (int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // memo 초기화
        for (int i = 0; i<m; i++){
            Arrays.fill(memo[i], -1);
        }
        memo[m-1][n-1] = 1;

        // dfs 진행
        dfs(0, 0);

//        for (int i = 0; i<m; i++){
//            System.out.println(Arrays.toString(memo[i]));
//        }

        // 0,0에서 m-1, n-1까지 가는 경우의 수 출력
        System.out.println(memo[0][0]);
    }

    static int[] dr = new int[] {0, 0, -1, 1};
    static int[] dc = new int[] {1, -1, 0, 0};

    static void dfs(int r, int c){
        int sum = 0;
        for (int i = 0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            // 범위를 벗어나거나 오르막길/평지라면 생략
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || map[r][c] <= map[nr][nc])
                continue;

            // 아직 방문한 경험이 없는 길이라면 dfs 진행
            if (memo[nr][nc] == -1)
                dfs(nr, nc);

            // 경우의 수 합산
            sum += memo[nr][nc];
        }

        // 경우의 수 기록
        memo[r][c] = sum;
    }
}
