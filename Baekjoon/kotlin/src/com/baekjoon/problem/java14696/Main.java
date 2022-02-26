// 문제 링크 : https://www.acmicpc.net/problem/14696
// 제출 공유 링크 : http://boj.kr/4c99d4d99777406b864e75c38177b413

// 무엇을 암시하는 문제이지..?
// 아까 방배정 문제도 그렇지만 참.. 재미없는 문제이다.
// 아니면.. 기수정렬을 가르치시려고 하시는 건가? 딱 기수정렬 조건에 맞는 문제이긴 하다

package com.baekjoon.problem.java14696;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 라운드 수
        int[] cardA;    // A 딱지
        int[] cardB;    // B 딱지
        round: for (int i = 0; i<n; i++){
            // 딱지들 재선언
            cardA = new int[5];
            cardB = new int[5];

            // A 딱지 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken(); // 첫 숫자는 버린다;
            while(st.hasMoreTokens())
                cardA[Integer.parseInt(st.nextToken())]++;

            // B 딱지 초기화
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 첫 숫자는 버린다;
            while(st.hasMoreTokens())
                cardB[Integer.parseInt(st.nextToken())]++;

            // 별, 동그라미, 네모, 세모를 차례대로 보면서 더 많은 쪽이 이긴다.
            // 이기면 round for문으로 탈출한다.
            for (int j = 4; j>0; j--){
                if (cardA[j] > cardB[j]) {
                    System.out.println('A');
                    continue round;
                }else if (cardA[j] < cardB[j]) {
                    System.out.println('B');
                    continue round;
                }
            }

            // 동점이라면 D를 출력한다.
            System.out.println('D');
        }
    }
}
