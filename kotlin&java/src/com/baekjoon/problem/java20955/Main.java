// 문제 링크 : https://www.acmicpc.net/problem/20955
// 제출 공유 링크 : https://www.acmicpc.net/source/share/29e90fa0713241ed885bc21a6404d354
// 백준 민서의 응급 수술

// 음.. disjoint set인 것 같다.
// 단순히 시냅스 하나씩 받아오면서 사이클이 생기면 +1
// 마지막에 모든 노드의 루트 시냅스(?)의 종류 - 1을 더하면 된다.

// 알고리즘 생각하다보니
// 모든 노드의 루트 시냅스(?)의 종류 - 1 이 아니라
// 그냥 (뉴런의 수 - 1) - 사이클이 생기지 않은 시냅스 수 를 구해서 더해도 된다.
// 두 개가 같은 의미, 같은 숫자를 가지기 때문.

// 시간복잡도는 O(M) - 시냅스의 개수에 비례한다.

package com.baekjoon.problem.java20955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] disjoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n  = Integer.parseInt(st.nextToken());  // 뉴런 개수
        int m  = Integer.parseInt(st.nextToken());  // 시냅스 개수
        disjoint = new int[n+1];  // 서로소 집합, 편의상 크기 +1
        int cycleCnt = 0; // 사이클 회수
        int nonCycleCnt = 0;    // 사이클이 아닌 회수

        // 서로소 집합 초기화
        for (int i = 1; i<=n; i++){
            disjoint[i] = i;
        }

        // 시냅스 확인(입력받기)
        for (int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (union(a, b)){   // 사이클이 아니라면
                nonCycleCnt++;
            }else { // 사이클이라면
                cycleCnt++;
            }
        }

        // 시술 회수 출력 (연결해야 하는 회수(뉴런 수 - 사이클이 아닌 연결 회수 - 1) + 연결을 끊어야 하는 회수(사이클))
        System.out.println((n-nonCycleCnt-1) + cycleCnt);
    }

    // 서로소 집합 합치기
    // 두 뉴런이 같은 집합이면 false, 아니면 집합을 합치고 true 반환
    static boolean union(int a, int b){
        // 두 수의 루트를 통해서
        int parentA = find(a);
        int parentB = find(b);

        // 같은 집합이면 false
        if (parentA == parentB)
            return false;

        // 다른 집합이면 집합을 합치고 true 반환
        disjoint[parentB] = parentA;
        return true;
    }

    // 서로소 집합 찾기
    static int find(int a){
        if (disjoint[a] == a)
            return a;

        return disjoint[a] = find(disjoint[a]);
    }
}
