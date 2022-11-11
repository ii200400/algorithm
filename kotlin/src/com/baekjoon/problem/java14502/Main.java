// 문제 링크 : https://www.acmicpc.net/problem/14502
// 제출 공유 링크 : http://boj.kr/d28c95a39eb343e4933e383d3c092a71

// 2초에.. 최대 크기 8*8.. 완전탐색해도 문제없을 시간이다.
// 조합에다가 bfs까지 사용하는게.. 맞나..?

// 위의 방법이 맞았다, 와.. 어렵지는 않은데 너무 복잡해보인다..

package com.baekjoon.problem.java14502;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m, answer;

    static int[][] map;
    static ArrayList<int[]> virus;
    static ArrayList<int[]> blink;
    static int[][] selectedBlink = new int[3][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 가로 크기
        m = sc.nextInt();   // 세로 크기
        answer = 0;
        map = new int[n][m];    // 연구소
        virus = new ArrayList<>(); // 바이러스 위치
        blink = new ArrayList<>(); // 빈 곳 위치

        // 연구소, 바이러스, 빈곳 초기화
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                map[i][j] = sc.nextInt();

                if (map[i][j] == 2) {   // 바이러스 추가
                    virus.add(new int[]{i, j});
                }else if (map[i][j] == 0){  // 빈 곳 추가
                    blink.add(new int[] {i, j});
                }
            }
        }

        combi(0, 0);

        // 안전지대 출력
        System.out.println(answer);
    }

    /**
     * 벽을 세울 빈 곳의 조합
     *
     * @param cnt 선택한 벽의 수
     * @param idx 탐색을 시작할 blink 인덱스
     */
    static void combi(int cnt, int idx){
        // 빈 곳을
        for (int i = idx; i<blink.size(); i++){
            // 저장하고
            selectedBlink[cnt] = blink.get(i);

            if (cnt == 2){ // 세 곳을 선택했다면 안전지대를 확인한다.
                int[][] tempMap = new int[n][m];

                // 연구실을 복사하고
                for (int j = 0; j<n; j++){
                    tempMap[j] = map[j].clone();
                }
                // 선택한 위치에 벽을 세운다.
                for (int j = 0; j<3; j++){
                    int[] blink = selectedBlink[j];
                    tempMap[blink[0]][blink[1]] = 1;
                }

                // 바이러스를 퍼뜨리고 안전지대를 계산한다.
                spread(tempMap);
                answer = Math.max(answer, countSafeArea(tempMap));

            }else{  // 그렇지 않다면 더 선택한다.
                combi(cnt+1, i+1);
            }
        }
    }

    static int[] dr = new int[] {1, -1, 0, 0};
    static int[] dc = new int[] {0, 0, 1, -1};

    /**
     * 각 위치의 바이러스를 퍼뜨린다.
     *
     * @param map 벽을 세운 연구실 배열
     */
    static void spread(int[][] map){
        // bfs로 바이러스를 퍼뜨린다.
        Queue<int[]> q = new LinkedList<>(virus);
        while(!q.isEmpty()){
            // 현 위치에서
            int[] pos = q.poll();

            // 4방위로 바이러스를 퍼뜨린다.
            for (int i = 0; i<4; i++){
                int r = pos[0]+dr[i];
                int c = pos[1]+dc[i];

                // 범위에서 벗어나면 패스
                if (r < 0 || n <= r || c < 0 || m <= c || map[r][c] != 0)
                    continue;

                // 바이러스를 퍼뜨리고 큐에 저장한다.
                map[r][c] = 2;
                q.add(new int[] {r, c});
            }
        }
    }

    /**
     * 안전지대를 계산하는 함수
     *
     * @param map 벽을 세운 연구실 배열
     * @return 안전지대 수
     */
    static int countSafeArea(int[][] map){
        int cnt = 0;

        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                if (map[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }
}
