// 문제 링크 : https://www.acmicpc.net/problem/1194
// 제출 공유 링크 : http://boj.kr/b9c8aabe56f54be381a9140302e3b7e1
// 백준 달이 차오른다, 가자.

// 뭐지;; 참.. 희안한 문제구만; 3중배열 쓴다는 말이 이것이었나보다;;
// 아무래도.. [n][m][64]배열로 메모이제이션이 필요할 것 같다;; 후우.. 미츳나;;
// 일단 bfs를 기본으로.. 방문체크를 하면서 진행할 예정이다.

// 음.. 잘 나왔다. 시간복잡도는 모르겠다;

package com.baekjoon.problem.java1194;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 미로 세로 길이
        int m = sc.nextInt();   // 미로 가로 길이
        char[][] map = new char[n][m];    // 미로 배열
        boolean[][][] visited = new boolean[n][m][64];

        // 레벨 우선 탐색을 위한 큐 [세로 위치, 가로 위치, 열쇠 정보(비트마스킹)]
        Queue<int[]> q = new LinkedList<>();

        // 미로 초기화
        for (int i = 0; i<n; i++){
            String str = sc.next();
            for (int j = 0; j<m; j++){
                map[i][j] = str.charAt(j);

                if (map[i][j] == '0') {   // 큐 초기화
                    visited[i][j][0] = true;
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        // 4방위 탐색에 사용
        int[] dr = new int[] {0, 0, 1, -1};
        int[] dc = new int[] {1, -1, 0, 0};

        int time = 0;
        while (!q.isEmpty()){
            // 레벨 우선 탐색
            int size = q.size();
            time++;
            for (int i = 0; i<size; i++){
                int[] current = q.poll();

                int diff = map[current[0]][current[1]]-'a';
                if (diff >= 0){  // 현 위치에 열쇠가 있다면 줍는다.
                    current[2] = current[2] | 1<<diff;
                }

                // 4방위 탐색
                for (int j = 0; j<4; j++){
                    int nr = current[0]+dr[j];
                    int nc = current[1]+dc[j];
                    
                    // 미로의 범위를 벗어나거나 벽이거나 방문을 했었다면 패스
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == '#' || visited[nr][nc][current[2]])
                        continue;

                    char tempChar = map[nr][nc];
                    // 출구에 도착하면 걸린 최소 시간을 출력하고 프로그램 종료
                    if (tempChar == '1'){
                        System.out.println(time);
                        return;
                    }

                    // 문이 있다면
                    int keyIdx = tempChar - 'A';
                    if (keyIdx <= 5 && keyIdx >= 0){
                        // 열쇠가 있는 경우가 아니라면 패스한다.
                        if ((current[2] & 1<<keyIdx) == 0){
                            continue;
                        }
                    }

                    // 방문 체크를 하고 큐에 추가
                    visited[nr][nc][current[2]] = true;
                    q.add(new int[] {nr, nc, current[2]});
                }
            }
        }

        // 미로를 탈출하지 못한 경우
        System.out.println(-1);
    }
}
