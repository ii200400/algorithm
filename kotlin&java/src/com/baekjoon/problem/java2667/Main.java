// 문제 링크 : https://www.acmicpc.net/problem/2667
// 제출 공유 링크 : http://boj.kr/2e9c5ab599f64ab884fcf8c0b6c54b71
// 백준 단지번호붙이기

// 예전에 풀었던 섬의 개수를 세는? 문제와 비슷해서 똑같이 푼 것 같다.

package com.baekjoon.problem.java2667;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static boolean[][] map;
    static int aptCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 지도 크기
        map = new boolean[n+2][n+2]; // 지도 배열, 아파트가 있는 곳이 true, 주변을 벽으로 둘러싸서 +2

        // 지도 초기화
        for (int i = 1; i<=n; i++){
            String s = sc.next();
            for (int j = 1; j<=n; j++){
                map[i][j] = s.charAt(j-1) == '1';
            }
        }

        // 단지들을 아파트 수로 정렬하기 위해 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++){
                // 지도에서 아직 탐색하지 않은 아파트가 있다면
                if(map[i][j]){
                    // 현재 아파트에 대한 정보를 갱신하고
                    aptCnt = 1;
                    map[i][j] = false;
                    
                    // 인접한 아파트를 확인한 후 단지 수를 +1 한다.
                    dfs(i, j);
                    pq.add(aptCnt);
                }
            }
        }

        // 단지 수 출력
        System.out.println(pq.size());
        while(!pq.isEmpty()){
            // 오름차순으로 각 단지의 아파트 수를 출력
            System.out.println(pq.poll());
        }
    }

    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};

    static void dfs(int r, int c){
        // 4방위 탐색을 해서
        for (int i = 0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];

            // 주변에 아파트가 있다면 방문채크를 해준다.
            if (map[nr][nc]) {
                aptCnt++;
                map[nr][nc] = false;
                dfs(nr, nc);
            }
        }
    }
}
