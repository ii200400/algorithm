// 문제 링크 : https://www.acmicpc.net/problem/3985
// 제출 공유 링크 : http://boj.kr/ed439f9b7dbb4eefafedccb472bfa7f1

// 어.. 시뮬레이션 문제인지 무엇인지 그냥 지문에서 하라는대로 했다.

package com.baekjoon.problem.java3985;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력값이 0이 아니라 1부터 와서 인덱스를 1 크게 잡았다.
        boolean[] rollCake = new boolean[sc.nextInt()+1]; // 롤 케이크가 차지 여부 배열
        int[] expectedMax = new int[]{0,0}; // 가장 많은 조각을 적은 것과 그것을 기대한 방청객
        int[] max = new int[]{0,0};   // 실재로 가장 많은 조각을 얻었을 때 그 조각 수와 그것을 적은 방청객
        int n = sc.nextInt();   // 방청객 수
        
        // 각 방청객이 적은 쪽지를 보면서
        for (int i = 1; i<=n; i++){
            // 원하는 조각을 보았을 때
            int from = sc.nextInt(), to = sc.nextInt();
            // 가장 많은 조각을 바라는 방청객인지 확인하고 기록한다.
            if (expectedMax[0] < to-from+1){
                expectedMax[0] = to-from+1;
                expectedMax[1] = i;
            }

            int tempCnt = 0;
            for (int j = from; j<=to; j++){
                // 원하는 조각을 누군가가 차지했다면 패스
                if (rollCake[j])
                    continue;

                // 아니라면 가져갈 수 있다.
                rollCake[j] = true;
                tempCnt++;
            }

            // 가장 많은 조각을 가져가는 방청객인지 확인하고 기록한다.
            if (max[0] < tempCnt){
                max[0] = tempCnt;
                max[1] = i;
            }
        }

        // 많이 가질 것이라고 기대하는 방청객과
        System.out.println(expectedMax[1]);
        // 실재로 많이 가지는 방청객을 출력한다.
        System.out.println(max[1]);
    }
}
