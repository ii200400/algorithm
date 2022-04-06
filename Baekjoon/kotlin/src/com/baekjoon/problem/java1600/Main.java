// 문제 링크 : https://www.acmicpc.net/problem/1600
// 제출 공유 링크 : http://boj.kr/d233f6a93f0f4882bc5e6b9d01e00af1
// 백준 말이 되고픈 원숭이

// 뭔가.. bfs를 쓰면서 맵에 말의 움직임 회수가 얼마나 남은지 기록하고
// 움직임 회수에 따라서 적절하게 큐에 저장하도록 하면.. 되지 않나?
// 예전에 풀었던.. 벽뚫고가기? 라는 문제와 비슷하다.

package com.baekjoon.problem.java1600;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();   // 말 움직임 회수
        int w = sc.nextInt();   // 가로 길이
        int h = sc.nextInt();   // 세로 길이
        int[][] map = new int[h][w];    // 격자판 (방문시 남은 말 움직임 회수 저장 예정)

        // 아래 코드로는 해당 예외를 잡을 수 없어서 작성
        if (w == 1 && h == 1){
            System.out.println(0);
            return;
        }

        // 격자판 초기화, 평지이면 -1 장애물이면 -2
        for (int i = 0; i<h; i++){
            for (int j = 0; j<w; j++){
                map[i][j] = sc.nextInt()==1? -2:-1;
            }
        }

        // bfs에 사용할 큐 생성 및 초기화
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, k});
        map[0][0] = k;

        // 4방위 및 나이트 이동
        int[] dr = new int[]{0, 0, -1, 1, -2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = new int[]{-1, 1, 0, 0, -1, 1, -2, 2, -2, 2, -1, 1};

        int cnt = 0;   // 동작 회수
        while (!q.isEmpty()){
            cnt++;

            // 레벨우선탐색
            int qSize = q.size();
            for (int i = 0; i<qSize; i++){
                int[] current = q.poll();

                // 4방위 및 체스의 나이트 이동 탐색
                search: for (int j = 0; j<12; j++){
                    int nr = current[0] + dr[j];
                    int nc = current[1] + dc[j];
                    int leftK = current[2] - (j > 3? 1:0);

                    if (leftK < 0)
                        continue;

                    // 도착점에 도달하면 이동에 걸린 시간 출력 후 종료
                    if (nr == h-1 && nc == w-1){
                        System.out.println(cnt);
                        return;
                    }

                    // 범위를 벗어나거나 이미 해당 위치에 leftK(말 움직임 회수)가 더 많이 있는 상태로 방문 경험이 있다면
                    if (nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] >= leftK || map[nr][nc] == -2)
                        continue;

                    // 말처럼 움직이는데 중간에 장애물이 있다면 생략한다.
                    if (j > 3){
                        for (int l = current[0]; l<=nr; l++){
                            for (int m = current[1]; m<=nc; m++){
                                if (map[nr][nc] == -2)
                                    continue search;
                            }
                        }
                    }

                    // 격자판에 말 움직임 회수를 저장하고 위치와 말 움직임 회수를 큐에 저장한다.
                    map[nr][nc] = leftK;
                    q.add(new int[]{nr, nc, leftK});
                }
            }
        }

        // 도착점까지 도달하지 못했을 때
        System.out.println(-1);
    }
}
