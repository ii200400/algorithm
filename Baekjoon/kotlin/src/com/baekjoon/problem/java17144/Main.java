// 문제 링크 : https://www.acmicpc.net/problem/17144
// 제출 공유 링크 : http://boj.kr/2c529f965b6d4db69fd8df64a084a9c4
// 제출 공유 링크(더 줄이고 더 느려짐) : http://boj.kr/92a3c08dcfc34003961b65032a5f7abe

// 달팽이 배열이였나? 배열에 달팽이처럼 숫자를 입력하는 문제에서
// 방향을 바꾸었던 것 처럼 먼지 이동을 해결하고..
// 달팽이 배열 문제 링크는 https://gist.github.com/ii200400/290795e2e78a992b0a014b4ac8c449c9
// 연산을 계산해보니 최악으로 1억 조금 넘는 것 같은데, 자바는 2초를 주니까 시간은 넉넉하다.
// 연산 시간은 늘리고 코딩을 줄이는 쪽으로 하겠다.

// 아이고 두야.. 그냥 if-else문 복붙을 할껄 그랫나..

// 정말 극한까지 줄여보았다 하하하 재미있군!

package com.baekjoon.problem.java17144;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[][] room;
    static int cLen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rLen = sc.nextInt();    // 세로 크기
        cLen = sc.nextInt();    // 가로 크기
        int time = sc.nextInt();    // 시간
        room = new int[rLen][cLen]; // 방의 미세먼지 배열

        // 방 정보 입력
        int upperAirCond = 0, lowerAirCond = 0; // 위, 아래 공기 청정기 r 위치
        for(int i = 0; i<rLen; i++){
            for (int j = 0; j<cLen; j++){
                room[i][j] = sc.nextInt();

                // 공기 청정기 위치 초기화
                if (room[i][j] == -1){
                    if (upperAirCond == 0)
                        upperAirCond = i;
                    else
                        lowerAirCond = i;
                }
            }
        }

        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{1, -1, 0, 0};

        // time 만큼 반복한다.
        for (int t = 0; t<time; t++) {

            // 먼지가 확산된 후의 방상태를 저장할 배열을 만든다.
            int[][] tempRoom = new int[rLen][cLen];
            // 각 위치의 미세먼지를 확산한다.
            for (int i = 0; i < rLen; i++) {
                for (int j = 0; j < cLen; j++){
                    // 먼지가 없는 곳이거나 공기 청정기가 있다면 생략하고
                    if (room[i][j] < 1)
                        continue;

                    // 먼지가 있다면 확산을 진행한다.
                    int dust = room[i][j], spread = dust/5;  // 해당 위치의 먼지량, 퍼지는 먼지량
                    for (int k = 0; k<4; k++){
                        int r = i+dr[k], c = j+dc[k];   // 주변 위치

                        // 벽이 있거나 공기 청정기가 있으면 확산을 못하고
                        if (r < 0 || rLen <= r || c < 0 || cLen <= c || room[r][c] == -1)
                            continue;

                        // 그렇지 않으면 확산을 한다.
                        tempRoom[r][c] += spread;
                        dust -= spread;
                    }

                    // 모두 확산되고 남은 먼지도 저장해준다.
                    tempRoom[i][j] += dust;
                }
            }

            // 아이고난! 공기청정기를 버려서 오답이..
            tempRoom[lowerAirCond][0] = -1;
            tempRoom[upperAirCond][0] = -1;
            // 먼지가 확산된 후의 방 상태로 변경시킨다.
            room = tempRoom;

            // 디버깅용 출력
//            for (int i = 0; i<rLen; i++){
//                System.out.println(Arrays.toString(room[i]));
//            }
//            System.out.println();

            // 으으.. 공기 청정기 바람을 돌린다.
            // 시계반향은 반시계로 반시계는 시계방향으로 탐색하면서 먼지 정보를 덮어 씌우면 더 편하다.
            // 우선은 위의 공기청정기부터 진행한다.
//            int r = upperAirCond-1, c = 0;  // 현 위치
//            int _dr = -1, _dc = 0;  // 위치 변화량
//            while(!(r == upperAirCond && c == 1)){
//                // 탐색할 수 없는 위치를 탐색하려고 하면 (아래 공기청정기 방향으로 가면 안된다. || c+_dc < 0 이 조건은 필요가 없네..)
//                if (r+_dr <= -1 || lowerAirCond <= r+_dr || cLen <= c+_dc){
//                    // 방향을 바꿔준다. (왜 이렇게 되는지는 위의 달팽이 문제 링크 참고)
//                    int temp = _dr;
//                    _dr = _dc;
//                    _dc = -temp;
//                }
//
//                // 먼지를 옮기고 위치도 옮겨준다.
//                room[r][c] = room[r+_dr][c+_dc];
//                r += _dr;
//                c += _dc;
//            }
//            // 공기청정기는 먼지없는 바람을 내뿜는다.
//            room[r][c] = 0;
            airConditionWind(upperAirCond, -1, 0, 1, lowerAirCond, -1);

            // 이번에는 아래의 공기 청정기의 바람에 이동하는 먼지들..
//            r = lowerAirCond+1; // 현 위치
//            c = 0;
//            _dr = 1;// 위치 변화량
//            _dc = 0;
//            while(!(r == lowerAirCond && c == 1)){
//                // 탐색할 수 없는 위치를 탐색하려고 하면 (위의 공기청정기 신경써서.. 으윽..; 마찬가지로 || c+_dc < 0 필요 없다.)
//                if (r+_dr <= upperAirCond || rLen <= r+_dr || cLen <= c+_dc){
//                    // 방향을 바꿔준다.
//                    int temp = _dr;
//                    _dr = -_dc;
//                    _dc = temp;
//                }
//
//                // 먼지를 옮기고 위치도 옮겨준다.
//                room[r][c] = room[r+_dr][c+_dc];
//                r += _dr;
//                c += _dc;
//            }
//            room[r][c] = 0; // 공기청정기는 먼지없는 바람을..
            airConditionWind(lowerAirCond, 1, 0, -1, rLen, upperAirCond);
        }

        int dustSum = 0;
        for (int i = 0; i<rLen; i++){
            for (int j = 0; j<cLen; j++){
                dustSum += room[i][j];
            }
        }

        // 디버깅용 출력
//        for (int i = 0; i<rLen; i++){
//            System.out.println(Arrays.toString(room[i]));
//        }

        // 공기 청정기로 -2 된 부분을 처리하기 위해 +2한 총 먼지 수를 출력
        System.out.println(dustSum+2);
    }

    // 공기 청정기 위치, 이동 변화량 r / c, 공기 청정기 바람이 반시계(1)인지 시계(-1)인지, R의 범위
    static void airConditionWind(int airConditionIdx, int dr, int dc, int mod, int topR, int lowR){
        int r = airConditionIdx + dr;   // 위치
        int c = 0;
        while(!(r == airConditionIdx && c == 1)){
            // 탐색할 수 없는 위치를 탐색하려고 하면
            if (r+dr <= lowR || topR <= r+dr || cLen <= c+dc){
                // 방향을 바꿔준다. (왜 이렇게 되는지는 위의 달팽이 문제 링크 참고)
                int temp = dr;
                dr = dc * mod;
                dc = temp * -mod;
            }

            // 먼지를 옮기고 위치도 옮겨준다.
            room[r][c] = room[r+dr][c+dc];
            r += dr;
            c += dc;
        }
        // 공기청정기는 먼지없는 바람을 내뿜는다.
        room[r][c] = 0;
    }
}
