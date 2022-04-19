// 문제 링크 : https://www.acmicpc.net/problem/2003
// 제출 공유 링크 : http://boj.kr/684999be8c2645acb8555220ad779368
// 백준 수들의 합 2

package com.baekjoon.problem.java2003;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 수열의 수
        int num = sc.nextInt(); // 목표 수
        int[] seq = new int[n]; // 수열

        // 수열 초기화
        for (int i = 0; i<n; i++){
            seq[i] = sc.nextInt();
        }

        int start = 0, end = 1; // 투 포인터
        int sum = seq[0];   // 투 포인터 사이의 숫자 합
        int cnt = 0;    // sum이 num이 되는 경우의 수
        while (true){   // 특정 상황이 일어날 때 까지 진행
            // 현재 총합이 num과 같다면 경우의 수 +1
            if (sum == num){
                cnt++;
            }

            if (sum < num){ // 현재 총합이 작다면
                // 더 이상 수열이 없다면 끝
                if (end == n){
                    break;
                }

                // 연속하는 수를 하나 더 추가한다.
                sum += seq[end++];
            }else{  // 현재 총합이 크다면
                // 연속하는 수 중 가장 왼쪽 수를 뺀다.
                sum -= seq[start++];
            }
        }

        // 경우의 수 출력
        System.out.println(cnt);
    }
}
