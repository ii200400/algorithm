// 문제 링크 : https://www.acmicpc.net/problem/14503
// 제출 공유 링크 : http://boj.kr/da6d9e567fec4d3e83e1d2cf7d986597
// 백준 로봇 청소기

// 잘 풀었는데 뭔가.. 지문을 잘 이해한게 맞나? 싶어서 질문 검색을 봤더니,
// 해당 문제의 지문이 많이 수정된것 같다. 아주.. 난리도 아니다;;

// 시뮬레이션 문제로 쓰여진 과정 그대로 코딩해서 패스를 받았다.

package com.baekjoon.problem.java14503;

import java.util.Scanner;

public class Main {

    // 서 북 동 남 쪽으로 한 칸 이동
    static int[] dr = new int[] {0, -1, 0, 1};
    static int[] dc = new int[] {-1, 0, 1, 0};

    static class CleanBot {
        int r;  // 세로 칸 수
        int c;  // 가로 칸 수
        int dir;    // 로봇 방향
        int cleanCnt;   // 청소 회수

        public CleanBot(int r, int c, int dir, int cleanCnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cleanCnt = cleanCnt;
        }

        void turnLeft(){
            this.dir--;
            if (this.dir < 0){
                this.dir = 3;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(); // 장소 크기 (세로, 가로)
        int[][] map = new int[n][m];    // 장소 배열
        CleanBot robot =
                new CleanBot(sc.nextInt(), sc.nextInt(), sc.nextInt(), 0);
        
        // 장소 초기화 + 벽세우기
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        // 로봇 청소기는 아래의 작업을 반복해서 진행한다.
        work: while(true){
            // 1. 현 위치를 청소할 수 있다면 청소를 한다.
            if (map[robot.r][robot.c] == 0) {
                robot.cleanCnt++;
                map[robot.r][robot.c] = -1;
            }

            // 2.a 현재 위치에서 다음을 반복하면서 인접한 칸을 탐색한다.
            for (int i = 0; i<4; i++){
                // 현재 위치의 왼쪽에
                int nr = robot.r+dr[robot.dir];
                int nc = robot.c+dc[robot.dir];

                robot.turnLeft();   // 어느 곳이 탐지되든 왼쪽으로 돌아가므로

                // 벽이나 청소를 한 곳이 있다면 패스..
                if (map[nr][nc] != 0)
                    continue;

                // 아직 청소하지 않은 빈 공간이 존재한다면 전진하고 청소하러 간다.
                robot.r = nr;
                robot.c = nc;
                continue work;
            }

            // 2.b 연속 4번 돌기만 했는데
            int nr = robot.r + dr[(robot.dir+3)%4];
            int nc = robot.c + dc[(robot.dir+3)%4];

            //뒤가 벽이라면 작동을 멈춘다.
            if (map[nr][nc] == 1)
                break;

            // 벽이 아니라면 후진한다.
            robot.r = nr;
            robot.c = nc;
        }

        // 로봇 청소기가 청소한 칸의 개수를 출력한다.
        System.out.println(robot.cleanCnt);
    }
}
