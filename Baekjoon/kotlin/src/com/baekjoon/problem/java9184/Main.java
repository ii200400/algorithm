// 문제 링크 : https://www.acmicpc.net/problem/9184
// 제출 공유 링크 : http://boj.kr/f0b7684d044d4e2ab8ac9ac807aaa63d
// 백준 신나는 함수 실행

// ???
// 무슨 문제인가 했더니 DP문제이다.
// 마치 피보나치 수열처럼 단순히 재귀를 쓰면 너무 연산이 반복되는 것이 많으니 dp로 풀라는 내용

package com.baekjoon.problem.java9184;

import java.util.Scanner;

public class Main {
    static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            // 세 정수가 모두 -1인 경우는 입력의 마지막
            if (a == -1 && b == -1 && c == -1){
                break;
            }

            // 예외처리
            if (a <= 0 || b <= 0 || c<= 0){
                System.out.printf("w(%d, %d, %d) = 1%n", a, b, c);
                continue;
            }


            if (a > 20 || b > 20 || c > 20){
                dp = new int[21][21][21];    // 3차원 dp..
                w(20, 20, 20);
                System.out.printf("w(%d, %d, %d) = %d%n", a, b, c, dp[20][20][20]);
            }else{
                dp = new int[a+1][b+1][c+1];
                w(a, b, c);
                System.out.printf("w(%d, %d, %d) = %d%n", a, b, c, dp[a][b][c]);
            }
        }
    }

    static void w(int a, int b, int c){
        // 세 숫자 중 하나라도 0이면 1 반환
        if (a <= 0 || b <= 0 || c <= 0) {
            dp[a][b][c] = 1;
            return;
        }

        // 조건에 따라서 적절한 연산 진행
        // dp의 특정 위치에 아직 적절한 값이 입력되지 않았다면..
        // 재귀로 파고 들어가서 연산 시 적절한 값이 있을 때까지 재귀로 파고 들어가서 연산한다.
        // 탑다운 방식..
        if (a < b && b < c){
            // 값을 모른다면 재귀호출!
            if (dp[a][b][c-1] == 0)
                w(a, b, c-1);   // 값을 알아온다. (dp에 저장한다)
            if (dp[a][b-1][c-1] == 0)
                w(a, b-1, c-1);
            if (dp[a][b-1][c] == 0)
                w(a, b-1, c);

            // 값을 모두 알고있으므로 연산
            dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
        }else{  // 위와 같은 방법..
            if (dp[a-1][b][c] == 0)
                w(a-1, b, c);
            if (dp[a-1][b-1][c] == 0)
                w(a-1, b-1, c);
            if (dp[a-1][b][c-1] == 0)
                w(a-1, b, c-1);
            if (dp[a-1][b-1][c-1] == 0)
                w(a-1, b-1, c-1);

            dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
        }
    }
}
