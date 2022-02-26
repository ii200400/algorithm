// 문제 링크 : https://www.acmicpc.net/problem/1753
// 제출 공유 링크 : http://boj.kr/e4577836dc65419382588a5460bb76a4

// 좀.. 정점은 너무 많고 상대적으로 간선이 적어보이면서 시간도 1초여서 인접 리스트로 진행해보겠다.
// 평소에 사용하는 방식이 싸피에서 배운것과 다르긴 한데 싸피에서 배운 방식이 훨씩 효율적이므로
// 배운 방식을 떠올려서 해보겠다.

// 아.. 모든 정점이 연결되어있는 줄 알고 큐를 사용했는데,
// 아닌줄 몰랐다, 그냥 배열 활용할 걸..
// 그래도 시간초과는 뜨지 않았다, 나중에 배열과 시간비교를 좀 해야겠다.

package com.baekjoon.problem.java1753;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());   // 정점 수
        int e = Integer.parseInt(st.nextToken());   // 간선 수
        int start = Integer.parseInt(br.readLine());    // 시작 정점
        
        ArrayList<int[]>[] adjList = new ArrayList[v+1];  // 인접 리스트, 편의상 +1
        // 인접 리스트 초기화
        for (int i = 1; i<v+1; i++){
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from].add(new int[]{to, weight});
        }

        // 각 정점까지의 최단거리, 편의상 +1
        int[] minDistance = new int[v+1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        // 가중치를 기준으로 정렬하는 우선순위 큐
        boolean[] isVisited = new boolean[v+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(i->i[1]));
        pq.offer(new int[]{start, 0});

        int cnt = 0;
        // n개의 정점을 모두 만날 때 까지 반복
        while(!pq.isEmpty() && cnt < v){
            // 큐에서 간선을 하나 뽑는데
            int[] current = pq.poll();
            int vertex = current[0], weight = current[1];
            
            // 간선이 향하는 정점을 이미 방문했었다면 패스
            if (isVisited[vertex])
                continue;

            // 그렇지 않다면 정점 수를 세고 방문 체크를 한다.
            cnt++;
            isVisited[vertex] = true;
            minDistance[vertex] = weight;
            
            //해당 정점에서 방문 가능한 정점들을 큐에 넣는다.
            for (int[] edge : adjList[vertex]){
                // 이미 방문이 된 정점이라면 생략
                if (isVisited[edge[0]])
                    continue;

                // 그렇지 않으면 현 정점에서 방문하지 않은 정점과 그 정점까지의 비용을 큐에 추가
                pq.offer(new int[]{edge[0], minDistance[vertex]+edge[1]});
            }
        }

        // 각 정점까지 거리 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<v+1; i++){
            sb.append(minDistance[i] == Integer.MAX_VALUE? "INF":minDistance[i]).append("\n");
        }
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
