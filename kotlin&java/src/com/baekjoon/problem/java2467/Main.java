// 문제 링크 : https://www.acmicpc.net/problem/2467
// 제출 공유 링크 : http://boj.kr/6c5a2184fa2e4711861b43d1f1961c8f
// 백준 용액

// 특성 값도 정렬이 되어있고, 두 용액만을 섞는다면 투포인터 아닌가?
// ?? 왜 통과가 안되는지 전혀 모르겠다.
// a.. diff 변수 갱신을 안해주고 있었다.. 쭈빠짜빠..

package com.baekjoon.problem.java2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 용액의 수
        int[] liquid = new int[n];  // 용액의 특성값 배열

        // 용액 배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<n; i++){
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        // 가장 작은 특성값을 가지는 두 용액 저장
        int l1 = liquid[0], l2 = liquid[liquid.length-1];
        int diff = l1+l2;

        // 두 포인터로 두 용액의 차이값이 가장 작은 것을 탐색한다.
        int idxL1 = 0, idxL2 = liquid.length-1;
        while(idxL1 != idxL2) {
            if (Math.abs(diff) > Math.abs(liquid[idxL1] + liquid[idxL2])) {
                l1 = liquid[idxL1];
                l2 = liquid[idxL2];
                diff = l1+l2;
            }

            if (liquid[idxL1] + liquid[idxL2] > 0) {
                idxL2--;
            } else {
                idxL1++;
            }
        }

        // 두 용액 합이 특성값 절대값이 가장 0에 가까운 용액 출력
        System.out.println(l1 + " " + l2);
    }
}
