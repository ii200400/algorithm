// 문제 링크 : https://www.acmicpc.net/problem/11437
// 제출 공유 링크 : http://boj.kr/c9647e752f944884b73cc7b634aa6b90
// 백준 LCA

// LCA가 무엇의 약자인지는 모르겠으나, 3초라면.. 서로소집합이 가능할 것 같은데..?
// 시간초과가 날지도 모르겠다.

// 두 노드의 공통조상은 아래와 같이 구했다.
// 두 정점의 깊이를 확인하고 더 깊은 정점에서 깊이가 같을 때까지 부모 노드를 탐색하며 올라간다.
// 말이 이상한데;; 설명이 좀;;
// 예를들어 백준 예제입력1의 기준으로
// 루트노드 1부터 노드 9는 1-2-4-9, 노드 15는 1-2-5-11-15의 경로를 가진다.
// 노드 15의 깊이는 4이므로 노드 9의 깊이 3에 대응하여 11부터 시작하도록 한다.
// 그리고 두 노드를 동시에 부모노드를 거슬러올라가면서 살펴보는데
// 같은 노드라면 가장 가까운 공통조상인 것이다.
// 즉, 위의 노드 9와 15의 가장 가까운 공통 조상은 2

// 만약 시간부족출력하면.. 위 과정을 재귀로 만들고 dp를 활용할 예정..;;

// 어힉후야;; 3.5초로 오래걸리고 메모리는 별로 많이 사용하지 않았다.
// 같은 문제에 1초라면 dp 사용할 것 같다.

package com.baekjoon.problem.java11437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 노드의 수
        ArrayList<Integer>[] adjList = new ArrayList[n+1];  // 인접리스트
        int[][] disjoint = new int[n+1][2];  // 서로소 집합 [각 노드별][부모 노드, 루트부터의 깊이]
        disjoint[1] = new int[] {1, 0};    // 1은 항상 루트이므로

        // 인접리스트 초기화
        for (int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());;
            adjList[from].add(to);
            adjList[to].add(from);
        }

        // bfs를 활용하여 트리의 서로소 집합 구현
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        // bfs 시작
        int level = 0;
        while (!q.isEmpty()){
            level++;

            // 레벨우선 탐색
            int size = q.size();
            for (int i = 0; i<size; i++){
                int current = q.poll();

                // 인접한 노드 탐색
                for (int next : adjList[current]){
                    // 이미 방문한 경험이 있다면 생략
                    if(disjoint[next][0] != 0)
                        continue;

                    disjoint[next] = new int[] { current, level };
                    q.offer(next);
                }
            }
        }

        // 공통조상이 궁금한 두 정점의 입력 회수
        int question = Integer.parseInt(br.readLine());
        int node1, node2;
        for (int i = 0; i<question; i++){
            st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            // 두 노드의 깊이가 같도록 조정한다.
            int min = Math.min(disjoint[node1][1], disjoint[node2][1]);
            while (min != disjoint[node1][1]){
                node1 = disjoint[node1][0];
            }
            while (min != disjoint[node2][1]){
                node2 = disjoint[node2][0];
            }

            // 공통조상을 찾을 때까지 탐색
            while(node1 != node2){
                node1 = disjoint[node1][0];
                node2 = disjoint[node2][0];
            }
            // 공통조상 출력
            System.out.println(node1);
        }
    }
}
