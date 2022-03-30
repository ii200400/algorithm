// 문제 링크 : https://www.acmicpc.net/problem/15664
// 제출 공유 링크 : http://boj.kr/294007cda21142dfaa991bf7ae4318a7

// 교수님이 기초 다지기 문제로 추천하신 문제들 중 하나.
// n과 m 시리즈 푸는 중..

package com.baekjoon.problem.java15664;

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
        m = sc.nextInt();   // 조합 개수
        seq = new int[m];   // 조합 배열
        numbers = new int[n];   // 자연수 배열

        // 자연수 배열 초기화
        for (int i = 0; i<n; i++){
            numbers[i] = sc.nextInt();
        }
        // 수열이 사전순으로 증가하는 순서로 출력해야 하므로
        Arrays.sort(numbers);

        // N개의 자연수 중에서 중복 없이 M개를 고른 수열 중 오름차순 인것
        // 중복되는 수열은 하나만 출력한다.
        dfs(0, 0);

        bw.close();
    }

    // 조합
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
        int temp = 0;   // 직전에 선택한 cnt 번째 숫자 (중복 숫자로 인한 중복 수열 방지)
        for (int i = idx; i<n; i++){
            // 해당 자리에서 이전에 선택했던 숫자와 같은 숫자라면 생략한다.
            if (temp == numbers[i])
                continue;

            // 해당 숫자를 조합에 넣고 진행해본다.
            seq[cnt] = numbers[i];
            temp = numbers[i];
            dfs(cnt+1, i+1);
        }
    }
}
