// 문제 링크 : https://www.acmicpc.net/problem/13300
// 제출 공유 링크 : http://boj.kr/baa3b8309ec845b291bf750414e57986

package com.baekjoon.problem.java13300;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 남/여 학생별 학년 수, 0학년은 비우기 위해 크기 7로 설정
        int[][] students = new int[2][7];
        int n = sc.nextInt();   // 총 학생 수
        int k = sc.nextInt();   // 방의 최대 인원 수

        // 입력값으로 초기화 진행
        for (int i = 0; i<n; i++){
            students[sc.nextInt()][sc.nextInt()] += 1;
        }

        // 각 성별의 학년들 마다
        int rooms = 0;
        for (int[] grades : students){
            for (int studentNum: grades){
                // 필용한 방을 더한다.
                rooms += Math.ceil((double)studentNum/k);
            }
        }

        // 방 개수 출력
        System.out.println(rooms);
    }
}
