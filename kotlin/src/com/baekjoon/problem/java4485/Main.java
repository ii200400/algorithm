// 문제 링크 : https://www.acmicpc.net/problem/4485
// 제출 공유 링크 : http://boj.kr/c9ff66d1025f44f688899f9eaa35869a
// 백준 녹색 옷 입은 애가 젤다지?

// dp가 맞는건가..? 4방위 탐색+우선순위 큐가 머리속에 스쳐지나가는데;;
// dp를 안쓰고 위와같이 해결하니까 메모리 초과가 났다.
// 메모이제이션에 dfs로 풀어보겠다.
// 아니 이번에는 시간초과넼ㅋㅋㅋㅋㅋ

// 어흑흑흘흐륵ㅎ.. 첫번째 방법이 맞는데, 조건을 잘못 넣어주어서 메모리 초과가 났던 것이었다 아흐흑...

package com.baekjoon.problem.java4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = new int[]{0, 1, -1, 0};
    static int[] dc = new int[]{1, 0, 0, -1};

    static int n;
    static int[][] map, memo;

    // 우선순위 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tastcase = 0;    // 맵 크기, 테스트 케이스 번호
        PriorityQueue<int[]> qp;    // 맵의 이동 우선순위 지정을 위함 [가중치, 행, 열]을 저장한다.
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            map = new int[n + 2][n + 2];    // 맵의 도둑루피들 예외처리를 위해 +2
            tastcase++;

            // 도둑루피 맵 초기화
            StringTokenizer st;
            Arrays.fill(map[0], -1);
            Arrays.fill(map[n + 1], -1);
            for (int i = 1; i <= n; i++) {
                map[i][0] = -1;
                map[i][n + 1] = -1;
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 메모라이제이션과 우선순위 큐 초기화
            qp = new PriorityQueue<>(Comparator.comparing(o ->o[0]));
            qp.add(new int[]{map[1][1], 1, 1});
            boolean[][] memo = new boolean[n + 2][n + 2];
            memo[1][1] = true;

            int answer;
            search:
            while (true) {
                int[] current = qp.poll();
                int cost = current[0];
                int r = current[1];
                int c = current[2];

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (map[nr][nc] == -1 || memo[nr][nc])
                        continue;

                    // 메모에 기록해주고 우선순위 큐에도 넣어준다.
                    memo[nr][nc] = true;
                    qp.add(new int[]{cost + map[nr][nc], nr, nc});

                    // 제일 오른쪽 아래칸에 도착하면 탈출
                    if (nr == n && nc == n) {
                        answer = cost + map[nr][nc];
                        break search;
                    }
                }
            }

            // 제일 오른쪽 아래칸의 기록 출력
            System.out.printf("Problem %d: %d%n", tastcase, answer);
        }
    }

    // dfs (시간초과)
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int tastcase = 0;   // 테스트 케이스 번호
//        // n : 맵 크기
//        while ((n = Integer.parseInt(br.readLine())) != 0) {
//            map = new int[n+2][n+2];    // 맵의 도둑루피들 예외처리를 위해 +2
//            tastcase++;
//
//            // 도둑루피 맵 초기화
//            StringTokenizer st;
//            Arrays.fill(map[0], -1);
//            Arrays.fill(map[n+1], -1);
//            for (int i = 1; i<=n; i++){
//                map[i][0] = -1;
//                map[i][n+1] = -1;
//                st = new StringTokenizer(br.readLine());
//                for (int j = 1; j<=n; j++){
//                    map[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//
//            memo = new int[n+2][n+2];   // 메모라이제이션
//            for (int i = 1; i<=n; i++){
//                for (int j = 1; j<=n; j++){
//                    memo[i][j] = Integer.MAX_VALUE;
//                }
//            }
//            memo[1][1] = map[1][1];
//
//            // dfs 시작
//            dfs(1, 1);
//
//            // 제일 오른쪽 아래칸의 기록 출력
//            System.out.printf("Problem %d: %d%n", tastcase, memo[n][n]);
//        }
//    }
//
//    static void dfs(int r, int c){
//        // 4방위 탐색을 하는데
//        for (int i = 0; i < 4; i++) {
//            int nr = r+dr[i];
//            int nc = c+dc[i];
//
//            // 범위를 벗어나거나 가는 비용이 더 크면 패스
//            if (map[nr][nc] == -1 || memo[r][c] + map[nr][nc] >= memo[nr][nc])
//                continue;
//
//            // 메모에 기록해주고 우선순위 큐에도 넣어준다.
//            memo[nr][nc] = memo[r][c] + map[nr][nc];
//            dfs(nr, nc);
//        }
//    }
}
