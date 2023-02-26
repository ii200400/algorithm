// 문제 링크 : https://www.acmicpc.net/problem/1904
// 제출 공유 링크 : http://boj.kr/e0b33ba05ca24207b3a0c66550ea7d1d
// 백준 01타일

// 음.. 이전에 봤던 다른 타일 이라는 이름의 문제와 같은 것 같은데..

package com.baekjoon.problem.java1904;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 수열 길이
        int[] memo = new int[n+1];    // n번째에서의 만들 수 있는 수열의 수 (15746로 나눈 수로 저장)
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i<=n; i++){
            memo[i] = (memo[i-1] + memo[i-2]) % 15746;
        }

        // 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력
        System.out.println(memo[n]);
    }
}
