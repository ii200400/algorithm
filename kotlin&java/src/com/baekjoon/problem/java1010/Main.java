// 문제 링크 : https://www.acmicpc.net/problem/1010
// 제출 공유 링크 : http://boj.kr/db229073b6d54729819069ad63c07b52
// 백준 다리 놓기

// 아니.. 신나게 고민했더니 뭔가 조합같길래
// 왜 조합같지? 생각해보니 정말 조합이었다..

package com.baekjoon.problem.java1010;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tastcase = sc.nextInt();
        for (int i = 0; i<tastcase; i++){
            int westCnt = sc.nextInt(); // 서쪽 사이트 수
            int eastCnt = sc.nextInt(); // 동쪽 사이트 수

            long caseCnt = 1;   // 만들 수 있는 다리 경우의 수
            
            // 5C4 = 5C1 과 같으므로 더 적은 연산을 하기 위해
            int min = Math.min(eastCnt, eastCnt-westCnt);   // 둘 중 작은 수 선택
            // 조합의 수 연산
            for (int j = 0; j<min; j++){
                caseCnt *= (eastCnt-j);
                caseCnt /= j+1;
            }

            // 조합의 수 출력
            System.out.println(caseCnt);
        }
    }
}
