// 문제 링크 : https://www.acmicpc.net/problem/15654
// 제출 공유 링크 : http://boj.kr/953d1a6be3a346389ecf0a9a186b0335

// 교수님이 기초 다지기 문제로 추천하신 문제들 중 하나.
// n과 m 시리즈 푸는 중..

package com.baekjoon.problem.java15654;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static boolean[] visited;
    static int[] seq, numbers;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 총 숫자
        m = sc.nextInt();   // 순열 개수
        visited = new boolean[n];   // 방문 여부 배열
        seq = new int[m];   // 순열 배열
        numbers = new int[n];   // 자연수 배열

        // 자연수 배열 초기화
        for (int i = 0; i<n; i++){
            numbers[i] = sc.nextInt();
        }
        // 수열이 사전순으로 증가하는 순서로 출력해야 하므로
        Arrays.sort(numbers);

        // N개의 자연수 중에서 중복 없이 M개를 고른 수열
        dfs(0);

        bw.close();
    }

    // 순열
    static void dfs(int cnt) throws IOException {
        // m개를 선택하면
        if (cnt == m){
            // 선택한 순서대로 출력하고 돌아간다.
            for (int i = 0; i<m; i++){
                bw.write(seq[i] + " ");
            }
            bw.newLine();
            return;
        }

        // 모든 숫자를 탐색하는데
        for (int i = 0; i<n; i++){
            // 현재 순열에 들어가있지 않은 숫자라면
            if (visited[i])
                continue;

            // 해당 숫자를 순열에 넣고 진행해보고
            visited[i] = true;
            seq[cnt] = numbers[i];
            dfs(cnt+1);

            // 진행이 끝나면 다시 순열에서 뺀다.
            visited[i] = false;
        }
    }
}
