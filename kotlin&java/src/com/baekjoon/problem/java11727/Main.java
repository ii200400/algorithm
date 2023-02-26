// 문제 링크 : https://www.acmicpc.net/problem/11727
// 제출 공유 링크 : https://www.acmicpc.net/problem/11727
// 백준 2×n 타일링 2

// 2×n 타일링 과 크게 다른 점이 없어서 그대로 진행하였다.

package com.baekjoon.problem.java11727;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n+1];

        // dp 초기화
        dp[0] = 1;
        dp[1] = 1;

        // dp 계산
        for (int i = 2; i<=n; i++){
            dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        }

        // 마지막 dp 출력
        System.out.println(dp[n]);
    }
}
