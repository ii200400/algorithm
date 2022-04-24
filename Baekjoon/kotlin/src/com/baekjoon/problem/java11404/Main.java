// 문제 링크 : https://www.acmicpc.net/problem/11404
// 제출 공유 링크 : http://boj.kr/43c317a357e147f3928b7eb6d03a1927
// 백준 플로이드

// 말 그대로 플로이드 워셜 알고리즘 구현 문제
// 최대 이동 비용은 다행히도 int 를 넘지 않아서 배운 그대로 작성하면 될 것 같다.

// 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다는 글을 왜인지 몰라도 안읽고 지나가서 왜 안되는지 해매었다;;
// 플로이드 워셜 알고리즘 특성상 시간복잡도는 O(n^3)

package com.baekjoon.problem.java11404;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 도시 개수
        int m = sc.nextInt();   // 버스 개수
        int[][] adjMatrix = new int[n+1][n+1];  // 인접 행렬

        // 인접행렬 초기화
        for (int i = 1; i<=n; i++){
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            // 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있으므로 가장 싼 것 하나만 저장
            adjMatrix[from][to] = Math.min(adjMatrix[from][to], sc.nextInt());
        }

        // 플로이드 워셜
        for (int k = 1; k<=n; k++){
            for (int i = 1; i<=n; i++){
                if (k == i || adjMatrix[i][k] == Integer.MAX_VALUE) continue;

                for (int j = 1; j<=n; j++){
                    if (k == j || i == j || adjMatrix[k][j] == Integer.MAX_VALUE) continue;

                    // 최단거리 갱신
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }

        // 도시별 이동 최소 비용
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++){
                System.out.print((adjMatrix[i][j] == Integer.MAX_VALUE? 0:adjMatrix[i][j]) + " ");
            }
            System.out.println();
        }
    }
}
