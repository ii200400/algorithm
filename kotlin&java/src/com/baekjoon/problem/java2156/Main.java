// 문제 링크 : https://www.acmicpc.net/problem/2156
// 제출 공유 링크 : http://boj.kr/124a4c98ba554e1283635e01d19c8575
// 백준 포도주 시식

// 계단 오르기 문제와 대부분 같다.
// 다른 점은 계단 오르기는 n 번째 계단을 꼭 밟은 경우이지만, 이것은 n 번째 포도주는 꼭 안마셔도 된다는 것

package com.baekjoon.problem.java2156;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 포도주 잔 수
        int[] amounts = new int[n+1];   // 각 포도주 잔의 양 배열
        int[] dp = new int[n+1];    // dp 배열

        // 포도주 양 배열 초기화
        for (int i = 1; i<=n; i++){
            amounts[i] = sc.nextInt();
        }

        // 예외처리 (아래 코드로 연산 불가능)
        if (n == 1){
            System.out.println(amounts[1]);
            return;
        }

        // dp 초기화
        dp[1] = amounts[1];
        dp[2] = amounts[1]+amounts[2];
        // dp 연산
        for (int i = 3; i<=n; i++){
            dp[i] = Math.max(dp[i-3]+amounts[i-1]+amounts[i], dp[i-2]+amounts[i]);
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

//        System.out.println(Arrays.toString(dp));
        // n 번째 포도잔까지의 최대값
        System.out.println(dp[n]);
    }
}
