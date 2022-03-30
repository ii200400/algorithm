// 문제 링크 : https://www.acmicpc.net/problem/2447
// 제출 공유 링크 : http://boj.kr/48c9f1f38dc74ef6b10789e8134e47f6

// 예전에는 수학식을.. 계산했었는데 재귀로 풀면 훨씬 더 쉬울 것 같아서 이번에는 재귀로 해결해보려고 한다.
// 찍는 별의 가로 줄 수가 최대 3^8인데, 기억상 표준입출력을 쓰면 시간이 부족해서 BufferedWriter를 사용했다.

package com.baekjoon.problem.java2447;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();   // 가로, 세로 줄 수
        stars = new char[n][n];   // 별찍기 문자 배열
        // 별찍기 배열 초기화
        for (int i = 0; i<n; i++) {
            stars[i] = new char[n];
            for (int j = 0; j < n; j++) {
                stars[i][j] = '*';
            }
        }

        // 재귀함수로 별을 공백으로 치환한다.
        dfs(0, 0, n);

        // 별찍기!
        for (int i = 0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(stars[i][j]);
            }
            bw.write('\n');
        }
        bw.close();
    }

    // 가로 위치, 세로 위치, 길이
    static void dfs(int r, int c, int len){
        // 첫 부분이 빈 칸이라면 중앙 부분도 빈칸이다.
        // 어.. 그림을 그리면 꽤나 당연한데 말로는 어럽다;;
        if (stars[r][c] == ' '){
            return;
        }
        // 크기가 3이면 중앙 부분 한칸을 빈칸으로 만들고 return
        if (len == 3){
            stars[r+1][c+1] = ' ';
            return;
        }

        // 중앙 부분을 빈칸으로 만들고
        int startR = r + len/3;
        int startC = c + len/3;
        for (int i = 0; i<len/3; i++){
            for (int j = 0; j<len/3; j++){
                stars[startR+i][startC+j] = ' ';
            }
        }

        // 작은 사각형을 다시 탐색한다.
        for (int i = 0; i<len; i+=len/3){
            for (int j = 0; j<len; j+=len/3){
                dfs(r+i, c+j, len/3);
            }
        }
    }
}
