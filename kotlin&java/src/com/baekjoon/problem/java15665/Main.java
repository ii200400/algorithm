// 문제 링크 : https://www.acmicpc.net/problem/15665
// 제출 공유 링크 : http://boj.kr/51650111421f4640a6d1454f435a7521

// 교수님이 기초 다지기 문제로 추천하신 문제들 중 하나.
// n과 m 시리즈 푸는 중..

package com.baekjoon.problem.java15665;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static int[] seq, numbers;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 총 숫자
        m = sc.nextInt();   // 중복순열 개수
        seq = new int[m];   // 중복순열 배열

        // 자연수 배열 초기화를 위한 전처리 (중복없애려고..;)
        HashSet<Integer> tempSet = new HashSet<>();
        for (int i = 0; i<n; i++){
            tempSet.add(sc.nextInt());
        }
        numbers = new int[tempSet.size()];   // 자연수 배열

        // 자연수 배열 초기화
        Object[] tempArr = tempSet.toArray();
        for (int i = 0; i<numbers.length; i++) {
            numbers[i] = (int) tempArr[i];
        }

        // 수열이 사전순으로 증가하는 순서로 출력해야 하므로
        Arrays.sort(numbers);

        // N개의 자연수 중에서 M개를 고른 수열 (중복 가능)
        dfs(0);

        bw.close();
    }

    // 중복순열
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
        for (int number : numbers) {
            // 해당 숫자를 중복순열에 넣고 진행한다.
            seq[cnt] = number;
            dfs(cnt + 1);
        }
    }
}
