// 문제 링크 : https://www.acmicpc.net/problem/16236
// 제출 공유 링크 : http://boj.kr/7070132c60d648b499eff2b513ef1f87

// 가까운 물고기를 탐색하는데 무조건 bfs를 쓰되
// 우선순위가 위쪽 왼쪽이므로, 탐색은 위 왼 오 아래 로 해야만 한다.
// 그래야 큐에 우선적으로 위쪽, 왼쪽인 것부터 들어갈테니까..
// 또 크기를 신경써야 하는 것까지.. 조건문이 좀 많아 보인다.

// .. 아 위의 탐색으로는 우선순위를 못채워서 따로 우선순위에 맞는 위치를 선정하도록 코드를 바꾸었다.
// 아이고난!

package com.baekjoon.problem.java16236;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};

        int n = sc.nextInt();   // 공간 크기
        int[][] map = new int[n+2][n+2];    // 공간 상태
        int[] location = new int[]{0, 0};   // 아기 상어 위치 (r, c)

        // 예외처리를 없애기 위해 주변을 대충 400으로 벽 세우기
        Arrays.fill(map[0], 400);
        Arrays.fill(map[n+1], 400);
        for (int i = 1; i<n+1; i++){
            for (int j : new int[]{0, n+1}){
                map[i][j] = 400;
            }
        }

        // 공간 초기화
        for (int i = 1; i<n+1; i++){
            for (int j = 1; j<n+1; j++){
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9){
                    location[0] = i;
                    location[1] = j;
                    map[i][j] = 0;
                }
            }
        }

        boolean isEat;   // 먹을 수 있는 물고기가 있는지 여부
        int babySize = 2, eatCnt = 0;   // 아기 상어 크기, 먹은 물고기 수
        boolean[][] isVisited;  // 해당 위치 방문 확인
        Queue<int[]> q; // bfs에 사용할 큐
        int[] nextLoc;    // 다음 먹을 물고기가 있는 곳
        int totalDistance = 0;  // 총 이동 거리

        // 탐색을 일단 한다
        do{
            // 초기화
            isEat = false;
            isVisited = new boolean[n+2][n+2];
            isVisited[location[0]][location[1]] = true;
            q = new LinkedList<>();
            q.add(location);
            nextLoc = new int[]{n+2, n+2};

            int distance = 0;   // 다음 먹을 물고기가 있는 곳까지 거리
            while(!q.isEmpty()){
                distance++;

                // 한 깊이를 한꺼번에 탐색
                int size = q.size();
                for (int i = 0; i<size; i++){
                    int[] current = q.poll();

                    // 같은 깊이의 위치마다 4방위 탐색
                    for (int j = 0; j<4; j++){
                        // 탐색하는 곳이
                        int r = current[0] + dr[j], c = current[1] + dc[j];

                        // 방문한 적이 있거나 더 큰 물고기가 있다면 패스
                        if (isVisited[r][c] || map[r][c] > babySize)
                            continue;

                        // 그렇지 않다면 방문 체크를 하고
                        isVisited[r][c] = true;

                        if (map[r][c] == babySize || map[r][c] == 0)
                            // 같은 크기의 물고기이거나 빈 공간이라면 지나가고
                            q.add(new int[]{r, c});
                        else{
                            // 작은 크기의 물고기라면 더 선호하는 위치의 물고기를 기억해둔다.
                            isEat = true;
                            if (nextLoc[0] > r || (nextLoc[0] == r && nextLoc[1] > c)){
                                nextLoc[0] = r;
                                nextLoc[1] = c;
                            }
                        }
                    }
                }

                // 무엇보다 가까운 물고기가 우선이므로 먹을 수 있는 물고기를 찾았다면 반복문 탈출
                if (isEat)
                    break;
            }

            // 디버깅용 출력
//            for (int k = 0; k<n+2; k++){
//                System.out.println(Arrays.toString(map[k]));
//            }
//            System.out.println(nextLoc[0] + " " + nextLoc[1] + " " + babySize);

            // 탐색을 마친 후
            if(isEat) { // 먹을 수 있는 물고기가 있었다면
                // 생각했던 위치의 물고기를 먹는다.
                totalDistance += distance;
                map[nextLoc[0]][nextLoc[1]] = 0;
                location[0] = nextLoc[0];
                location[1] = nextLoc[1];

                eatCnt++;
                if (eatCnt == babySize) {
                    babySize++;
                    eatCnt = 0;
                }
            }
            
        } while(isEat); // 물고기를 먹었다면 탐색을 또 한다.

        // 총 이동거리를 출력한다.
        System.out.println(totalDistance);
    }
}
