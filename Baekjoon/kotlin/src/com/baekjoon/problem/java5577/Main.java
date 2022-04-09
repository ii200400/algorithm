// 문제 링크 : https://www.acmicpc.net/problem/5577
// 제출 공유 링크 : http://boj.kr/cfceb64d8ff54019a5230513a7042399
// 백준 RBY팡!

// 음.. 완전탐색 시뮬레이션 문제였다.
// 어떻게해야 깔끔하게 반복을 돌 수 있는지만 15분 넘게 생각한 것 같다;;

package com.baekjoon.problem.java5577;

import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 공의 수
        int[] balls = new int[n];   // 위치별 공의 색상

        // 공의 색상 초기화
        for (int i = 0; i<n; i++){
            balls[i] = sc.nextInt();
        }

        // 정답 변수
        int answer = n;

        // 각 위치의 공마다 색상을 바꿔본다.
        for (int i = 0; i<n; i++){
            int originColor = balls[i];

            for (int j = 1; j<=3; j++) {
                // 공의 색상이 바뀌지 않으면 패스
                if (originColor == j)
                    continue;

                // 공을 다른 색상으로 바꾸고 게임을 진행해본다.
                balls[i] = j;
                int popCnt = popBalls(balls, i);

                // 남은 공을 적절하게 저장한다.
                answer = Math.min(answer, n-popCnt);
            }

            // 원래 색상으로 되돌린다.
            balls[i] = originColor;
        }

        // 소멸하지 않고 남아있는 공의 최솟값
        System.out.println(answer);
    }

    static int popBalls(int[] balls, int start){
        int totalCnt = 0;   // 총 터진 공들의 수
        int upPoint = start;    // 점점 수가 작아지는 포인터
        int downPoint = start+1;    // 점점 커지는 포인터

        do{
            int cnt = 0;    // 연속한 공의 수
            int color = balls[upPoint]; // 연속한 공의 색상

            // 위로 연속한 공의 개수를 센다.
            for (; upPoint >= 0 && balls[upPoint] == color; upPoint--, cnt++){}

            // 아래로 연속한 공의 개수를 센다.
            for (; downPoint < n && balls[downPoint] == color; downPoint++,  cnt++){}


            // 터질 정도로 공이 없다면 반복문 탈출
            if (cnt <= 3)
                break;

            // 공이 터지면 터진 공들을 더하고 계속해서 게임을 진행
            totalCnt+= cnt;
            
            // 포인터 중 하나라도 범위를 벗어나면 반복문 탈출
        }while(upPoint >= 0 && downPoint < n);

        // 총 터진 공들의 수 반환
        return totalCnt;
    }
}
