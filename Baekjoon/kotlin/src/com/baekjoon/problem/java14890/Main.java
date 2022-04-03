// 문제 링크 : https://www.acmicpc.net/problem/14890
// 제출 공유 링크 : http://boj.kr/ba9d3e030d6346509032e2e551c4716f
// 백준 경사로

// 노가다.. ㅇ음.. 그냥 조건 별로 적절하게 계산하고 연산하면 된다.

// 어우..; 거의 삼성 a형 문제는 되는것 같은데;; 구현이 많이 어려웠다;;
// 따져야 할 것이 너무 많아서;;

package com.baekjoon.problem.java14890;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 지도 크기
        int l = sc.nextInt();   // 경사로 길이
        int[][] map = new int[n+2][n+2];    // 지도 배열 (예외처리를 위해 크기 +2)
        boolean[][] isRamp = new boolean[n+2][n+2]; // 경사로 설치 여부

        // 지도 초기화 (주변을 -1로 초기화 예외처리를 좀 쉽게 하려고)
        Arrays.fill(map[0], -1);
        Arrays.fill(map[n+1], -1);
        for (int i = 1; i<=n; i++){
            map[i][0] = -1;
            map[i][n+1] = -1;
            for (int j = 1; j<=n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        // 가로 경사로를 
        loadR:for (int i = 1; i<=n; i++) {
            // 한 칸씩 탐색해보는데
            int j;
            for (j = 1; j<n; j++) {
                
                // 다음 칸과 현재 칸의 높이 차이가 1이라면(현재 칸이 더 높음)
                int hDiff = map[i][j] - map[i][j + 1];
                if (hDiff == 1) {
                    int height = map[i][j + 1];

                    // 탐색 진행방향으로 l만큼을 탐색하면서
                    for (int k = 1; k <= l; k++) {
                        // 각 칸의 높이가 같지 않거나 이미 경사로가 놓여져 있다면 다음 줄을 살펴보러가고
                        if (map[i][j+k] != height || isRamp[i][j+k]){
                            continue loadR;
                        }
                        // 그렇지 않으면 경사로를 잘 설치하고 지나간다.......?
                        // 이거.. 백준 테스트 케이스가.. 잘못되어있나본데..? 내가 오해하고 있나?
                        isRamp[i][j+k] = true;
                    }

                    // 다음 칸과 현재 칸의 높이 차이가 1이라면(현재 칸이 더 낮음)
                }else if (hDiff == -1){
                    int height = map[i][j];

                    // 탐색 진행방향의 반대방향으로 l만큼을 탐색하면서
                    for (int k = 0; k < l; k++) {
                        // 각 칸의 높이가 같지 않거나 이미 경사로가 놓여져 있다면 다음 줄을 살펴보러가고
                        if (map[i][j-k] != height || isRamp[i][j-k]){
                            continue loadR;
                        }
                        // 그렇지 않으면 경사로를 잘 설치하고 지나간다
                        isRamp[i][j-k] = true;
                    }
                }else if(hDiff != 0){
                    // 만약 현재 칸과의 차이가 1이상 차이나면 다음 줄을 탐색한다.
                    continue loadR;
                }
            }

//            System.out.println("r"+i + " " + j);
            answer++;
        }

        // 세로 경사로도 가로 경사로 탐색과 같이 살펴본다.
        // 주석은 생략한다.
        isRamp = new boolean[n+2][n+2];
        loadC:for (int i = 1; i<=n; i++) {
            int j;
            for (j = 1; j < n; j++) {
                int hDiff = map[j][i] - map[j+1][i];
                if (hDiff == 1) {
                    int height = map[j + 1][i];

                    for (int k = 1; k <= l; k++) {
                        if (map[j + k][i] != height || isRamp[j + k][i]) {
                            continue loadC;
                        }
                        isRamp[j + k][i] = true;
                    }

                }else if (hDiff == -1){
                    int height = map[j][i];

                    for (int k = 0; k < l; k++) {
                        if (map[j - k][i] != height || isRamp[j - k][i]) {
                            continue loadC;
                        }
                        isRamp[j - k][i] = true;
                    }
                } else if(hDiff != 0){
                    continue loadC;
                }
            }

//            System.out.println("c"+i + " " + j);
            answer++;
        }

        System.out.println(answer);
    }
}
