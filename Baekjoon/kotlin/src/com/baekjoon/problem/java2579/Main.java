// 문제 링크 : https://www.acmicpc.net/problem/2579
// 제출 공유 링크 : http://boj.kr/e41a636640e046c68efbdf0144ecd63d
// 백준 계단 오르기

// 학교 자료구조 시간때 들은 문제! 드디어 풀어본다!
// 아주 기본적인 DP문제라고 하셨던 기억이 있다!
// 계단별로, 최근 오른 계단 수 별로 최대값을 저장하는 메모이제이션/DP로 해결할 예정이다.

// 의도치않게 본인이 다른 사람들과 다른 방식으로 풀어버렸다;
// 이전에는 분명히 method2와 같이 푼 것 같은데, 지금은 method1과 같이 풀었다.
// 둘다 dp를 활용하지만 2는 dp가 단일배열이고 1은 이중배열이다.

// 1을 이중배열로 푼것은 dp에 상태가 하나 더 추가되었기 때문인데,
// 연속으로 1칸을 못 올라가는 조건때문에 1칸을 이미 오른 상태와 2칸을 오른 상태로 나누었기 때문..

package com.baekjoon.problem.java2579;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        method1();
        method2();
    }

    static void method1(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 계단 수
        // 편의상 크기 +1
        int[][] maxPoints = new int[n+1][2];  // 계단별 최대 점수 (계단을 얼마나 연속으로 올랐는지에따라 0, 1로 나뉜다.)
        int[] points = new int[n+1];  // 각 계단의 점수

        // 각 계단의 점수 초기화
        for (int i = 1; i<=n; i++){
            points[i] = sc.nextInt();
        }

        maxPoints[1] = new int[]{points[1], points[1]};    // 최대점수 초기화
        for (int i = 2; i<=n; i++){
            // 한 계단 전의 계단에서 오른 계단 2개일 때 + 현 계단 점수를
            // 현재 계단에 오른 계단 1개일 때에 저장한다.
            maxPoints[i][0] = maxPoints[i-1][1] + points[i];

            // 두 계단 전의 계단에서 오른 계단 1개일 때
            // 두 계단 전의 계단에서 오른 계단 2개일 때
            // 중 최대 값 + 현 계단 점수를 현재 계단에 오른 계단 2개일 때에 저장한다.
            int max = Math.max(maxPoints[i-2][0], maxPoints[i-2][1]);
            maxPoints[i][1] = max + points[i];
        }
//        System.out.println(Arrays.deepToString(maxPoints));

        // 마지막 계단의 가장 높은 점수 출력
        System.out.println(Math.max(maxPoints[n][0], maxPoints[n][1]));
    }

    static void method2(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 계단 수
        // 편의상 크기 +1
        int[] dp = new int[n+1];  // 계단별 최대 점수
        int[] points = new int[n+1];  // 각 계단의 점수

        // 각 계단의 점수 초기화
        for (int i = 1; i<=n; i++){
            points[i] = sc.nextInt();
        }

        // 예외처리
        dp[1] = points[1];
        if (n == 1){
            System.out.println(dp[1]);
            return;
        }
        dp[2] = points[1]+points[2];
        if (n == 2){
            System.out.println(dp[2]);
            return;
        }

        // dp 연산
        // 둘 중에서(세 계단전 가장 높은 점수 + 한 계단전 점수, 두 계단전 가장 높은 점수)더 큰 것을 선택해서 저장한다.
        for (int i = 3; i<=n; i++){
            dp[i] = Math.max(dp[i-3]+points[i-1], dp[i-2])+points[i];
        }

        // 마지막 dp 출력
        System.out.println(dp[n]);
    }
}
