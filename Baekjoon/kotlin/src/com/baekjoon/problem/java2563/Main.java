// 문제 링크 : https://www.acmicpc.net/problem/2563
// 제출 공유 링크 :http://boj.kr/af6571d60d8a440886a3b67d11d98bc7

// 어.. 모르겠다..
// 이차원 배열로 보드를 만들고 색종이가 덮은 부분을 1이든 false든 기록하는 방식으로 진행해보려고 한다.
// 식을 만들어 계산하는 방식으로 푸는 것은 내 머리로 절대 안될 것 같다..

package com.baekjoon.problem.java2563;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] board = new boolean[100][100]; // 종이를 붙일 보드. 종이가 없으면 false 있으면 true;

        int n = sc.nextInt(); // 색종이 수
        for (int i = 0; i<n; i++){

            // 색종이를 붙인 위치 (왼쪽 아래)
            int startR = sc.nextInt();
            int startC = sc.nextInt();
            // 색종이가 덮은 위치를 보드에 기록
            for(int j = 0; j<10; j++){
                for(int k = 0; k<10; k++){
                    board[startR+j][startC+k] = true;
                }
            }
        }

        // 보드에 적힌 true 세기
        int trueNum = 0;
        for (int i = 0; i<100; i++){
            for (int j = 0; j<100; j++){
                if (board[i][j]) trueNum += 1;
            }
        }

        // 출력
       System.out.println(trueNum);
    }
}
