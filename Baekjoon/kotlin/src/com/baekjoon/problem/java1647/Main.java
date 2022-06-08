// 문제 링크 : https://www.acmicpc.net/problem/1647
// 제출 공유 링크 : http://boj.kr/51e93e09daf140e7a5efd9fa93b29a4d
// 백준 도시 분할 계획

// 기본적인 MST문제인데 MST 총 가중치에서 가장 가중치가 큰 간선 하나를 뺀 결과를 출력하면 되는 문제이다.
// 이전 문제가 서로소 집합이였으니 이번에는 프림 알고리즘을 이용하여 풀려고 한다.

// 설마.. 마을에 길이 없는 집이 있지는 않겠지..?

package com.baekjoon.problem.java1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 집의 개수
        int m = Integer.parseInt(st.nextToken());   // 길의 개수
        // 입력 데이터 : [정점(집), 가중치]
        ArrayList<int[]>[] adjList = new ArrayList[n+1];   // 인접리스트
        int mstWeightSum = 0; // MST 가중치 합
        int max = 0;    // MST에 있는 가중치가 가장 큰 길

        // 인접리스트 초기화
        for (int i = 1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from].add(new int[] {to, weight});
            adjList[to].add(new int[] {from, weight});
        }

        // 가중치를 기준으로 하는 우선순위 큐
        // 입력 데이터는 인접리스트의 데이터
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        boolean[] visited = new boolean[n+1];   // 방문 배열
        pq.offer(new int[] {1, 0});

        int cnt = 0;    // MST 간선 수
        while(true){
            int[] current = pq.poll();

            int house = current[0];
            int weight = current[1];

            // 이미 방문한 집이라면 패스
            if (visited[house])
                continue;

            // 그렇지 않다면 방문체크하고
            visited[house] = true;
            cnt++;
            mstWeightSum += weight;
            max = Math.max(max, weight);

            if (cnt == n)
                break;

            // 주변 집 탐색
            for (int i = 0; i<adjList[house].size(); i++){
                int[] search = adjList[house].get(i);
                int sHouse = search[0];

                // 이미 방문한 집이라면 패스
                if (visited[sHouse])
                    continue;

                // 우선순위 큐에 추가
                pq.offer(search);
            }
        }

        // mst에서 가중치가 가장 큰 값을 제외하고(두 마을로 분리) 출력
        System.out.println(mstWeightSum - max);
    }
}
