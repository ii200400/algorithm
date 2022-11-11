// 문제 링크 : https://www.acmicpc.net/problem/2636
// 제출 공유 링크 : http://boj.kr/70c4a8421d664c0b9da9e9b2c04fa293
// 백준 치즈

// 생각하고 있는 방법이 1초가 넘는 방법인지 아닌지 계산을 잘 못하겠어서 답답한데..
// 어쩔 수 없이 최대한 빠른 방법으로 해보겠다.

// 처음에는 (0, 0)을 큐에 넣어서 dfs를 진행한다. (해당 부분은 항상 빈 칸이므로)
// dfs는 공기가 있는 부분은 지나가고 치즈를 만나면 큐에 해당 위치를 넣은 후 다른 위치를 탐색한다. (방문채크도 한다.)
// 그 다음부터는 큐에 있는 위치별로 다시 dfs를 진행한다. 그러면 치즈를 한칸씩 파고드는 형상이 된다.
// 물론 dfs는 공기가 없는 부분은 지나가니 치즈 내부 공기층도 문제없다.
// 정리하면.. dfs와 bfs를 동시에 사용하는 방식? ... 어.. 그러네.. ㅇㅁㅇ.. 자각 안하고 만들었다;;

// 그냥 dfs만 써도 패스하는지 궁금하다. 해당 코드는 대략 0.2초가 걸으니.. 되지 않을까?

package com.baekjoon.problem.java2636;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};

    static int n, m;
    static boolean[][] map, visited;
    static Queue<int[]> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 판 세로 길이
        m = sc.nextInt();   // 판 가로 길이
        map = new boolean[n][m];    // 판 배열
        visited = new boolean[n][m];    // 방문 여부

        // 판 초기화
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                map[i][j] = sc.nextInt() == 1;
            }
        }

        // 큐 생성 (bfs 쓰려는 것이 아니고 사라진 치즈를 저장하기 위한 큐)
        q = new LinkedList<>();
        q.add(new int[]{1, 1});

        int qSize = 0;  // 큐의 크기를 저장 (마지막에 사라진 치즈 수)
        int depth = -1; // 치즈가 녹는 시간 (처음에는 녹는 치즈가 아니라 임의의 값이 들어가서 -1)
        while(!q.isEmpty()) {
            qSize = q.size();
            depth++;

            for (int i = 0; i<qSize; i++) {
                int[] current = q.poll();
                dfs(current[0], current[1]);
            }
        }

        // 치즈가 모두 녹아 사라진 시간과 직전에 남아있던 조각 칸 수
        System.out.println(depth);
        System.out.println(depth == 0? 0:qSize);
    }

    static void dfs(int r, int c){
        // 4방위 탐색을 진행한다.
        for (int i = 0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            
            // 탐색위치가 범위를 벗어나면 패스
            if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                continue;
            
            // 이미 방문했다면 패스
            if (visited[nr][nc])
                continue;

            // 방문 채크를 하고
            visited[nr][nc] = true;
            
            // 추가로 치즈가 있는 곳이라면 큐에 위치를 저장한다.
            if (map[nr][nc]){
                q.add(new int[] {nr, nc});
            }else{
                // 치즈가 없는 곳이라면 dfs 계속 진행
                dfs(nr, nc);
            }
        }
    }
}
