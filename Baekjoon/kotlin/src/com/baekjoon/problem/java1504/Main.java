// 문제 링크 : https://www.acmicpc.net/problem/1504
// 제출 공유 링크 : http://boj.kr/32db78bbad594c46b5f1cc7b1db96869
// 백준 특정한 최단 경로

// 다익스트라로 풀면.. 귀찮아서 플로이드 워셜로 풀겠다.

// 아니.. 정점 n을 중간에 들리면 안되는 줄 알고,
// v1 != n, v2 != 1은 숙지를 했는데 v1 != 1, v2 != n 조건도 있는 줄 알고 오해해서,
// 중간에 스스로 깨달았지만, 최단 이동 거리는 최대 799*1000인데 inf 값을 1001로 하는.. 웃기지도 않는 짓을 해서
// 시도를 엄청많이 했다..

package com.baekjoon.problem.java1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());    // 정점 개수
        int e = Integer.parseInt(st.nextToken());    // 간선 개수
        int[][] adjMatrix = new int[n+1][n+1];      // 특정 간선까지 최단 경로

        // 최단경로 초기화 (인접행렬)
        for (int i = 1; i<=n; i++){
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
            adjMatrix[i][i] = 0;
        }
        for (int i = 0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = weight;
            adjMatrix[to][from] = weight;
        }

//        for (int i = 0; i<n; i++){
//            System.out.println(Arrays.toString(adjMatrix[i]));
//        }

        // 반드시 거쳐야하는 두 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 플로이드 워셜 알고리즘 작업
        for (int k = 1; k<=n; k++){
            for (int i = 1; i<=n; i++){
                if (k == i || adjMatrix[i][k] == Integer.MAX_VALUE) continue;

                for (int j = 1; j<=n; j++){
                    if (k == j || i == j || adjMatrix[k][j] == Integer.MAX_VALUE) continue;

                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
                }
            }
        }

//        for (int i = 0; i<n; i++){
//            System.out.println(Arrays.toString(adjMatrix[i]));
//        }

        // v1과 v2를 거치는 경로 출력
        int answer = Integer.MAX_VALUE;
        if (adjMatrix[1][v1] != Integer.MAX_VALUE && adjMatrix[v1][v2] != Integer.MAX_VALUE && adjMatrix[v2][n] != Integer.MAX_VALUE){
            answer = adjMatrix[1][v1] + adjMatrix[v1][v2] + adjMatrix[v2][n];
        }
        if (adjMatrix[1][v2] != Integer.MAX_VALUE && adjMatrix[v2][v1] != Integer.MAX_VALUE && adjMatrix[v1][n] != Integer.MAX_VALUE){
            answer = Math.min(answer, adjMatrix[1][v2] + adjMatrix[v2][v1] + adjMatrix[v1][n]);
        }

        System.out.println(answer == Integer.MAX_VALUE? -1:answer);
    }
}
