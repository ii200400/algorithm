// 문제 링크 : https://www.acmicpc.net/problem/1592
// 제출 공유 링크 : http://boj.kr/1b7fb445370e4d11a27e564824a9fc28

// 단순히 배열을 조작해보는 문제같다.

// 모듈러? 연산이라는 나머지를 통해서 인덱스를 조정하는 코드 ((idx + n + l) % n)를 해보라고 주신 문제라고 한다.
// 본인은 지문의 L < N-1이라는 조건을 보고 다른 코드로 대체해 버렸닼ㅋㅋㅋ

package com.baekjoon.problem.java1592;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기화
        int n = sc.nextInt();   // 사람 수
        int m = sc.nextInt();   // 게임이 끝나는 조건 (공을 받는 횟수)
        int l = sc.nextInt();   // 공을 던지는 거리
        int[] arr = new int[n]; // 각자 공을 몇 번 받았는지

        int idx = 0; // 공을 가지고 있는 사람의 인덱스
        int throwCnt = 0;   // 공을 던진 횟수

        // 게임 시작
        while(true){
            // 던진 공을 받은 공의 횟수가 m 번째라면 게임 끝
            if (++arr[idx] == m)
                break;

            // 받은 공의 횟수가 짝수라면 반시계 반향의 l번째 사람에게 던지고
            if (arr[idx]%2 == 0){
//                idx = (idx + n - l) % n 으로 만들 수 있는데 모듈러 연산이라고 한다.
                idx -= l;
                if (idx < 0)
                    idx += n;
            }else{ // 받은 공의 횟수가 홀수라면 시계 반향의 l번째 사람에게 던진다.
//                idx = (idx + n + l) % n 으로 만들 수 있는데 모듈러 연산이라고 한다.
                idx += l;
                if (idx >= n){
                    idx -= n;
                }
            }

            // 던진 횟수를 +1
            throwCnt++;
        }

        // 게임이 끝날 때 까지 던진 공의 횟수를 출력한다.
        System.out.println(throwCnt);
    }
}
