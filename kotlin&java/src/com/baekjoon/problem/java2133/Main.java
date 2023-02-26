// 문제 링크 : https://www.acmicpc.net/problem/2133
// 제출 공유 링크 : http://boj.kr/8581607c75ab46ccb5802a788a71ad32
// 백준 타일 채우기

// 어.. dp 문제같은데.. 잘 풀고있는지 모르겠다..

// 아.. 중간에 j를 i로 써서 해맷다.. ^ㅠ^

package com.baekjoon.problem.java2133;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 벽의 가로 길이
        if (n%2 == 1){  // 홀수라면 0을 출력하도록 한다.
            System.out.println(0);
            return;
        }

        int limit = n/2;    // 홀수는 연산을 하지 않으므로 n/2
        int[] dp = new int[limit+1];    // idx*2의 가로길이를 가지는 벽의 타일 설치 경우의 수
        // 경우의 수 초기화
        dp[0] = 1;
        dp[1] = 3;

        // 경우의 수 n/2까지 연산을 진행한다.
        for (int i = 2; i<=limit; i++){
            dp[i] += dp[i-1]*3; // 3*2를 타일로 채우는 방법은 3가지이므로

            // 3*(2*i)를 채우는 방법은 각각 2가지이므로
            // 3*4, 3*6, 3*8... 모두 2가지씩 있다.
            for (int j = 2; j<=i; j++){
                dp[i] += dp[j-2]*2;
            }
        }

        // 3×N 크기의 벽의 경우의 수 출력
        System.out.println(dp[limit]);
    }
}
