// 문제 링크 : https://www.acmicpc.net/problem/8320
// 제출 공유 링크 : http://boj.kr/028abfda8a77495a8fb8f5227625a006

// 음.. 조합 구하듯이? 라고 해야하나?
// 조합에서 사용하는 for문을 사용할 것 같다.

package com.baekjoon.problem.java8320;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 직사각형을 만들 때 사용하는 정사각형 수
        int cnt = 0;    // 만들 수 있는 직사각형의 수
        int limit = (int) Math.sqrt(n); // n의 제곱근, 세로 줄 수 제한을 위해 사용한다.
        for (int i = 1; i<=limit; i++){ // i는 세로 줄 수
            for (int j = i; ; j++){ // j는 가로 줄 수 (돌려서 같으면 같은 직사각형이므로 i부터 시작)
                // 정사각형이 부족하면 다른 직사각형을 보러 돌아간다.
                if (i*j > n)
                    break;

                // 만들 수 있다면 cnt+1
                cnt++;
            }
        }

        // 만들 수 있는 직사각형의 수 출력
        System.out.println(cnt);
    }
}
