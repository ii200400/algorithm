// 문제 링크 : https://www.acmicpc.net/problem/1956
// 제출 공유 링크 : http://boj.kr/c744005856bb4504a184f8dc5ec7ec4f
// 백준 운동

// 아.. 다익스트라인줄 알고 거의 다 풀었는데 무언가 시작 마을을 주지 않았더니만..
// 아무래도 플로이드 워샬 변형문제 같다.

// 처음만들어봐서 그런건지, 변형 문제를 접해서인지;; 엄청 많이 시도했다;;
// 절반은 min으로 해야할 것을 max로 해서, max라고 할것을 min이라고해서 틀렸다.. 후욱..

package com.baekjoon.problem.java1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());   // 마을 수 (정점 수)
        int e = Integer.parseInt(st.nextToken());   // 도로 수 (간선 수)
        int[][] adjMatrix = new int[v+1][v+1]; // 인접행렬

        // 인접행렬 초기화
        for (int i = 1; i<=v; i++){
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            adjMatrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        // 플로이드 워샬 알고리즘
        for (int k = 1; k<=v; k++){ // 경로
            for (int i = 1; i<=v; i++){ // 출발점
                if (k == i || adjMatrix[i][k] == Integer.MAX_VALUE) continue;
                
                for (int j = 1; j<=v; j++){ // 도착점 (순환되는 것을 찾기 위해 i == j인 경우는 빼지 않았다.)
                    if (k == j || adjMatrix[k][j] == Integer.MAX_VALUE) continue;
                    adjMatrix[i][j] = Math.min(adjMatrix[i][k] + adjMatrix[k][j], adjMatrix[i][j]);
                }
            }
        }

        // 자신의 마을로 돌아오는 경로들 중 가장 짧은 길을 출력한다.
        int min = Integer.MAX_VALUE;
        for (int i = 1; i<=v; i++){
//            System.out.println(Arrays.toString(adjMatrix[i]));
            if (adjMatrix[i][i] == Integer.MAX_VALUE) continue;
            min = Math.min(min, adjMatrix[i][i]);
        }
        // 없다면 -1을 출력한다.
        System.out.println(min == Integer.MAX_VALUE? -1:min);
    }
}
