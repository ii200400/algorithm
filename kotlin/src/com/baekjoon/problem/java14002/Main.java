// 문제 링크 : https://www.acmicpc.net/problem/14002
// 제출 공유 링크 : http://boj.kr/d44edda18aa7445a93fd05bc3043ef10
// 백준 가장 긴 증가하는 부분 수열 4

package com.baekjoon.problem.java14002;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] disjoint;
    static int[] seq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 수열의 크기
        seq = new int[n];  // 수열
        int[] dp = new int[n];    // seq[i]로 끝나는 최장 증가 부분 수열 길이 (LIS가 있으므로 사실 필요 없다.)
        disjoint = new int[n]; // seq[i]이 포함된 증가 부분 수열에서 이전 값이 저장된 seq 인덱스 (서로소 집합의 root를 찾아갈 때 사용하는 배열과 같은 역할)

        // 수열 초기화, LIS 초기화
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
            disjoint[i] = i;
        }

        // dp 초기화
        Arrays.fill(dp, 1);

        // LIS 연산 진행
        int maxLen = 1, maxLenIdx = 0;
        for (int i = 1; i<n; i++){
            for (int j = 0; j<i; j++){
                // 최장 증가 부분 수열의 조건과 같이 진행
                if (seq[i] > seq[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    disjoint[i] = j;    // 인덱스 관리가 꼭 필요하다.
                }
            }

            // 현재까지의 최장 증가 부분 수열 길이를 저장하고 마지막 수의 인덱스를 기억한다.
            if (dp[i] > maxLen){
                maxLen = dp[i];
                maxLenIdx = i;
            }
        }

        // 최장 증가 부분 수열의 길이와 각 수들 출력
        findRoot(maxLenIdx, 1);
    }

    // disjoint 에서의 root를 구하는 배열을 활용하여 이진트리의 후위순회의 방식으로 값을 출력한다.
    static void findRoot(int idx, int cnt){
        // 수열의 첫번째 값이라면 값을 출력하고 되돌아간다.
        if (disjoint[idx] == idx) {
            System.out.println(cnt);
            System.out.print(seq[idx] + " ");
            return;
        }

        // 이전 수를 찾아가고
        findRoot(disjoint[idx], cnt+1);
        // 자신의 값을 출력한다.
        System.out.print(seq[idx] + " ");
    }
}

