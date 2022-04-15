// 문제 링크 : https://www.acmicpc.net/problem/1197
// 제출 공유 링크 : http://boj.kr/a73f47f1ac114f9ebd110a3224b48d29
// 백준 최소 스패닝 트리

// 문제 제목으로 빠르게 알고리즘 주제 스포해버리는 문제.
// 정점에 비해서 간선 수가 적으므로.. 어.. 프림? 크루스칼? 이름이 햇갈리는데,
// 서로소 집합 안쓰는 것으로.. 사용할 예정이다.

// 기억 잘 안 났는데 바로 통과해서 기부니가 좋다!

package com.baekjoon.problem.java1197;

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

        int v = Integer.parseInt(st.nextToken());   // 정점의 수
        int e = Integer.parseInt(st.nextToken());   // 간선의 수
        ArrayList<int[]>[] adjList = new ArrayList[v+1];  // 인접리스트
        boolean[] visited = new boolean[v+1];
        
        // 인접리스트 초기화
        for (int i = 1; i<=v; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from].add(new int[] {to, weight});
            adjList[to].add(new int[] {from, weight});
        }

        // 우선순위 큐 초기화
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        pq.offer(new int[] {1, 0});

        // 프림 알고리즘 시작
        int mst = 0;    // mst 총 가중치
        int cnt = 0;    // 연결한 정점의 수
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int num = current[0];

            // 이미 방문한 정점이라면 생략한다.
            if (visited[num])
                continue;

            visited[num] = true;
            mst += current[1];

            // mst를 완성했다면 반복문 탈출
            if (++cnt == v)
                break;
            
            for (int[] next: adjList[num]){
                // 이미 방문한 정점이라면 생략하고
                if (visited[next[0]])
                    continue;

                // 큐에 넣는다.
                pq.offer(next);
            }
        }

        // mst 가중치 출력
        System.out.println(mst);
    }
}
