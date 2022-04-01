// 문제 링크 : https://www.acmicpc.net/problem/17070
// 제출 공유 링크 : http://boj.kr/f8de1e1bbb6440818bb2c45af02e90dc

// 이건.. 그.. 초등학생인가 중학생때 격자나 대각선 있는 그림의 (1, 1)에서 (n, m)까지가는 경우의 수를 구하는
// 그 문제의 변형 아닌가..? 손으로 풀었던 기분이 나는데..
// 아.. 문제 이해를 잘못했다;; 으아ㅏㅏㅏㅏ
// 잘 보니.. 1, 2열은 가장 처음 파이프를 제외하고 어느 상황에서도 경우의 수가 [0, 0, 0]이다;;

// 뭔가 햇갈려서;; 해결이 늦어졌다;;

package com.baekjoon.problem.java17070;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // [각 위치별][마지막에 쓰인 파이피가 가로, 대각선, 세로일 경우의 수]
        int[][] dp = new int[n][3];   // dp 배열
        boolean[][] wall = new boolean[n][n];   // 벽 배열

        // 벽 초기화
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                wall[i][j] = sc.nextInt() == 1;
            }
        }

        // dp 배열 초기화
        dp[1] = new int[]{1, 0, 0};
        for (int i = 2; i<n; i++){
            if (!wall[0][i])
                dp[i] = new int[]{dp[i-1][0], 0, 0};
        }

        int[][] nextDp; // 다음 dp 배열
        for (int i = 1; i<n; i++){
            nextDp = new int[n][3];// 초기화

            for (int j = 2; j<n; j++){
                nextDp[j] = new int[]{
                        // (i,j-1)가로/대각선 경우의 수 총합
                        wall[i][j]? 0:nextDp[j-1][0]+nextDp[j-1][1],
                        // (i-1,j-1)가로/대각선/세로 경우의 수 총합
                        wall[i][j-1] || wall[i][j] || wall[i-1][j]? 0:dp[j-1][0]+dp[j-1][1]+dp[j-1][2],
                        // (i-1,j) 대각선/세로 경우의 수 총합
                        wall[i][j]? 0:dp[j][1]+dp[j][2]
                };
            }

            // 새롭게 만든 행으로 갱신
            dp = nextDp;
        }

        // 마지막 위치의 경우의 수 출력
        System.out.println(dp[n-1][0]+dp[n-1][1]+dp[n-1][2]);
    }
}
