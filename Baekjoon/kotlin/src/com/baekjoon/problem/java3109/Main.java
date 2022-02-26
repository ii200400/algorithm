// 문제 링크 : https://www.acmicpc.net/problem/3109
// 제출 공유 링크 : http://boj.kr/f6a5ee7e9edd40f7a871935e7f393143

// 어.. 생각없이 풀다가 주석을 넣으면서 백트래킹할 필요가 없다는 것을 알고 지웠는데
// 다른 친구들은 그것 때문에 시간초과가 많이 났나보다.

package com.baekjoon.problem.java3109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int C, answer;
    static char[][] map;
    static int[] dr = new int[]{-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());   // 세로 칸 수
        C = Integer.parseInt(st.nextToken());   // 가로 칸 수
        answer = 0;     // 이을 수 있는 파이프 수

        map = new char[R+2][C];    // 건물 지도 + 벽
        Arrays.fill(map[0], 'x');       // 지도 벽 세우기
        Arrays.fill(map[R+1], 'x');
        // 지도 초기화
        for (int i = 1; i<=R; i++){
            map[i] = br.readLine().toCharArray();
        }

        // 파이프라인을 위에서부터 하나씩 만들어본다.
        for (int row = 1; row<=R; row++){
            dfs(row, 0);
        }
        
        System.out.println(answer);
    }

    static boolean dfs(int row, int col){
        // 파이프를 끝까지 이었다면
        if (col == C-1) {
            // 정답 기록하고 재귀 탈출
            answer++;
            return true;
        }

        int nextCol = col+1;    // 현 위치에서 오른칸
         for (int r : dr){
            // 현재 위치에서 오른쪽 위, 오른쪽, 오른쪽 아래를 보는데 갈 수 있다면
            if (map[row+r][nextCol] == '.') {
                // 지도에 표시를 하고 진행해보고
                map[row+r][nextCol] = 'x';
                if (dfs(r, nextCol)){ // 함수가 true를 반환하면 바로 나가버린다.
                    return true;
                }
                // 어.. 필요없는 것 같다?
                // 잘 생각해보니.. 다른 파이프가 실패한 길은 다른 파이프가 가도 당연히 실패할테니 복구할 필요가 없다.
//                map[r][nextCol] = '.';
            }
        }

        return false;
    }
}
