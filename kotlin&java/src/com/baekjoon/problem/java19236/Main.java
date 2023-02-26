// 문제 링크 : https://www.acmicpc.net/problem/19236
// 제출 공유 링크 : http://boj.kr/fcee5fbc9cd84b6084521ea819696850
// 백준 청소년 상어

// dfs로 먹을 수 있을 때까지 물고기를 먹으면 될 것 같은데..
// A형 유형 문제 참.. 귀찮다..

// 아.. 중간에.. for문 += 해야하는 곳에 =을 해서 .. 하.. 돌아버리는줄;;

package com.baekjoon.problem.java19236;

import java.util.Scanner;

public class Main {
    static int[] dr = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = new int[] {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][][] map = new int[4][4][2];   // 공간 배열

        // 공간 정보 초기화
        for (int i = 0; i<4; i++){
            for (int j = 0; j<4; j++) {
                map[i][j] = new int[] {sc.nextInt(), sc.nextInt()-1};
            }
        }

        answer = 0;
        int point = map[0][0][0];
        map[0][0][0] = 0;   // 상어가 물고기를 먹고 시작하므로
        dfs(point, 0, 0, map[0][0][1], map);

        System.out.println(answer);
    }

    // 상어가 이동하면서 물고기를 잡아먹는 시뮬레이션 진행
    static void dfs(int point, int r, int c, int dir, int[][][] map){
        // 각 물고기를 번호 순서대로 이동시킨다.
        fish: for (int num = 1; num<=16; num++){
            // 일단 모든 위치를 둘러봐서 해당 물고기가 있다면 이동시킨다;;
            for (int i = 0; i<4; i++){
                for (int j = 0; j<4; j++){
                    if (num != map[i][j][0])
                        continue;

                    // 8방위 탐색
                    for (int k = 0; k<8; k++){
                        int idx = (map[i][j][1]+k)%8;
                        int nr = i+dr[idx];
                        int nc = j+dc[idx];

                        // 범위를 벗어나거나 상어 위치라면 패스
                        if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || (nr == r && nc == c))
                            continue;

                        // 원래 있던 물고기(혹은 빈칸)와 자리를 바꾼다.
                        map[i][j][1] = idx;
                        int[] temp = map[nr][nc];
                        map[nr][nc] = map[i][j];
                        map[i][j] = temp;
                        break;
                    }
                    continue fish;
                }
            }
        }

        // 상어의 위치(nr, nc)를 한칸씩 이동시키면서
        boolean flag = true;
        for(int nr = r + dr[dir], nc = c + dc[dir];
            nr >= 0 && nr < 4 && nc >= 0 && nc < 4;
            nr += dr[dir], nc += dc[dir]){

            // 물고기가 없으면 패스..
            if (map[nr][nc][0] == 0)
                continue;

            flag = false;

            // 물고기가 있다면 데이터를 복사하고
            int[][][] tempMap = new int[4][4][2];
            for (int i = 0; i<4; i++){
                for (int j = 0; j<4; j++){
                    tempMap[i][j] = map[i][j].clone();
                }
            }

            // 해당 물고기를 없애고 dfs을 진행한다.
            tempMap[nr][nc][0] = 0;
            dfs(point+map[nr][nc][0], nr, nc, map[nr][nc][1], tempMap);
        }

        // 이동하지 못했다면 현재까지 얻은 포인트를 적절하게 저장한다.
        if (flag){
            answer = Math.max(answer, point);
        }
    }
}
