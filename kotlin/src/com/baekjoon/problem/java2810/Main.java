// 문제 링크 : https://www.acmicpc.net/problem/2810
// 제출 공유 링크 : http://boj.kr/afee9e567810459e8de691a1b3ebf1b1

// 그냥..? L 좌석의 갯수를 세고 빼면 되는 것 같다.

package com.baekjoon.problem.java2810;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 좌석 수
        int cntL = 0;   // 커플 좌석 수

        // 커플 좌석 확인
        for (char c : sc.next().toCharArray()){
            if (c == 'L')
                cntL ++;
        }

        // 전체 좌석에서 커플 좌석을 뺀다.
        // 양 옆에 있는 컵홀더 때문에 1개의 여유가 있다.
        System.out.println(n-Math.max(0, cntL/2 - 1));
    }
}
