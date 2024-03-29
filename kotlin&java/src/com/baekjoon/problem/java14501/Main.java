// 문제 링크 : https://www.acmicpc.net/problem/14501
// 제출 공유 링크 : http://boj.kr/75df0f44d41e4a6684221f2d0cf4d260

// 이전에 풀었던 문제인데 기본적인 DP문제이기도 하고 DP로 문제 푼지 꽤 되어서 DP로 풀 것이다.

// 다른 알고리즘 팀원은 계산을 역순으로(n~0)구하기도 하였는데
// 한 줄? 정도 더 짧았다, 그런데 설명은 훨씬 어려웠다;;
// 팀원 코드 링크 : https://lab.ssafy.com/dudtjs972/algorithmstudy/-/blob/master/20220330/%ED%87%B4%EC%82%AC/BJ_0330_14501_%ED%87%B4%EC%82%AC_%EC%B5%9C%EC%9E%AC%ED%98%84.java
// 어.. 저 링크가 로그인 없이도 볼 수 있는지 모르겠다;;

package com.baekjoon.problem.java14501;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 상담 수
        int[][] works = new int[n][2];  // 상담 정보(기간과 수익) 배열
        // n일까지의 상담 진행 후 최대 이익이 n+1일에 적히는 방식 + 예외처리로 크기 +2
        int[] maxProfit = new int[n+2];   // 날짜별 가장 수익이 큰 경우 저장
        int answer = 0; // 최대 이익

        // 상담 정보 배열 초기화
        for (int i = 0; i<n; i++){
            works[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        // 날짜 별로 가장 이익이 많은 경우를 계산한다.
        for (int i = 1; i<=n; i++){
            // 이전 날과 현재 날의 이익을 확인하고 더 큰 값으로 저장한다.
            maxProfit[i] = Math.max(maxProfit[i], maxProfit[i-1]);

            // 해당 날짜의 상담이 진행 가능한지 확인하고
            int day = i+works[i-1][0];
            if (day > n+1)
                continue;

            // 진행한다는 가정을 해보고 나올 수 있는 이익이 해당 일에 이미 적힌 이익보다 크면 저장한다.
            maxProfit[day] = Math.max(maxProfit[day], maxProfit[i]+works[i-1][1]);
        }

//        System.out.println(Arrays.toString(maxProfit));
        // n번째 날 혹은 n+1번째 날 중 더 큰 수를 출력한다.
        System.out.println(Math.max(maxProfit[n], maxProfit[n+1]));

    }
}
