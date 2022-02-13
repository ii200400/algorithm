// 문제 링크 : https://www.acmicpc.net/problem/1780
// 제출 공유 링크 : http://boj.kr/f4d19fb0deec4bf6b6405baa6b0bd33e

// 단순히 재귀를 이용해서 풀었다.

package com.baekjoon.problem.java1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] paper;   // 종이의 숫자 정보를 담는 배열
    static int[] answer = new int[] {0,0,0}; // -1 0 1 종이 갯수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 초기화
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i<n; i++){
            String[] line = br.readLine().split(" ");
            for (int j = 0; j<n; j++)
                paper[i][j] = Integer.parseInt(line[j]);
        }

        // 종이 탐색 시작
        dfs(0,n,0,n);

        // 정답 출력
        for (int num: answer){
            System.out.println(num);
        }
    }

    // 재귀
    static void dfs(int rStart, int rEnd, int cStart, int cEnd){ // 자른 종이의 가로 인덱스, 세로 인덱스 범위
        int num = paper[rStart][cStart]; // 첫번째 숫자
        boolean flag = true; // 종이가 특정 숫자로만 이루어졌는지 확인의 위한 변수

        // 종이 조각의 첫번째 숫자와 나머지 숫자들이 모두 같은지 탐색
        search: for (int r = rStart; r<rEnd; r++){
            for (int c = cStart; c<cEnd; c++){

                // 종이의 숫자가 다르면 flag를 false로 바꾸고 이중반복문 탈출
                if (paper[r][c] != num){
                    flag = false;
                    break search;
                }

            }
        }

        if (flag){ // 특정 숫자만 적힌 종이라면 결과값을 조작하고 돌아간다.
            if (num == -1) answer[0] += 1;
            else if (num == 0) answer[1] += 1;
            else answer[2] += 1;
            return;
        }

        // 그렇지 않다면 종이를 쪼갠다.
        int len = (rEnd-rStart)/3; // 자른 종이의 길이
        // 자른 종이의 크기 별로 다시 탐색해 나간다.
        for (int r = rStart; r<rEnd; r+=len){
            for (int c = cStart; c<cEnd; c+=len) {
                dfs(r, r+len, c, c+len);
            }
        }

    }
}
