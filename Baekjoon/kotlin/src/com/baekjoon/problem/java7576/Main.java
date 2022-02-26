// 문제 링크 : https://www.acmicpc.net/problem/7576
// 제출 공유 링크 : http://boj.kr/8600e500ec2b430eb9830ec7133b064b

// 아주 일반적인 BFS문제로 보인다.
// 딱 퇴직했을 때 문제를 풀었다는 기록과 1년전에 틀렸다는 기록이 있다.
// 아마 그 때 dfs만 알고있던 때라서 못 풀었던 것 같다.

package com.baekjoon.problem.java7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cLen = Integer.parseInt(st.nextToken());   // 토마토 상자 가로 길이
        int rLen = Integer.parseInt(st.nextToken());   // 토마토 상자 세로 길이
        int[][] tBox = new int[rLen+2][cLen+2];    // 토마토 상자, 벽을 세우기 위해 +2
        Queue<int[]> q = new LinkedList<>();    // BFS에 쓰일 큐

        // 토마토 상자 및 큐 초기화
        for (int i = 1; i<rLen+1; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j<cLen+1; j++){
                tBox[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토가 있다면 큐에 추가!
                if (tBox[i][j] == 1)
                    q.add(new int[]{i, j});
            }
        }

        // 토마토 상자 벽 세우기
        Arrays.fill(tBox[0], -1);
        Arrays.fill(tBox[rLen+1], -1);
        int[] wallIdx = new int[]{0, cLen+1};
        for (int i = 1; i<rLen+1; i++){
            for (int j : wallIdx)
                tBox[i][j] = -1;
        }

        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{1, -1, 0, 0};

        // BFS 시작!
        int day = -1;
        while (!q.isEmpty()){
            day++;

            // 하루마다 한꺼번에 토마토가 익는 것을 처리한다.
            int qSize = q.size();
            for (int i = 0; i<qSize; i++){
                int[] location = q.poll();  // 현재 토마토 위치

                // 현재 토마토 위치 주변으로
                for (int j = 0; j<4; j++) {
                    int r = location[0]+dr[j], c = location[1]+dc[j];
                    // 안익은 토마토가 있는 공간이 아니라면 패스
                    if (tBox[r][c] != 0)
                        continue;

                    // 안익은 토마토가 있다면 익히고
                    tBox[r][c] = 1;
                    // 큐에 넣는다.
                    q.add(new int[] {r,c});
                }
            }
        }

        // 토마토가 모두 익었는지 확인한다.
        boolean flag = true;    // 모든 토마토가 익었는지 여부
        check: for (int i = 1; i<rLen+1; i++){
            for (int j = 1; j<cLen+1; j++){
                if (tBox[i][j] == 0){
                    flag = false;
                    break check;
                }
            }
        }

        // 모두 익었다면 익은 날짜 출력
        System.out.println(flag? day: -1);
    }
}
