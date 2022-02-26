// 문제 링크 : https://www.acmicpc.net/problem/2292
// 제출 공유 링크 : http://boj.kr/8a4645ff49984d87a69d608e404952a9

// 벌집이 이동 횟수마다 특정하게 늘어나는 패턴이 있어서 해당 패턴을 이용해서 풀었다.
// 그.. 수열의 증가하는 정도가 일정한 것을 무슨 수열이라고 배운 것 같은데 기억은 안나고 그렇게 풀었다.

package com.baekjoon.problem.java2292;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int cnt = 1;    // 방을 지나는 회수
        int plus = 0;    // 추가되는 방 수
        // n번째 방이 cnt번 움직일 때 갈 수 있는 최대 숫자의 방보다 작을 때 까지 진행
        for(int i = 1; i<n; plus += 6, i+=plus, cnt++){
        }
        System.out.println(cnt);
    }
}
