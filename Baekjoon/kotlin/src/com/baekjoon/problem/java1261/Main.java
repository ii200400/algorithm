// 문제 링크 : https://www.acmicpc.net/problem/1261
// 제출 공유 링크 : http://boj.kr/0049101073734a1ebd6f53d381255051
// 백준 알고스팟

// 뭔가.. 그.. `말이 되고싶은 원숭이`?랑 `벽부수고 이동하기`를 반대로 뒤집은 것 같은 느낌의 문제이다.
// 많이 비슷하게 작성할 것 같다..
// 즉, 다익스트라?를 활용할 예정

// 패스했다, 그렇다. 조건문 몇개와 부등호만 다르다.
// 지금 생각났는데 젤다문제?를 거의 똑같이 풀었던 것 같은데 가물가물하다..

package com.baekjoon.problem.java1261;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();   // 가로 크기
        int n = sc.nextInt();   // 세로 크기
        boolean[][] map = new boolean[n][m];    // 미로 배열 (true가 벽 false가 빈 방)
        int[][] visited = new int[n][m];    // 방문 배열, 해당 위치에서 벽을 가장 적게 부수고 도착했을 때 부순 벽의 수

        // 방문 배열 초기화
        for (int i = 0; i<n; i++){
            Arrays.fill(visited[i], 10000);
        }
        visited[0][0] = 0;

        // 미로 초기화
        for (int i = 0; i<n; i++){
            String s = sc.next();
            for (int j = 0; j<m; j++){
                map[i][j] = s.charAt(j)=='1';
            }
        }
        
        // 예외처리
        if (n == 1 && m == 1){
            System.out.println(0);
            return;
        }

        // 4방위 탐색
        int[] dr = new int[] {1, -1, 0, 0};
        int[] dc = new int[] {0, 0, 1, -1};

        // [세로 위치, 가로 위치, 가중치]를 저장하고 가중치를 기준으로 정렬해주는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[2]));
        pq.offer(new int[] {0, 0, 0});

        // 벽을 최소로 부수고 도착하는 경우 찾기
        while (!pq.isEmpty()){
            int[] current = pq.poll();
            int r = current[0];
            int c = current[1];
            int weight = current[2];

            // 4방위 탐색
            for (int i = 0; i<4; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                
                // 범위를 벗어나면 패스
                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;

                // 원하는 곳에 도착했다면
                if (nr == n-1 && nc == m-1){
                    System.out.println(weight); // (도착지는 항상 뚫려 있으므로)
                    return;
                }

                // 더 벽을 많이 부수는 경우도 패스
                int nWeight = weight+(map[nr][nc]? 1:0);
                if (visited[nr][nc] <= nWeight)
                    continue;

                // 우선순위 큐에 추가
                visited[nr][nc] = nWeight;
                pq.offer(new int[] {nr, nc, nWeight});
            }
        }
    }
}
