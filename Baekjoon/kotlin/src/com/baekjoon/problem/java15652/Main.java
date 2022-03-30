// 문제 링크 : https://www.acmicpc.net/problem/15652
// 제출 공유 링크 : http://boj.kr/e46596d3c310498ea47e17d80bb4dbd9

// 교수님이 기초 다지기 문제로 추천하신 문제들 중 하나.
// 음.. 설명 상 중복조합을 구현하라는 문제 같다.
// 복붙이 필수가 되었다..

package com.baekjoon.problem.java15652;

import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] seq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 총 숫자
        m = sc.nextInt();   // 조합 개수
        seq = new int[m];   // 중복조합 배열

        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 중 오름차순 인 것들 (중복 가능)
        dfs(0, 0);
    }

    // 중복조합
    static void dfs(int cnt, int idx){
        // m개를 선택했다면
        if (cnt == m){
            // 선택한 순서대로 출력하고 돌아간다.
            for (int i = 0; i<m; i++){
                System.out.print(seq[i] + " ");
            }
            System.out.println();
            return;
        }

        // 모든 숫자를 탐색하는데
        for (int i = idx; i<n; i++){
            // 해당 숫자를 조합에 넣고 진행해본다.
            seq[cnt] = i+1;
            dfs(cnt+1, i);
        }
    }
}
