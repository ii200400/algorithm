// 문제 링크 : https://www.acmicpc.net/problem/11581
// 제출 공유 링크 : http://boj.kr/f4ed08b36e674e6aa81c41c712043bd4
// 백준 구호물자

// bfs로 돌리면서 방문 체크한 곳이 나오면 바로 사이클을 출력해주면 될 것 같다.
// 어.. 그냥 사이클을 구하는 문제인 줄 알았는데..
// 잘 보니 n 번 교차로를 가는 길목 중에서 사이클이 있는지를 판단해야 한다;;
// 코딩이 아니라 거의 국어문제..; 나중에 풀겠다.

// 아.. 진짜.. 잘 이해했는데 오히려 질문보고 잘못 이해해서 다시 작성했다;;
// 처음에 bfs를 써서 풀었는데 오히려 dfs로 풀어야만 가능한 문제여서 틀렸던 것이다;;

package com.baekjoon.problem.java11581;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static boolean[][] adjMatrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 교차로 수
        adjMatrix = new boolean[n+1][n+1];  // 인접행렬

        // 인접행렬 초기화
        for (int i = 1; i<n; i++){
            int e = sc.nextInt();
            for (int j = 0; j<e; j++){
                adjMatrix[i][sc.nextInt()] = true;
            }
        }

        // dfs 시작
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        if(dfs(1, visited)){
            System.out.println("CYCLE");
        }else {
            System.out.println("NO CYCLE");
        }
    }

    // 해당 문제는 bfs를 사용하면 사이클 확인이 어렵기 때문에 dfs를 사용한다.
    // 일반적인 dfs에 한번 true를 반환(사이클이 발생)하면 그대로 모든 재귀함수를 나갈 수 있도록 설계하였다.
    static boolean dfs(int num, boolean[] visited){
        for (int i = 1; i<=n; i++){
            if (!adjMatrix[num][i])
                continue;

            if (visited[i]){
                return true;
            }

            visited[i] = true;
            if (dfs(i, visited))
                return true;
            visited[i] = false;
        }

        return false;
    }
}
