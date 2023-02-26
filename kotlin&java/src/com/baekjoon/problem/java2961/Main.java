// 문제 링크 : https://www.acmicpc.net/problem/2961
// 제출 공유 링크 : http://boj.kr/6c2fa4c2698f45bf8291952721c04d8a

// 그냥 부분 집합이긴 한데.. 물만 있는 경우를 어떻게 빼주어야 하나..

package com.baekjoon.problem.java2961;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 초기화 진행
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 재료 수
        answer = Integer.MAX_VALUE;

        // 재료 배열 초기화
        materials = new int[n][2];
        isSelected = new boolean[n];
        for (int i = 0; i<n; i++){
            materials[i] = new int[]{ sc.nextInt(), sc.nextInt() };
        }

        dfs(0, 1, 0);

        System.out.println(answer);
    }

    static boolean waterFlag = true;
    static int n, answer;
    static int[][] materials;
    static boolean[] isSelected;

    // 부분집합 메서드
    static void dfs(int cnt, int sour, int bit){
        if (cnt == n){
            // 단순히 물을 빼기 위함.. 물은 요리가 아니니까..
            if (waterFlag){
                waterFlag = false;
                return;
            }

            // 신맛과 쓴맛의 차이가 작다면 저장
            answer = Math.min(answer, Math.abs(sour-bit));
            return;
        }

        // 재료를 선택하지 않고 진행
        dfs(cnt+1, sour, bit);
        // 선택을 하고 진행
        dfs(cnt+1, sour*materials[cnt][0], bit+materials[cnt][1]);
    }
}
