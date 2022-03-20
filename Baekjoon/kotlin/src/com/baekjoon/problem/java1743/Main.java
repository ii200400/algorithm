// 문제 링크 : https://www.acmicpc.net/problem/1743
// 제출 공유 링크 : http://boj.kr/d18b5059b655471d89ca37a362e3c700

package com.baekjoon.problem.java1743;

import java.util.Scanner;

public class Main {
    static boolean[][] trashMap;
    static int[][] trashPos;
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        trashMap = new boolean[sc.nextInt()+2][sc.nextInt()+2]; // 지도 + 벽세우기
        int k = sc.nextInt();   // 쓰레기 개수
        trashPos = new int[k][2];   // 음식물 쓰레기 위치 배열
        for (int i = 0; i<k; i++){
            int r = sc.nextInt(), c = sc.nextInt();
            trashPos[i] = new int[]{r, c};
            trashMap[r][c] = true;
        }

        int answer = 0; // 가장 큰 쓰레기 뭉치 크기
        for (int i = 0; i<k; i++){
            int r = trashPos[i][0], c = trashPos[i][1];
            // 쓰레기가 없는 곳은 생략
            if (!trashMap[r][c])
                continue;
            
            // 현 위치의 쓰레기의
            trashMap[r][c] = false;
            // 주변 쓰레기를 모은다.
            size = 1;   // 쓰레기 뭉치 크기
            trashBall(r, c);

            // 가장 큰 쓰레기 뭉치 크기 저장
            answer = Math.max(answer, size);
        }

        // 가장 큰 쓰레기 뭉치 크기 출력
        System.out.println(answer);
    }

    static int[] dr = new int[] {1, -1, 0, 0};
    static int[] dc = new int[] {0, 0, 1, -1};

    // 쓰레기 더미 크기 계산
    static void trashBall(int r, int c){
        for (int i = 0; i<4; i++){
            // 쓰레기가 없다면 생략
            if (!trashMap[r+dr[i]][c+dc[i]])
                continue;

            // 있다면 방문 확인 후, 크기 +1하고 주변 쓰레기 탐색
            trashMap[r+dr[i]][c+dc[i]] = false;
            size++;
            trashBall(r+dr[i], c+dc[i]);
        }
    }
}
