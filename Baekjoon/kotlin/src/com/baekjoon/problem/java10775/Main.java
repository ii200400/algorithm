// 문제 링크 : https://www.acmicpc.net/problem/10775
// 제출 공유 링크 : http://boj.kr/1fe5d49bf8f548b2abaac9479445add4
// 백준 공항

// 어.. 배열문제인가..? 이해를 잘한지 모르겠다;;

// 역시 이해를 잘못했었다.
// 음.. 탐색을 빠르게 하기위해서 서로소 집합..을 활용해보겠다.
// 비행기는 도킹할 수 있는 가장 숫자가 높은 게이트에 도킹하고(그래야 숫자가 낮은 더 많은 비행기가 도킹할 수 있으므로),
// 한번 도킹한 게이트는 본인 숫자의 1작은 게이트를 가리키도록 집합을 만든다.
// 루트 게이트를 아직 도킹하지 않은 빈 게이트로 간주하여 빈 게이트를 빠르게 찾도록 할 것이다.
// 루트 게이트가 0이라면 도킹할 곳이 없는 상황으로 간주하였다.

package com.baekjoon.problem.java10775;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] disjoint;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int g = sc.nextInt();   // 게이트의 수
        int p = sc.nextInt();   // 비행기의 수
        disjoint = new int[g+1];   // 빈 게이트를 빠르게 찾기위한.. 서로소 집합?

        // 서로소 집합 초기화
        for (int i = 1; i<=g; i++){
            disjoint[i] = i;
        }

        // 게이트 도킹.. 확인 및 도킹한 게이트 개수 세기
        int cnt;
        for (cnt = 0; cnt<p; cnt++){
            // 도킹할 수 있는 게이트가 주어지면 빈 게이트를 찾는다
            int num = sc.nextInt();
            int root = find(num);

            // 빈 게이트가 없다면 반복문 탈출
            if (root == 0){
                break;
            }

            // 빈 게이트에 도킹한다.
            disjoint[root] = root-1;
        }

        // 도킹한 게이트 개수 출력
        System.out.println(cnt);
    }

    /**
     * num보다 작은 숫자의 빈 게이트 탐색
     * @param num 게이트 숫자
     * @return
     */
    static int find(int num){
        if (disjoint[num] == num)
            return num;

        return disjoint[num] = find(disjoint[num]);
    }
}
