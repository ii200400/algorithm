// 문제 링크 : https://www.acmicpc.net/problem/1463
// 제출 공유 링크(bfs) : http://boj.kr/9de9d6a1f60a422595ae2351a6b53187
// 제출 공유 링크(dp) : http://boj.kr/207436d60c5148c5a5b8fac278a36539

// 원래는 dp로 풀라고 권장하는 문제, 그런데 bfs로 풀었다. 하하핳ㅎ하ㅏㅏ하하하
// 통과하면 답이여~
// 그래도 의리가 있으니 dp로도 풀었다.

package com.baekjoon.problem.java1463;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // bfs를 활용하여 해결
//        bfs(n);

        dp(n);

    }

    // 이름 그대로 bfs 활용
    static void bfs(int n){
        boolean[] visited = new boolean[n+1];   // 방문 채크
        visited[n] = true;  // 초기화

        // 큐 생성 및 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        // 큐가 비워지기 전에 무조건 1이 되는 방법이 있으므로.
        int depth = 0;
        while(!visited[1]){
            int qSize = q.size();   // 깊이 우선 탐색을 위함

            // 특정 깊이에서 도달할 수 있는 위치를 모두 탐색
            for (int i = 0; i<qSize; i++){
                int current = q.poll();

                // 3으로 나눠 떨어지면서 방문한 경험이 없다면
                if (current%3 == 0 && !visited[current/3]){
                    visited[current/3] = true;
                    q.add(current/3);
                }
                // 2로 나눠 떨어지면서 방문한 경험이 없다면
                if (current%2 == 0 && !visited[current/2]){
                    visited[current/2] = true;
                    q.add(current/2);
                }
                // 방문한 경험이 없다면
                if (!visited[current-1]){
                    visited[current-1] = true;
                    q.add(current-1);
                }
            }

            // 깊이 증가!
            depth++;
        }

        // 시간 출력
        System.out.println(depth);
    }

    //
    static void dp(int n){
        // DP 배열
        int[] dp = new int[n+1];

        // n에서 나눠가는 방향이 아니라 1에서 곱하거나 +1 해가는 것으로 탐색을 해보았다.
        for (int i = 2; i<=n; i++){
            int min = Integer.MAX_VALUE;

            // 현 숫자를 3으로 나눌 수 있으면 해당 수를 확인해보고
            if (i%3 == 0){
                min = Math.min(min, dp[i/3]+1);
            }
            // 현 숫자를 2으로 나눌 수 있으면 해당 수도 확인해보고
            if (i%2 == 0){
                min = Math.min(min, dp[i/2]+1);
            }
            // 바로 전의 숫자도, 확인해봐서
            min = Math.min(min, dp[i-1]+1);
            
            // 가장 작은 수를 저장
            dp[i] = min;
        }

        // 1이 n이 되기 위해 필요한 연산 수 출력
        System.out.println(dp[n]);
    }
}
