// 문제 링크 : https://www.acmicpc.net/problem/15649
// 제출 공유 링크 : http://boj.kr/36c59d71a44b4802b66dfd74bd1b3eb4

// 교수님이 기초 다지기 문제로 추천하신 문제들 중 하나.
// a형에 좋은 문제들은 아까워서 시험보기 전에 풀어보라고 하셨다..만 본인은 a형은 통과했으니 바로 풀어도 되는건가?
// 음.. 아무리봐도 그냥 순열 문제이다. 심지어 강의에서 풀어주기까지 했는걸;;

package com.baekjoon.problem.java15649;

import java.util.Scanner;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[] seq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 총 숫자
        m = sc.nextInt();   // 순열 개수
        visited = new boolean[n];   // 방문 여부 배열
        seq = new int[m];   // 순열 배열

        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        dfs(0);
    }

    // 순열
    static void dfs(int cnt){
        // m개를 선택하면
        if (cnt == m){
            // 선택한 순서대로 출력하고 돌아간다.
            for (int i = 0; i<m; i++){
                System.out.print(seq[i] + " ");
            }
            System.out.println();
            return;
        }

        // 모든 숫자를 탐색하는데
        for (int i = 0; i<n; i++){
            // 현재 순열에 들어가있지 않은 숫자라면
            if (visited[i])
                continue;

            // 해당 숫자를 순열에 넣고 진행해보고
            visited[i] = true;
            seq[cnt] = i+1;
            dfs(cnt+1);

            // 진행이 끝나면 다시 순열에서 뺀다.
            visited[i] = false;
        }
    }
}
