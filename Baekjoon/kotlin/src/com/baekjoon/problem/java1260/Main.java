// 문제 링크 : https://www.acmicpc.net/problem/1260
// 제출 공유 링크 : http://boj.kr/ce65c2b2e0494064b4f139e90f0b2943

// 정점번호가 낮은 것 부터 탐색하라는 조건으로
// 인접행렬이 더 구현하기 편해서 인접행렬로 구현할 예정이다.


package com.baekjoon.problem.java1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()) + 1;   // 정점의 수(입력 예제가 1부터 시작이라서 편의상 크기를 +1)
        int m = Integer.parseInt(st.nextToken());   // 간선의 수
        int start = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점

        // 인접 행렬 초기화
        boolean[][] adjMatrix = new boolean[n][n];
        int from, to;
        for (int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            adjMatrix[from][to] = true;
            adjMatrix[to][from] = true;
        }

        // dfs 출력
        boolean[] visited = new boolean[n];
        visited[start] = true;

        dfs(adjMatrix.clone(), visited, start);
        System.out.println();

        // bfs 출력
        visited = new boolean[n];
        visited[start] = true;
        bfs(adjMatrix, visited, start);
    }

    static void dfs(boolean[][] adjMatrix, boolean[] visited, int current){
        // 방문한 곳의 데이터를 출력한다.
        System.out.print(current + " ");

        for (int i = 0; i<n; i++){
            // 방문했었거나 인접하지 않으면 생략한다.
            if(visited[i] || !adjMatrix[current][i])
                continue;

            // visite에 방문했었다는 기록을 남기고
            visited[i] = true;

            // 탐색을 진행한다.
            dfs(adjMatrix, visited, i);
        }
    }

    static void bfs(boolean[][] adjMatrix, boolean[] visited, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        // 큐가 빌 때까지 진행한다.
        while(!q.isEmpty()){
            int current = q.poll();
            System.out.print(current + " ");
            
            for (int i = 0; i<n; i++){
                // 방문했었거나 인접하지 않으면 생략한다.
                if(visited[i] || !adjMatrix[current][i])
                    continue;

                visited[i] = true;
                q.add(i);
            }
        }

    }
}
