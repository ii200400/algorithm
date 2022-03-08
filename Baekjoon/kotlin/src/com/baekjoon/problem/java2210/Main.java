// 문제 링크 : https://www.acmicpc.net/problem/2210
// 제출 공유 링크 : http://boj.kr/17d45476057f4bd2b4ecb7d80edd1638

// 깊이우선탐색으로 방문 확인 없이 진행하라는 지문 그대로 구현해보겠다.
// 아마 맵도 작고.. 시간초과는 안 날 것이다.
// 만들 수 있는 서로 다른 여섯 자리의 수들의 개수는 set 중복불가의 특징을 활용하면 될 것이다.

// .. 0.2초도 안걸린 것은 조금 의외이네;;

package com.baekjoon.problem.java2210;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static HashSet<Integer> set;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[7][7]; // 5*5 숫자판 + 벽 세우기

        
        // 초기화
        for (int i = 0; i<7; i++){
            for (int j = 0; j<7; j++){
                if (i == 0 || i == 6 || j == 0 || j == 6){
                    map[i][j] = -1;
                }else{
                    map[i][j] = sc.nextInt();
                }
            }
        }

        set = new HashSet<>(); // 숫자판으로 만들 수 있는 모든 여섯자리 숫자들
        // 모든 자리에서
        for (int i = 1; i<6; i++){
            for (int j = 1; j<6; j++){
                // 깊이 우선 탐색을 진행해본다.
                dfs(1, i, j, map[i][j]);
            }
        }

        // 만들 수 있는 모든 여섯 자리 수들의 개수를 출력한다.
        System.out.println(set.size());
    }

    static int[] dr = new int[] {1, -1, 0, 0};
    static int[] dc = new int[] {0, 0, 1, -1};

    // 깊이우선탐색 (방문 검색x)
    static void dfs(int cnt, int r, int c, int number){
        // 모든 숫자를 선택했다면
        if (cnt == 6){
            // set에 넣어주고 돌아간다.
            set.add(number);
            return;
        }

        // 현 위치에서 4방위 탐색을 하는데
        for (int i = 0; i<4; i++){
            int nr = r+dr[i];   // 다음 dfs에서 사용한 r과 c (next r, next c)
            int nc = c+dc[i];

            // 맵을 벗어난다면 생략하고
            if (map[nr][nc] == -1)
                continue;

            // 현재 칸의 숫자를 선택하고 진행한다.
            dfs(cnt+1, nr, nc, number*10+map[nr][nc]);
        }
    }
}
