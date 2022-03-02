// 문제 링크 : https://www.acmicpc.net/problem/1238
// 제출 공유 링크 : http://boj.kr/a4b18a870b74433bb93038d10edfbbb0

// X 마을부터 다른마을까지 최단거리를 구하는 문제, 즉 다익스트라나 프림 알고리즘을 이용하면 된다.
// 자바 기준으로 시간제한은 2초 정도이므로 정점이 1천개이면 시간초과가 나지 않을 것 같아
// 인접행렬, 다익스트라를 활용하여 해결하겠다.

// 다리가 단방향인 것을 읽었지만 중간에 까먹었다!! 이거.. 다익스트라보다는 플로이드-워셀? 알고리즘 같은데;;
// 최악이라면 거의 모든 경로를 다보고 있어야 하잖아아아악
// 다익스트라 문제라고 해도! 이게 왜 기본문제..?

package com.baekjoon.problem.java1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 정점(마을) 수
        int m = Integer.parseInt(st.nextToken());   // 간선(다리) 수 (변수 사용 안함)
        int x = Integer.parseInt(st.nextToken());   // 파티 정점(마을) 인덱스
        adjMatrix = new int[n+1][n+1];  // 인접 행렬
        int[] totalDistance; // 각 정점의 왕복거리

        // 인접행렬 초기화
        for (int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjMatrix[from][to] = weight;
        }

        // 시작지점에서 각 경로까지의 최단거리를 구하고
        totalDistance = dijkstra(x, 0, n);

        // 이번에는 반대로 각 지점에서 시작지점까지의 최단경로를 구한다.
        for (int i = 1; i<n+1; i++) {
            // 시작지점에서 시작지점으로 가는 것은 생략;;
            if (i == x)
                continue;
            // i 번째 마을에서 시작지점까지 최단거리를 구하고
            int[] temp = dijkstra(i, x, n+1);
            // 합산한다.
            totalDistance[i] += temp[x];
        }

        // 왕복거리가 가장 긴 거리를 출력한다.
        totalDistance[0] = 0;
        System.out.println(Arrays.stream(totalDistance).max().getAsInt());
    }

    // 다익스트라 함수
    // start 부터 end까지의 최소 가중치 경로를 찾는다, limit번 반복하면 끝내도록 한다.
    static int[] dijkstra(int start, int end, int limit){
        int[] minDistance = new int[n+1];   // 각 정점까지의 최소거리
        boolean[] isVisit = new boolean[n+1];   // 방문 배열

        // 최소 거리 배열 초기화
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[start] = 0;

        int cnt = 0; // 방문한 정점의 수
        while(true){
            // 경로 중에서 가장 짧은 경로를 구한다.
            int minIdx = 0, minWeight = Integer.MAX_VALUE;  // 현재 정점에서 갈 수 있는 가장 가까운 정점 및 가중치
            for (int i = 1; i<n+1; i++){
                // 이미 방문한 곳이라면 생략한다.
                if (isVisit[i])
                    continue;

                // 탐색한 경로들보다 더 짧은 경로를 찾으면
                if (minWeight > minDistance[i]){
                    // 기록해둔다.
                    minIdx = i;
                    minWeight = minDistance[i];
                }
            }

            // 해당 정점을 방문했다는 기록을 하고
            isVisit[minIdx] = true;
            // 정점 방문 회수(마을 연결 회수)를 증가한다.
            cnt++;

            // 원하는 회수만큼 마을을 확인하거나, 원하는 목적지에 도달했다면
            if (cnt == limit || minIdx == end)
                break;// 탈출한다.

            // 해당 정점부터 다른 정점까지의 거리를 최소 거리 배열에 업데이트 해준다.
            for (int i = 1; i<n+1; i++){
                // 이미 최소거리를 알고 있거나 간선이 없는 정점은 제외하고
                if (isVisit[i] || adjMatrix[minIdx][i] == 0)
                    continue;

                // 업데이트를 진행해준다.
                minDistance[i] = Math.min(minDistance[i], minDistance[minIdx]+adjMatrix[minIdx][i]);
            }
        }

        // start부터 end까지, 혹은 limit 번의 마을 탐색 이후 최단경로 배열 반환
        return minDistance;
    }
}
