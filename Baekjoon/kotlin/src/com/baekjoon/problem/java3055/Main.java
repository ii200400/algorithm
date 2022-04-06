// 문제 링크 : https://www.acmicpc.net/problem/3055
// 제출 공유 링크 : http://boj.kr/c1180250f64d4df6a46a560858304f40
// 백준 탈출

// 물과 고슴도치를 4방위탐색으로 bfs를 각각 사용해주면서 방문채크를 적절히 하였다.

package com.baekjoon.problem.java3055;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();   // 숲의 세로 길이
        int c = sc.nextInt();   // 숲의 가로 길이
        int[][] visited = new int[r][c]; // 숲 방문 배열
        // 물의 경우 2로, 도치의 경우 1로 비버 굴과 바위는 3

        int[] locD = new int[2];    // 굴의 위치
        Queue<int[]> qWaters = new LinkedList<>();   // 펴져나가는 물의 위치
        Queue<int[]> qDoch = new LinkedList<>();   // 이동 중인 도치 위치

        // 숲 방문 배열, 도치 위치, 물의 위치 초기화
        for (int i = 0; i<r; i++){
            String s = sc.next();
            for (int j = 0; j<c; j++){
                char ch = s.charAt(j);
                if (ch == '*'){ // 물인 경우 방문 체크에 큐 삽입
                    visited[i][j] = 2;
                    qWaters.add(new int[] {i, j});
                }else if (ch == 'D'){   // 굴 위치 방문 체크 및 저장
                    visited[i][j] = 3;
                    locD = new int[]{i, j};
                }else if (ch == 'S'){   // 도치 위치 다른 큐에 저장
                    qDoch.add(new int[]{i, j});
                }else if (ch == 'X'){   // 바위 위치 저장
                    visited[i][j] = 3;
                }
                // . 은 별도의 조작이 필요 없다.
            }
        }

        // 4방위
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        int time = 0;   // 시간
        // 도치가 갈 곳이 없을 때까지 반복
        while(!qDoch.isEmpty()){
//            for (int k = 0; k<r; k++){
//                System.out.println(Arrays.toString(visited[k]));
//            }

            time++; // 시간 1 흐를동안 아래의 작업이 진행된다.

            // 물이 범람하는 것을 먼저 연산한다.
            int qSize = qWaters.size();
            for (int i = 0; i<qSize; i++){
                int[] locWater = qWaters.poll();

                // 4방위 탐색
                for (int j = 0; j<4; j++){
                    int nr = locWater[0] + dr[j];
                    int nc = locWater[1] + dc[j];

                    // 범위를 벗어나거나 갈 수 없는 위치(물, 비버굴, 바위)라면 패스
                    if (nr < 0 || nr >= r || nc < 0 || nc >= c || visited[nr][nc] > 1)
                        continue;

                    // 물의 방문체크를 하고 큐에 넣는다.
                    visited[nr][nc] = 2;
                    qWaters.add(new int[] {nr, nc});
                }
            }

            // 도치가 이동할 수 있는 곳을 연산한다.
            qSize = qDoch.size();
            for (int i = 0; i<qSize; i++){
                int[] locDoch = qDoch.poll();

                // 4방위 탐색
                for (int j = 0; j<4; j++){
                    int nr = locDoch[0] + dr[j];
                    int nc = locDoch[1] + dc[j];

                    // 굴에 도착했다면 걸린 시간을 출력하고 프로그램 끝
                    if (nr == locD[0] && nc == locD[1]){
                        System.out.println(time);
                        return;
                    }

                    // 범위를 벗어나거나 갈 수 없는 위치(물, 비버굴, 바위, 이전 방문 위치)라면 패스
                    if (nr < 0 || nr >= r || nc < 0 || nc >= c || visited[nr][nc] != 0)
                        continue;

                    // 물의 방문체크를 하고 큐에 넣는다.
                    visited[nr][nc] = 1;
                    qDoch.add(new int[] {nr, nc});
                }
            }
        }

        // 도치가 이동할 위치가 없다면
        System.out.println("KAKTUS");
    }
}
