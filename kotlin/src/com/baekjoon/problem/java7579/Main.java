// 문제 링크 : https://www.acmicpc.net/problem/7579
// 제출 공유 링크 : http://boj.kr/fa345a167fdb480492c1143024e56d84
// 백준 앱

// 냅색 문제같은데.. 메모리가 저렇게 작아도 메모리 초과가 뜨지 않는 건가..?
// 음.. 혹시 모르니 단일 배열로 해결하겠다.

// 바로 단일배열로 해서 잘은 모르겠지만 이중배열로하면 진짜 메모리 초과가 났을 것 같다..

package com.baekjoon.problem.java7579;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 앱의 수
        int m = sc.nextInt();   // 필요한 메모리
        int[] memo = new int[m+1];  // 각 메모리 상태마다 가장 작은 비용을 저장
        int[] appMemories = new int[n]; // 각 앱의 메모리
        int[] appCost = new int[n]; // 각 앱의 비용

        // 메모이제이션 초기화
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        // 앱의 메모리 초기화
        for (int i = 0; i<n; i++){
            appMemories[i] = sc.nextInt();
        }
        // 각 앱의 비용 초기화
        for (int i = 0; i<n; i++){
            appCost[i] = sc.nextInt();
        }

        // 단일배열 냅색 진행
        for (int i = 0; i<n; i++) {
            // 각 앱의 메모리와 비용에 대한 연산을 진행한다.
            int memory = appMemories[i];
            int cost = appCost[i];

            for (int j = m - 1; j >= 0; j--) {
                // 해당 값에 대해 도달한 적이 없다면 패스
                if (memo[j] == Integer.MAX_VALUE) continue;

                // 메모리 크기가 m이 넘는다면 m으로 맞춰준다.
                int idx = Math.min(j + memory, m);
                // 더 비용이 작은 값을 저장해준다.
                memo[idx] = Math.min(memo[idx], memo[j] + cost);
            }
        }

        // 메모리 크기가 m인 비용이 가장 작은 경우를 출력한다.
        System.out.println(memo[m]);
    }
}
