// 문제 링크 : https://www.acmicpc.net/problem/2579
// 제출 공유 링크 : http://boj.kr/4fdab2451e954333bf3e22e7a75188ae
// 백준 계단 오르기

// 학교 자료구조 시간때 들은 문제! 드디어 풀어본다!
// 아주 기본적인 DP문제라고 하셨던 기억이 있다!
// 계단별로, 최근 오른 계단 수 별로 최대값을 저장하는 메모이제이션/DP로 해결할 예정이다.

package com.baekjoon.problem.java2579;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 계단 수
        // 편의상 크기 +1
        int[][] maxPoints = new int[n+1][2];  // 계단별 최대 점수 (계단을 얼마나 연속으로 올랐는지에따라 0, 1, 2로 나뉜다.)
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
}
