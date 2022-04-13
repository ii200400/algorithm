// 문제 링크 : https://www.acmicpc.net/problem/17143
// 제출 공유 링크 : http://boj.kr/e27556dc1a8143cb80e88160aeeabaed
// 백준 낚시왕

// 아니 이 무슨 시뮬레이션 같으니라고..
// 너무 연산이 많아서 셀수도 없이 많이 오타났다;; 2시간 30분인지 1시간 30분인지 풀었는데 아마 2시간 30분일듯..

package com.baekjoon.problem.java17143;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int r, c;
    static int[][][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();   // 격자판 세로 크기
        c = sc.nextInt();   // 격자판 가로 크기
        int m = sc.nextInt();   // 상어 수
        map = new int[r+1][c+1][3];   // 각 위치별 상어들

        // 상어들 초기화
        for (int i = 0; i<m; i++){
            int tempR = sc.nextInt();
            int tempC = sc.nextInt();
            // d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
            int s = sc.nextInt();   // 속력
            int d = sc.nextInt();   // 이동 방향
            int z = sc.nextInt();   // 크기

            // 속력 조정 (이동 위치는 주기가 있으므로)
            if(d == 1 || d == 2){
                s %= 2*(r-1);
            }else{
                s %= 2*(c-1);
            }
            map[tempR][tempC] = new int[] {s, d, z};
        }

        int totalSize = 0;    // 낚은 상어들의 총 크기
        // 가로길이만큼 아래의 연산을 진행한다.
        for (int time = 1; time<=c; time++) {
            // 낚시왕이 상어를 낚는다.
            for (int j = 1; j<=r; j++){
                if (map[j][time][2] != 0){
                    totalSize += map[j][time][2];
                    map[j][time][2] = 0;
                    break;
                }
            }

            // 상어가 이동한다.
            int[][][] nextMap = new int[r+1][c+1][3];
            for (int i = 1; i <= r; i++) {
                for (int j = 1; j <= c; j++) {
                    // 상어가 없다면 생략
                    if (map[i][j][2] == 0)
                        continue;

                    if (map[i][j][1] == 1 || map[i][j][1] == 2){    // 위, 아래
                        int nr = move(i, j);

                        // 이미 다른 상어가 있는데 지금 상어가 더 크다면 잡아먹는다.
                        if (nextMap[nr][j][2] < map[i][j][2]){
                            nextMap[nr][j] = map[i][j];
                        }
                    }else{
                        int nc = move(i, j);

                        // 이미 다른 상어가 있는데 지금 상어가 더 크다면 잡아먹는다.
                        if (nextMap[i][nc][2] < map[i][j][2]){
                            nextMap[i][nc] = map[i][j];
                        }
                    }
                }
            }

            map = nextMap;

//            for (int i = 1; i <= r; i++) {
//                for (int j = 1; j<=c; j++) {
//                    System.out.print(Arrays.toString(map[i][j]));
////                    System.out.print(map[i][j][2]);
//                }
//                System.out.println();
//            }
//            System.out.println("======================================");
        }

        System.out.println(totalSize);
    }

    // (locR, locC) 위치의 상어를 이동시킨다.
    // 한 칸씩 이동시키면 시간초과 날까봐 현 위치와 방향으로 갈 수 있는 곳까지 진행하고 방향전환을 해준다.
    static int move(int locR, int locC){
        int s = map[locR][locC][0];
        int tempR = locR, tempC = locC;
        while(true) {
            int d = map[locR][locC][1];

            if (d == 1) {   // 위 방향으로
                if (tempR-1 < s){   // 충분히 이동이 가능할 때
                    s -= tempR-1;
                    tempR = 1;
                    map[locR][locC][1] = 2;
                }else{  // 중간에 멈출 때
                    return tempR - s;
                }

            } else if (d == 2){ // 아래 방향
                if (r-tempR < s){
                    s -= r-tempR;
                    tempR = r;
                    map[locR][locC][1] = 1;
                }else{
                    return tempR+s;
                }

            }else if (d == 3){
                if (c-tempC < s){   // 오른쪽 방향
                    s -= c-tempC;
                    tempC = c;
                    map[locR][locC][1] = 4;
                }else{
                    return tempC+s;
                }

            }else{  // 왼쪽 방향
                if (tempC-1 < s){
                    s -= tempC-1;
                    tempC = 1;
                    map[locR][locC][1] = 3;
                }else{
                    return tempC - s;
                }
            }
        }
    }
}
