// 문제 링크 : https://www.acmicpc.net/problem/2178
// 제출 공유 링크 : http://boj.kr/bec6c449b8a045fa8701cbb32847dace

// 정말 정직한 BFS 문제로 골랐네 하하.

package com.baekjoon.problem.java2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 미로 가로 줄 수
        int m = sc.nextInt();   // 미로 세로 줄 수
        boolean[][] map = new boolean[n+2][m+2];    // 미로 지도 + 벽 세우기 + 방문 탐색 배열

        // 미로 초기화
        for (int i = 1; i<n+1; i++){
            String str = sc.next();
            for (int j = 1; j<m+1; j++){
                map[i][j] = str.charAt(j-1) == '1';
            }
        }
        
        // bfs 사용
        int[] dr = new int[] {1, -1, 0, 0};
        int[] dc = new int[] {0, 0, 1, -1};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 1}); // 큐 초기화

        int depth = 0; // 이동(깊이) 회수 (시작 칸은 1)
        bfs: while (!q.isEmpty()){
            depth++;  // 이동 칸 수 추가

            // depth번의 이동으로 갈 수 있는 곳 모두 탐색
            int qSize = q.size();
            for (int i = 0; i<qSize; i++) {

                int[] current = q.poll();   // 현재 위치
                // 원하는 위치에 도착했다면 bfs 탈출
                if (current[0] == n && current[1] == m)
                    break bfs;

                // 4방위 탐색
                for (int j = 0; j < 4; j++) {
                    int r = current[0] + dr[j];
                    int c = current[1] + dc[j];

                    // 지나갈 수 없는 곳이면 패스
                    if (!map[r][c])
                        continue;

                    // 갈 수 있다면 갈 수 없는 곳으로 기록하고(지나간 곳은 다시 방문할 필요가 없으므로)
                    map[r][c] = false;
                    q.add(new int[]{r, c});
                }
            }
        }

        // (m, n)까지 최소 이동 회수 출력
        System.out.println(depth);
    }
}
