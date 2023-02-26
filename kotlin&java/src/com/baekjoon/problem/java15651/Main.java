// 문제 링크 : https://www.acmicpc.net/problem/15651
// 제출 공유 링크 : http://boj.kr/2961659c1c1b4ea089a77c826c8babe5

// 교수님이 기초 다지기 문제로 추천하신 문제들 중 하나.
// 음.. 설명 상 중복순열을 구현하라는 문제 같다......
// 귀찮아서 이전 n과m 문제를 복붙해야겠다;;

// 아.. 문자가 너무 긴지 시간초과가 났다, bufferedWriter를 사용해봐야겠다.

package com.baekjoon.problem.java15651;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] seq;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 총 숫자
        m = sc.nextInt();   // 중복순열 개수
        seq = new int[m];   // 중복순열 배열

        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 (중복가능)
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
        for (int i = 0; i<n; i++){
            // 해당 숫자를 순열에 넣고 진행해본다.
            seq[cnt] = i+1;
            dfs(cnt+1);
        }
    }
}
