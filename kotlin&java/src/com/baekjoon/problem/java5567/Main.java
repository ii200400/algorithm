// 문제 링크 : https://www.acmicpc.net/problem/5567
// 제출 공유 링크 : http://boj.kr/64607c169d0845eebcb158f97ffdba32

// 깊이가 2인 BFS 문제, 단순할 것 같다.

package com.baekjoon.problem.java5567;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 상근이의 동기의 수 (정점)
        int m = sc.nextInt();   // 친구 관계를 리스트 (간선)
        boolean[][] adjMatrix = new boolean[n+1][n+1];  // 인접 행렬

        // 인접 행렬 초기화
        for (int i = 0; i<m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjMatrix[from][to] = true;
            adjMatrix[to][from] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisit = new boolean[n+1];
        // 큐와 배열에 상근이 기록
        q.add(1);
        isVisit[1] = true;

        int depth = -1, inviteCnt = 0;  // 해당 사람을 알기 까지 건너야하는 사람의 최소 수, 초대한 사람의 수
        // 큐가 빌때 까지 혹은
        while (!q.isEmpty()){
            depth++;
            // 친구의 친구의 친구까지 방문했다면 탈출
            if (depth == 2)
                break;

            // 현재 큐의 크기만큼 인맥을 살펴본다.
            int qSize = q.size();
            for (int i = 0; i<qSize; i++){
                int current = q.poll();

                // 주변 사람을 둘러보는데
                for (int j = 1; j<n+1; j++){
                    // 해당 사람을 모르거나 이미 초대한 사람이라면 생략
                    if (!adjMatrix[current][j] || isVisit[j])
                        continue;

                    // 그렇지 않으면 초대를 하고 큐에 넣어준다.
                    inviteCnt++;
                    isVisit[j] = true;
                    q.add(j);
                }
            }
        }

        //초대한 사람의 수 출력
        System.out.println(inviteCnt);
    }
}
