// 문제 링크 : https://www.acmicpc.net/problem/4963
// 제출 공유 링크 : http://boj.kr/b9ca341ba1bc4ed4b5a00beb9507d0ec

// dfs로 푼다!

package com.baekjoon.problem.java4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            // 지도의 가로 줄 수, 세로 줄 수
            int c = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
            if (r == 0 && c == 0)   // 종료 조건
                return;

            map = new boolean[r+2][c+2];    // 둘레를 바다로 만들 지도 (바다가 0이므로 바다 초기화 불필요)
            HashSet<int[]> lands = new HashSet<>(); // 육지인 곳을 저장
            // 지도 초기화
            for (int i = 1; i<r+1; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j<c+1; j++){
                    // 지도에 섬 입력
                    map[i][j] = st.nextToken().equals("1");
                    if (map[i][j])
                        // 해시 셋에 섬 후보 추가
                        lands.add(new int[]{i, j});
                }
            }
            
            int island = 0; // 섬의 개수
            for (int[] location: lands){
                // 아직 탐색하지 않은 땅이라면
                if (map[location[0]][location[1]]){
                    // 방문 체크를 하고
                    map[location[0]][location[1]] = false;
                    // dfs 진행
                    dfs(location[0], location[1]);

                    // 섬의 개수 추가~
                    island++;
                }
            }

            // 섬의 개수 출력
            System.out.println(island);
        }
    }

    static int[] dr = new int[]{0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dc = new int[]{1, -1, 0, 0, 1, -1, 1, -1};

    // 한 섬을 모두 탐색하는 dfs
    static void dfs(int r, int c){
        for (int i = 0; i<8; i++){
            // 아직 탐색하지 않은 땅이라면
            if (map[r+dr[i]][c+dc[i]]){
                // 방문 체크를 하고
                map[r+dr[i]][c+dc[i]] = false;
                // dfs 진행
                dfs(r+dr[i], c+dc[i]);
            }
        }
    }
}
