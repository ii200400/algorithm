// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh

// 음..? dfs문제라고 들은 것 같은데 잘못들었나보다..

package com.ssafy.swea.java1210;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String args[]) throws Exception {
        // 빠른 입출력을 위해 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10; // 테스트 케이스는 10개로 고정

        // 테스트 케이스 만큼 반복
        for (int test_case = 1; test_case <= T; test_case++) {
            // 초기화
            int n = Integer.parseInt(br.readLine()); // 테스트 케이스 번호 (안 쓴다.)
            int[][] map = new int[100][102]; // 양 옆에 벽을 세우기 위해 길이가 2 더 길다.
            int r = 99, c = 0; // 숫자 2의 위치
            for (int i = 0; i < 100; i++) {
                // 입력 받기
                String[] line = br.readLine().split(" ");

                for (int j = 1; j < 101; j++) {
                    map[i][j] = line[j-1].charAt(0) - '0';
//                    if (map[i][j] == 2){
//                        // 도착해야하는 곳 위치 저장
//                        r = i;
//                        c = j; // 벽으로 인해서 +1
//                    }
                }
            }

            // 속도 개선
            for (int j = 1; j < 101; j++) {
                if (map[99][j] == 2){
                    // 도착해야하는 곳 위치 저장, r은 항상 99의 인덱스를 가진다.
                    c = j;
                }
            }

            // 숫자 2가 있던 위치부터 맨 위까지 역으로 탐색 시작
//            while(r != 0){
//                // 현재 길을 막고
//                map[r][c] = 0;
//                // 갈 수 있는 곳으로 진행한다. (왼쪽이나 오른쪽길을 윗길보다 우선)
//                if (map[r][c+1] == 1) c += 1; // 오른쪽으로
//                else if (map[r][c-1] == 1) c -= 1; // 왼쪽으로
//                else r -= 1;   // 윗쪽으로
//            }

            // 속도 개선
            while(r != 0){
                // 갈 수 있는 곳으로 진행한다. (왼쪽이나 오른쪽길을 윗길보다 우선)
                if (map[r][c + 1] == 1) { // 오른쪽으로 쭉 이동
                    do {
                        c += 1;
                    }while (map[r][c + 1] == 1);

                }else if (map[r][c - 1] == 1){ // 왼쪽으로 쭉 이동
                    do {
                        c -= 1;
                    } while (map[r][c - 1] == 1);
                }

                r -= 1;   // 윗쪽으로 한 칸 이동
            }

            // 벽 때문에 1칸 오른쪽으로 간 위치 다시 돌려두기
            bw.write( String.format("#%d %d\n", test_case, c-1));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}


