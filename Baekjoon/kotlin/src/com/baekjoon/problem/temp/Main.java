package com.baekjoon.problem.temp;

import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        // [마지막에 노란색으로 칠한 것들의 수, 마지막에 파란색으로..]
//        int[][] memo = new int[n][2];   // 색칠 배열
//        memo[0] = new int[]{1, 1};
//
//        for (int i = 1; i<n; i++){
//            memo[i][0] = memo[i-1][0]+memo[i-1][1];
//            memo[i][1] = memo[i-1][0];
//        }
//
//        System.out.println(memo[n-1][0] + memo[n-1][1]);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n == 1){    // 예외 처리
            System.out.println(2);
            return;
        }else if (n == 2){
            System.out.println(5);
            return;
        }

        // [마지막이 파란 혹은 노란 막대인 경우, 마지막이 빨간 막대인 경우]
        int[] memo = new int[n];   // 색칠 배열
        memo[0] = 2;
        memo[1] = 5;

        for (int i = 2; i<n; i++){
            memo[i] = memo[i-1] * 2 + memo[i-2];
        }

        System.out.println(memo[n-1]);
    }
}
