// 문제 링크 : https://www.acmicpc.net/problem/14442
// 제출 공유 링크 : http://boj.kr/e248ab2be71c405f98ff52472a1452f9
// 백준 벽 부수고 이동하기 2

// 이전의 벽 부수고 이동하기를 일반화 시키는 바람에 이 문제도 풀 수 있는지 확인하기 위해서 복붙해왔다.
// 여기에 추가로 입력되는 k를 처리했더니 그대로 통과 되었는데.. 4초가 넘는다;; 으어;;

package com.baekjoon.problem.java14442;

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
        int k = Integer.parseInt(st.nextToken());   // 뚫을 수 있는 벽 수
        boolean[][] wall = new boolean[n][m];    // 맵 배열
        // [세로 칸수][가로 칸수]
        int[][] visited = new int[n][m];   // 각 위치별

        // 예외처리
        if (n == 1 && m == 1){
            System.out.println(1);
            return;
        }

        // 맵 배열 초기화
        for (int i = 0; i<n; i++){
            String s = br.readLine();
            for (int j = 0; j<m; j++){
                wall[i][j] = s.charAt(j) - '0' == 1;
            }
        }

        // 큐 생성
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, k+1});  // 가로, 세로, 벽을 부순지 여부(k+1은 k번 부술 수 있는 것 - visited 방문배열 초기화가 0이라서)
        visited[0][0] = k+1;

        int[] dr = new int[] {1, -1, 0, 0};
        int[] dc = new int[] {0, 0, 1, -1};

        // bfs 시작
        int depth = 1;  // 시작 위치도 카운트하는 것 같다.
        while(!q.isEmpty()){
            depth++;

            // 깊이 우선 탐색 진행
            int qSize = q.size();
            for (int i = 0; i<qSize; i++){
                int[] current = q.poll();
                int r = current[0]; // 행 위치
                int c = current[1]; // 열 위치
                int broken = current[2];    // 벽을 부순지 여부(1 예스, 2이 놉)

                // 4방위 탐색
                for (int j = 0; j<4; j++){
                    int nr = r+dr[j];
                    int nc = c+dc[j];

                    // 원하는 위치에 도착하면
                    if (nr == n-1 && nc == m-1){
                        // 정답 출력 후 프로그램 종료
                        System.out.println(depth);
                        return;
                    }

                    // 탐색 범위가 벗어나거나 적절한 상태에 도달하지 못했다면 패스
                    // 적절한 상태는.. 이전에 방문을 하지 않았거나, 벽을 많이 부순 상태에서 방문한 곳을 벽을 덜 부순 상태에서 한번 더 탐색하게 되었을 때
                    if (nr < 0 || nr >=n || nc < 0 || nc >= m || visited[nr][nc] >= broken)
                        continue;

                    // 벽이 있는 곳인데
                    if (wall[nr][nc]){
                        // 벽을 부술 수 있다면 방문 처리를 하고 큐에 적절히 저장한다.
                        if (broken >= 2){
                            visited[nr][nc] = broken-1;
                            q.add(new int[]{nr, nc, broken-1});
                        }
                    }else{  // 빈 공간이라면 평소처럼 방문처리를 하고 큐에 적절히 저장한다.
                        visited[nr][nc] = broken;
                        q.add(new int[]{nr, nc, broken});
                    }
                }
            }
        }

        // 도착할 수 없다면 -1 출력
        System.out.println(-1);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());   // 맵의 가로 줄 수
//        int m = Integer.parseInt(st.nextToken());   // 맵의 세로 줄 수
//        boolean[][] wall = new boolean[n][m];    // 맵 배열
//        // [세로 칸수][가로 칸수][벽을 부수었을 때 방문 여부, 안부수었을 때 방문 여부]
//        boolean[][][] visited = new boolean[n][m][2];   // 각 위치별
//        
//        // 맵 배열 초기화
//        for (int i = 0; i<n; i++){
//            String s = br.readLine();
//            for (int j = 0; j<m; j++){
//                wall[i][j] = s.charAt(j) - '0' == 1;
//            }
//        }
//
//        // 큐 생성
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{0, 0, 0});  // 가로, 세로, 벽을 부순지 여부(0이 놉, 1 예스)
//        visited[0][0][0] = true;
//
//        int[] dr = new int[] {1, -1, 0, 0};
//        int[] dc = new int[] {0, 0, 1, -1};
//        
//        // bfs 시작
//        int depth = 1;  // 시작 위치도 카운트하는 것 같다.
//        while(!visited[n-1][m-1][0] && !visited[n-1][m-1][1] && !q.isEmpty()){
//            depth++;
//
//            // 깊이 우선 탐색 진행
//            int qSize = q.size();
//            for (int i = 0; i<qSize; i++){
//                int[] current = q.poll();
//                int r = current[0]; // 행 위치
//                int c = current[1]; // 열 위치
//                boolean isBreak = current[2]==1;   // 벽을 부수었는지, 이미 부순상태라면 true
//
//                // 4방위 탐색
//                for (int j = 0; j<4; j++){
//                    int nr = r+dr[j];
//                    int nc = c+dc[j];
//                    
//                    // 탐색 범위가 벗어나면 패스
//                    if (nr < 0 || nr >=n || nc < 0 || nc >= m)
//                        continue;
//
//                    if (visited[nr][nc][0]) {
//                        // 벽을 부수지 않은 상태에서 예전에 방문했다면 패스
//                        // (더 빠르게 벽도 안부수고 지나가면 더 좋은 방법으로 진행을 이미 했다는 것)
//                        continue;
//                    }else if (!isBreak){
//                        // 벽을 부수지 않은 상태에서 방문한 경험이 없는 곳에 벽을 부시지 않은 상태로 도착했다면
//                        // 그런데 여기에 벽이 있다면
//                        if (wall[nr][nc]) {
//                            visited[nr][nc][1] = true;
//                            q.add(new int[]{nr, nc, 1});
//                        }else{  // 벽이 없다면
//                            visited[nr][nc][0] = true;
//                            q.add(new int[]{nr, nc, 0});
//                        }
//                    }else if(visited[nr][nc][1]){
//                        // 벽을 부순 상태로 이미 지나간 경험이 있는곳에 벽은 부순 채로 도착해도 패스
//                        continue;
//                    }else{
//                        // 한번도 오지 않을 곳에 벽을 부순 채로 도착했는데
//                        // 벽이 없다면 기록한다.
//                        if (!wall[nr][nc]) {
//                            visited[nr][nc][1] = true;
//                            q.add(new int[]{nr, nc, 1});
//                        }
//                    }
//                }
//            }
//        }
//
//        // 최단거리 출력
//        if (q.isEmpty()){
//            System.out.println(-1);
//        }else {
//            System.out.println(depth);
//        }
//    }
}
