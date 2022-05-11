// 문제 링크 : https://www.acmicpc.net/problem/14938
// 제출 공유 링크 : http://boj.kr/371662f58daf4461913ac9186461c6be
// 백준 서강그라운드

// 왜 이렇게.. 푼 것 같은 느낌이 드는 걸까..?
// 이름만 다르고 비슷한 문제를 풀었거나, 문제를 읽기만하고 안 풀었던 것 같다.
// 한 점에서 다른 점까지 최소 거리를 구하는 문제이므로 다익스트라를 사용해서 풀 것이다.
// 그리고 간선이 너무.. 적어서; 인접 리스트를 사용할 예정이다.

// 아;; 예은이가 떨어지는 지점을 제공하는 줄 알았는데 아니였다. 플로이드 워셜로 풀겠다.

package com.baekjoon.problem.java14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 지역의 개수
        int m = Integer.parseInt(st.nextToken());   // 수색 범위
        int r = Integer.parseInt(st.nextToken());   // 길의 개수
        int[] items = new int[n+1]; // 각 지역의 아이탬 수
        int[][] adjMatrix = new int[n+1][n+1];    // 인접행렬

        // 아이탬 수 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        // 인접리스트 초기화
        for (int i = 1; i<=n; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i<r; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = dis;
            adjMatrix[to][from] = dis;
        }

        // 플로이드 워셜 알고리즘 진행
        for (int k = 1; k<=n; k++){
            for (int i = 1; i<=n; i++){
                if (k == i || adjMatrix[i][k] > m) continue;

                for (int j = 1; j<=n; j++){
                    if (k == j || i == j || adjMatrix[k][j] > m) continue;

                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
                }
            }
        }
        
        // 각 위치별로 얻을 수 있는 최대 아이템 계산
        int max = 0;
        for (int i = 1; i<=n; i++){
            int itemCnt = 0;
            for (int j = 1; j<=n; j++){
                if (adjMatrix[i][j] <= m || i == j)
                    itemCnt += items[j];
            }

            max = Math.max(max, itemCnt);
        }

        // 최대 아이템 개수를 출력
        System.out.println(max);
    }
}
