// 문제 링크 : https://www.acmicpc.net/problem/15666
// 제출 공유 링크 : http://boj.kr/a159369213bb41caac609f0f3bf746a5

// 교수님이 기초 다지기 문제로 추천하신 문제들 중 하나.
// n과 m 시리즈 푸는 중..

package com.baekjoon.problem.java15666;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static int[] seq, numbers;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 총 숫자
        m = sc.nextInt();   // 중복조합 개수
        seq = new int[m];   // 중복조합 배열
        numbers = new int[n];   // 자연수 배열

        // 자연수 배열 초기화
        for (int i = 0; i<n; i++){
            numbers[i] = sc.nextInt();
        }
        // 수열이 사전순으로 증가하는 순서로 출력해야 하므로
        Arrays.sort(numbers);

        // N개의 자연수 중에서 M개를 고른 수열 중 오름차순 인것 (중복 가능)
        dfs(0, 0);

        bw.close();
    }

    // 중복조합
    static void dfs(int cnt, int idx) throws IOException {
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
        for (int i = idx; i<n; i++){
            // 해당 숫자를 중복조합에 넣고 진행해본다.
            seq[cnt] = numbers[i];
            dfs(cnt+1, i);
        }
    }
}
