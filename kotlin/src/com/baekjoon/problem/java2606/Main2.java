package com.baekjoon.problem.java2606;

// 예전에 풀긴 했는데 사진만 기억나서 그대로 풀려고 한다.
// 음.. 서로소 집합도 생각했는데 번거롭고 그냥 dfs, bfs로 풀려고 한다.
// 그래프 표현은 인접행렬로 할 예정

// 예전 코드를 보니 엄청나게 메모리를 아끼면서 했다;;
// 어떻게 인접리스트를 사용하긴 했는데 별도의 배열 없이 방문체크까지 했..다;;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 컴퓨터의 수
        int e = sc.nextInt();   // 연결 선 수
        boolean[][] adjMatrix = new boolean[n+1][n+1];  // 인접행렬
        boolean[] visited = new boolean[n+1];   // 방문체크 배열
        
        // 인접행렬 초기화
        for (int i = 0; i<e; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            adjMatrix[from][to] = true;
            adjMatrix[to][from] = true;
        }

        // bfs로 진행
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        int cnt = 0;    // 1번 컴퓨터에 의해 바이러스에 걸린 컴퓨터 수
        while (!q.isEmpty()){
            int current = q.poll();

            for (int i = 1; i<=n; i++){
                // 연결이 되어있지 않거나 이미 바이러스에 걸리면 생략
                if (!adjMatrix[current][i] || visited[i])
                    continue;

                visited[i] = true;
                q.add(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
