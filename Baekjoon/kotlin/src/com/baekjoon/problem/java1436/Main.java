// 문제 링크 : https://www.acmicpc.net/problem/1436
// 제출 공유 링크 : http://boj.kr/53b876e47ade45d6b7585e8bd6b81f09

// 단순히 완전탐색을 이용하였다.
// 효율 생각 안하고 최대한 빨리 푸는 방식으로 하였다.

package com.baekjoon.problem.java1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 숫자를 1씩 더하면서 종말의 숫자 찾기
        int count = 1;
        int number = 666;
        while(count != n) { // n번째 종말의 숫자를 찾을 때까지 반복
            // 1 증가
            number++;

            // 숫자에 666이 포함되어있다면
            if (String.valueOf(number).contains("666")) {
                count += 1; // 종말의 숫자 찾은 갯수 +1
            }
        }

        // n번째 종말의 숫자 출력
        System.out.println(number);
    }
}
