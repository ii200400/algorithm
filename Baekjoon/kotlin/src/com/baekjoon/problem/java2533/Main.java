// 문제 링크 : https://www.acmicpc.net/problem/2533
// 제출 공유 링크 :
// 백준 사회망 서비스(SNS)

// 바로 보았을 때는 당황스러운 문제였는데,
// 그냥 트리를 bfs를 활용하여 레벨우선탐색을 하면서
// 홀수인 레벨과 짝수인 레벨들의 노드 수를 세면 되는 것이었다 하하핳.

// 아니었다! 현 노드가 얼리어답터라고 자식노드는 무조건 얼리어답터가 아니라는 생각을 했는데 두번째 예시를 보니 아니였다!
// 그럼.. 어떻게 풀지..;;

package com.baekjoon.problem.java2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 노드 수
        ArrayList<Integer>[] adjList = new ArrayList[n+1];   // 인접리스트
        boolean[] visited = new boolean[n+1];

        StringTokenizer st;
        // 인접리스트 초기화
        for (int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i = 1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adjList[n1].add(n2);
            adjList[n2].add(n1);
        }


    }
}
