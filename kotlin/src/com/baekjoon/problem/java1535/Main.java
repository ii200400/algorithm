// 문제 링크 : https://www.acmicpc.net/problem/1535
// 제출 공유 링크(method1) : http://boj.kr/a74618fd9e0c423ba143a7f59df97b0a
// 제출 공유 링크(method2) : http://boj.kr/2c23b1fd41ce4eeabaa60a691595642e
// 백준 안녕

// 어떻게봐도 넵섹문젴ㅋㅋㅋㅋ 1회성 방문이라는 조건을 넣어서 문제 만든것도 재미있다.
// 넵섹문제는 처음이긴한데 이해는 예전부터 하고 있어서 단일배열로 해보겠다.

// 처음 구현해봐서 조금.. 구현을 원활하게 하지는 못했지만 dp로 풀긴 했다!
// method1은 냅색 단일배열로
// method2는 냅색 이중배열로 해결하였다.

package com.baekjoon.problem.java1535;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        method1();
        method2();
    }

    // 냅색 dp 단일배열
    static void method1() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 사람 수
        // 인덱스 21에 56이 저장되어있다면 잃은 체력이 21에 얻은 최대 기쁨이 56인것
        // 100이되면 사망..하므로 배열크기는 100
        int[] dp = new int[100];  // 잃은 체력별 최대 기쁨 배열(DP)
        int[] loseHealth = new int[n];  // 사람 방문별 잃는 체력 배열
        int[] getJoy = new int[n];  // 방문별 얻는 기쁨 배열

        // 체력 배열과 기쁨 배열 초기화
        for (int i = 0; i < n; i++) {
            loseHealth[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            getJoy[i] = sc.nextInt();
        }

        // 넵섹 진행
        for (int i = 0; i < n; i++) {
            int lose = loseHealth[i];
            int joy = getJoy[i];
            // 이전 값을 참고해서 현재 사람을 방문해서 얻는 기쁨을 체력별로 기록한다.
            for (int j = 99; j >= lose; j--) {
                dp[j] = Math.max(dp[j], dp[j - lose] + joy);
            }
//            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[99]);
    }

    // 냅색 dp 이중배열
    static void method2() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 사람 수
        // 인덱스 21에 56이 저장되어있다면 잃은 체력이 21에 얻은 최대 기쁨이 56인것
        // dp의 첫 가로줄은 0인 배열이여야 하고 사람 수만큼의 줄이 있어야 하므로 n+1세로줄 필요, 편의상 다른 배열도 +1
        // 100이되면 사망..하므로 배열크기는 100
        int[][] dp = new int[n + 1][100];  // 잃은 체력별 최대 기쁨 배열(DP)
        int[] loseHealth = new int[n + 1];  // 사람 방문별 잃는 체력 배열
        int[] getJoy = new int[n + 1];  // 방문별 얻는 기쁨 배열

        // 체력 배열과 기쁨 배열 초기화
        for (int i = 1; i <= n; i++) {
            loseHealth[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            getJoy[i] = sc.nextInt();
        }

        // 넵섹 진행
        for (int i = 1; i <= n; i++) {
            int lose = loseHealth[i];
            int joy = getJoy[i];
            // 이전 값을 참고해서 현재 사람을 방문해서 얻는 기쁨을 체력별로 기록한다.
            for (int j = 0; j < 100; j++) {
                if (j < lose) { // 해당 체력을 잃는 것으로는 현재 사람을 절대 만날 수 없다면 이전 값만 복사해온다.
                    dp[i][j] = dp[i-1][j];
                } else {    // 현재 사람을 방문해서 얻을 수 있는 기쁨이 다른 상황보다 더 많은 기쁨을 얻을 수 있으면 저장 그렇지 않으면 그대론
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - lose] + joy);
                }
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[n][99]);
    }
}
