// 문제 링크 : https://www.acmicpc.net/problem/16197
// 제출 공유 링크 : http://boj.kr/e4c9d1f892dc4ac692fb9c80abd36b2b
// 백준 두 동전

// 단순히 bfs를 활용하였다.
// 이동이 10회 초과인 경우 -1을 출력하는 것이 없었으면 아마.. 다른 방법을 썼을 것이다.

// 아.. 이전 방향으로 돌아가지 못하게 막아서 계속 틀렸었다..
// 흙흙;; 다음에는 틀리지 말아야지..

package com.baekjoon.problem.java16197;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int n, m, answer;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();   // 세로 크기
        m = sc.nextInt();   // 가로 크기
        answer = 11;    // 최소 이동 회수
        map = new char[n][m];    // 보드
        int[][] coin = new int[2][2];   // 두 코인의 위치
        int coinCnt = 0;

        // 보드 초기화
        for (int i = 0; i<n; i++){
            String str = sc.next();
            for (int j = 0; j<m; j++){
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'o'){
                    coin[coinCnt++] = new int[] {i, j};
                }
            }
        }

        // 코인 이동시켜보기
        dfs(coin[0], coin[1],0);

        System.out.println(answer==11? -1:answer);
    }

    static int[] dr = new int[] {1, 0, -1, 0};
    static int[] dc = new int[] {0, 1, 0, -1};

    static void dfs(int[] c1, int[] c2, int cnt){
        // 최소 이동 회수가 현재 이동회수보다 작으면 되돌아간다.
        if (answer <= cnt+1)
            return;

        for (int i = 0; i<4; i++){
            int[] nc1 = new int[] {c1[0]+dr[i], c1[1]+dc[i]};
            int[] nc2 = new int[] {c2[0]+dr[i], c2[1]+dc[i]};

            boolean flag1 = canGo(nc1), flag2 = canGo(nc2);
            if (!flag1 && !flag2){  // 두 동전이 모두 떨어지면
                continue;
            }else if (!flag1 || !flag2){    // 둘 중 하나만 떨어지면
                answer = Math.min(answer, cnt+1);
                return;
            }

            // 벽이 있어서 못 갔다면..
            if (map[nc1[0]][nc1[1]] == '#'){
                nc1 = c1;
            }
            if (map[nc2[0]][nc2[1]] == '#'){
                nc2 = c2;
            }
            // 벽 때문에 두 코인 모두 이동을 못했다면..
            if (nc1 == c1 && nc2 == c2){
                continue;
            }

            // 다음 방향으로 이동시켜본다.
            dfs(nc1, nc2, cnt+1);
        }
    }

    // 보드 범위 내에 있다면 true를 반환하는 함수
    static boolean canGo(int[] loc){
        if (loc[0] < 0 || loc[0] >= n || loc[1] < 0 || loc[1] >= m)
            return false;
        return true;
    }
}
