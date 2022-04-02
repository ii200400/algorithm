// 문제 링크 : https://www.acmicpc.net/problem/2206
// 제출 공유 링크 : http://boj.kr/b14f9993800d41cea4d2289d1a44e258
// 백준 벽 부수고 이동하기

// 음.. 시간은 2초인데 맵이 최대 1000 * 1000...
// 메모리가 애매하게 192인것은 또 무엇이지;;
// bfs로 풀어볼 예정이다.. 메모리초과가 일어나지 않았으면 좋겠다.

package com.baekjoon.problem.java2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 맵의 가로 줄 수
        int m = Integer.parseInt(st.nextToken());   // 맵의 세로 줄 수
        boolean[][] wall = new boolean[n][m];    // 맵 배열
        // [가로][가로][벽을 부수었을 때 방문 여부, 안부수었을 때 방문 여부]
        boolean[][][] visited = new boolean[n][m][2];   // 각 위치별
        
        // 맵 배열 초기화
        for (int i = 0; i<n; i++){
            String s = br.readLine();
            for (int j = 0; j<m; j++){
                wall[i][j] = s.charAt(j) - '0' == 1;
            }
        }

        // 큐 생성
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});  // 가로, 세로, 벽을 부순지 여부(0이 놉, 1 예스)
        visited[0][0][0] = true;

        int[] dr = new int[] {1, -1, 0, 0};
        int[] dc = new int[] {0, 0, 1, -1};
        
        // bfs 시작
        int depth = 1;  // 시작 위치도 카운트하는 것 같다.
        while(!visited[n-1][m-1][0] && !visited[n-1][m-1][1] && !q.isEmpty()){
            depth++;

            // 깊이 우선 탐색 진행
            int qSize = q.size();
            for (int i = 0; i<qSize; i++){
                int[] current = q.poll();
                int r = current[0]; // 행 위치
                int c = current[1]; // 열 위치
                boolean isBreak = current[2]==1;   // 벽을 부수었는지, 이미 부순상태라면 true

                // 4방위 탐색
                for (int j = 0; j<4; j++){
                    int nr = r+dr[j];
                    int nc = c+dc[j];
                    
                    // 탐색 범위가 벗어나면 패스
                    if (nr < 0 || nr >=n || nc < 0 || nc >= m)
                        continue;

                    if (visited[nr][nc][0]) {
                        // 벽을 부수지 않은 상태에서 예전에 방문했다면 패스
                        // (더 빠르게 벽도 안부수고 지나가면 더 좋은 방법으로 진행을 이미 했다는 것)
                        continue;
                    }else if (!isBreak){
                        // 벽을 부수지 않은 상태에서 방문한 경험이 없는 곳에 벽을 부시지 않은 상태로 도착했다면
                        // 그런데 여기에 벽이 있다면
                        if (wall[nr][nc]) {
                            visited[nr][nc][1] = true;
                            q.add(new int[]{nr, nc, 1});
                        }else{  // 벽이 없다면
                            visited[nr][nc][0] = true;
                            q.add(new int[]{nr, nc, 0});
                        }
                    }else if(visited[nr][nc][1]){
                        // 벽을 부순 상태로 이미 지나간 경험이 있는곳에 벽은 부순 채로 도착해도 패스
                        continue;
                    }else{
                        // 한번도 오지 않을 곳에 벽을 부순 채로 도착했는데
                        // 벽이 없다면 기록한다.
                        if (!wall[nr][nc]) {
                            visited[nr][nc][1] = true;
                            q.add(new int[]{nr, nc, 1});
                        }
                    }
                }
            }
        }

        // 최단거리 출력
        if (q.isEmpty()){
            System.out.println(-1);
        }else {
            System.out.println(depth);
        }
    }
}
