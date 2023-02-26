// 문제 링크 : https://www.acmicpc.net/problem/2531
// 제출 공유 링크 : http://boj.kr/776ad09ca08d47a78e205fba30ab61bc
// 백준 회전 초밥

// 지문이.. 롸? 머라굽쇼?
// .. 계수정렬? 처럼 저장하는 그 방식인가?

package com.baekjoon.problem.java2531;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 접시 수, 초밥의 가짓수, 연속해서 먹는 접시의 수, 쿠폰번호
        int n = sc.nextInt(), d = sc.nextInt(), k = sc.nextInt(), c = sc.nextInt();
        int[] count = new int[d+1]; // 연속해서 먹을 접시의 종류
        int[] sushi = new int[n];   // 회전 초밥 배열
        int type = 1;   // 먹을 초밥 종류
        
        // 접시 종류에 쿠폰 추가
        count[c] += 1;

        // 회전 초밥과 연속해서 먹을 접시 종류 배열, 초밥 종류 초기화
        for (int i = 0; i<n; i++){
            sushi[i] = sc.nextInt();
            if (i < k){
                // 처음 추가되는 것이라면 type+1/count+1, 아니라면 count만 +1
                if (count[sushi[i]]++ == 0) type++;
            }
        }

        // 모든 초밥을 다 먹어야 한다면 아래 연산이 필요없다.
        if (k == n){
            System.out.println(type);
            return;
        }

        int answer = type;
        // 연속으로 먹을 수 있는 모든 방법을 살펴본다.
        // 한칸씩 옆으로 옮기면서 종류를 확인한다.
        for (int i = 0; i<n; i++){
            // 빼는 초밥의 종류의 개수를 확인한다.
            if(count[sushi[i]]-- == 1)
                type--;

            // 추가하는 초밥의 종류의 개수를 확인한다.
            if (count[sushi[(i+k)%n]]++ == 0)
                type++;

            // 값을 적절하게 저장한다.
            answer = Math.max(answer, type);
        }

        // 가장 다양한 종류의 초밥 가지수 출력
        System.out.println(answer);
    }
}
