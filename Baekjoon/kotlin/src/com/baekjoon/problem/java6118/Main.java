// 문제 링크 : https://www.acmicpc.net/problem/6118
// 제출 공유 링크 : http://boj.kr/1900ece68b1240eebaa59c41a23632c2
// 교수님이 추천해주신 기초문제 풀이 중 숨바꼭질 시리즈 풀이 중

// 문제 지문 상으로는..
// 1번에서 가장 많은 간선으로 갈 수 있는 위치 중 가장 작은 헛간 숫자를 구하라는 것.
// 자연스럽게 bfs를 떠올렸다.
// 추가로 인접행렬을 사용하면 메모리가 나갈 것 같아서 인접리스트를 사용하였다.

// 왜 해당 문제 관련 질문에는.. 플로이드 웨셸부터.. 다익스트라까지 나오는지;;
// 지문이 변했던 걸까?

package com.baekjoon.problem.java6118;

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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 헛간의 수
        int m = Integer.parseInt(st.nextToken());   // 길 수 (간선 수)
        ArrayList<Integer>[] adjList = new ArrayList[n+1];    // 인접리스트, 1부터 시작하는 입력값에 대해 편의상 크기 +1
        boolean[] visited = new boolean[n+1];   // 방문 배열, 1부터 시작하는 입력값에 대해 편의상 크기 +1

        // 인접리스트 초기화
        for (int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        // 헛간 1번부터 시작하므로
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int farLoc = 20001;    // 1번 헛간에서 가장 멀먼서 번호가 작은 헛간 번호
        int depth = -1;  // 위의 헛간까지의 거리
        int depthCnt = 0;  // 위의 헛간과 같은 거리를 가지는 헛간 개수
        while (!q.isEmpty()){
            int size = q.size();

            // 정답 변수들 초기화
            farLoc = 20001;
            depth++;
            depthCnt = size;

            // 레벨 탐색
            for (int i = 0; i<size; i++){
                int current = q.poll();
                
                // 현 위치에서 연결되어있는 다른 헛간을 보는데
                for (int lookup: adjList[current]) {
                    // 현재 위치를 적절히 저장
                    farLoc = Math.min(farLoc, current);

                    // 이미 방문했다면 생략
                    if (visited[lookup])
                        continue;

                    // 그렇지 않다면 큐에 추가하고 방문 채크
                    q.add(lookup);
                    visited[lookup] = true;
                }
            }
        }

        // 1번 헛간에서 가장 멀먼서 번호가 작은 헛간 번호 출력
        System.out.printf("%d %d %d", farLoc, depth, depthCnt);
    }
}
