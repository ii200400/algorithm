// 문제 링크 : https://www.acmicpc.net/problem/1987
// 제출 공유 링크(방법1) : http://boj.kr/8bb0dbda81524da2891ade56501530cd
// 제출 공유 링크(방법2) : http://boj.kr/03ea4702fbe0497c9c37e76bfcb31f1a
// 제출 공유 링크(방법3) : http://boj.kr/cac6dcefec124937b50703a0362d7202

// 처음에는 dfs만 이용했는데 answer가 26이면 아예 모든 재귀함수를 탈출하는 코드가 좋다고 한다.
// 예전에는 해당방식을 추가했던 것같은데.. 이런..

// boolean 배열을 이용하거나 비트마스킹을 사용하는 방식은 크게 다를바가 없는데
// visit를 활용한 가지치기를 추가하는 방식(방식3)을 사용했더니.. 와.. 6배는 빨라진다.

package com.baekjoon.problem.java1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int R, C, answer;    // 가로 칸수, 세로 칸수, 말이 지날 수 있는 최대 칸수
    static char[][] map;        // 말이 지나다닐 보드
    static boolean[] isUsed;    // 이미 지난 알파벳인지 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R +2][C +2];
        isUsed = new boolean[26];

        // 미로 초기화
        for (int i = 0; i< R; i++){
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j< C; j++){
                map[i+1][j+1] = temp[j];
            }
        }
        // 가장 왼쪽 위의 알파벳으로 벽을 생성..한다. 불편하다..
        char wall = map[1][1];
        Arrays.fill(map[0], wall);
        Arrays.fill(map[R+1], wall);
        for (int i = 0; i<R+2; i++){
            for (int j : new int[]{0, C+1}){
                map[i][j] = wall;
            }
        }
        answer = 0;

        // 현재 위치도 지나는 칸수에 포함되며 벽으로 인하여 1,1 에서 시작

        // 방법1
//        dfs(1, 1, 1);

        // 방법2
//        dfsWithBit(1, 1, 1, 1 << map[1][1] - 'A');

        // 방법3
        visit = new int[R+1][C+1];
        dfsWithVisit(1, 1, 1, 1 << map[1][1] - 'A');

        System.out.println(answer);
    }

    // 4방위 탐색
    static int[] dr = new int[]{1,-1, 0,0};
    static int[] dc = new int[]{0,0, 1,-1};

    // 방법 1
    // 말이 어디까지 움직일지 dfs를 통해 이동시켜본다.
    // 이동 횟수, 가로 칸수, 세로 칸수, 이미 지난 알파벳인지 확인 변수
    static boolean dfs(int cnt, int r, int c){
        // 진행할 때마다 answer값 갱신을 하고
        answer = Math.max(answer, cnt);
        // 정답은 최대 26이므로 26이 나오면 모든 재귀 함수 탈출을 해버린다.
        if (answer == 26)
            return true;

        // 현재 알파벳을 지나간다는 메모를 하고
        int current = map[r][c]-65;
        isUsed[current] = true;

        // 현 위치에서 4방위 탐색을 하는데
        int tempR, tempC;
        for (int i = 0; i<4; i++){
            tempR = r+dr[i];
            tempC = c+dc[i];
            // 지나갈 수 있는 알파벳이라면
            if (!isUsed[map[tempR][tempC]-65]){
                // 다음 위치로 이동한다.
                dfs(cnt+1, r+dr[i], c+dc[i]);
            }
        }
        // 현재 알파벳을 지나갔다는 메모를 지우고 돌아간다.
        isUsed[current] = false;

        return false;
    }

    // 방법 2
    // 위의 코드에 boolean이 아닌 비트마스킹을 사용해본다.
    // 이동 횟수, 가로 칸수, 세로 칸수, 이미 지난 알파벳인지 확인 변수 (비트마스킹)
    static boolean dfsWithBit(int cnt, int r, int c, int bit){
        // 진행할 때마다 answer값 갱신을 하고
        answer = Math.max(answer, cnt);
        // 정답은 최대 26이므로 26이 나오면 모든 재귀 함수 탈출을 해버린다.
        if (answer == 26)
            return true;

        // 현 위치에서 4방위 탐색을 하는데
        int tempR, tempC;
        for (int i = 0; i<4; i++){
            tempR = r+dr[i];
            tempC = c+dc[i];
            // 지나갈 수 있는 알파벳이라면
            if ((bit & 1 << (map[tempR][tempC]-'A')) == 0){
                // 다음 위치로 이동한다.
                dfsWithBit(cnt+1, r+dr[i], c+dc[i], bit | 1 << (map[tempR][tempC]-'A'));
            }
        }

        return false;
    }

    static int[][] visit;

    // 방법 3
    // 위의 비트마스킹과 visit 방문배열로 4배나 더 빠르게 만든 코드 (싸피의 이청님 코드 참고)
    static boolean dfsWithVisit(int cnt, int r, int c, int bit){
        // 진행할 때마다 answer값 갱신을 하고
        answer = Math.max(answer, cnt);
        // 정답은 최대 26이므로 26이 나오면 모든 재귀 함수 탈출을 해버린다.
        if (answer == 26)
            return true;

        visit[r][c] = bit;

        // 현 위치에서 4방위 탐색을 하는데
        int tempR, tempC;
        for (int i = 0; i<4; i++){
            tempR = r+dr[i];
            tempC = c+dc[i];
            // 지나갈 수 있는 알파벳이면서 이전에 방문한 조합이 아니라면
            // ex)
            // A B C
            // B D E
            // C E F
            // A(0, 0)->B(0, 1)->D(1, 1) 를 한 번 방문 할 때
            // D에 A와 B와 D를 방문했다는 비트마스크를(000..1011)를 저장하고
            // 다른 경로이지만 같은 알파벳을 지나쳤다면 ex) A(0, 0)->B(1, 0)->D(1, 1)
            // 같은 비트마스크를(000..1011)가지게 되는데 이 때는 방문을 하지 않는다.
            if ((bit & 1 << (map[tempR][tempC]-'A')) == 0 &&
                    (bit | 1 << (map[tempR][tempC]-'A')) != visit[tempR][tempC]){
                // 다음 위치로 이동한다.
                dfsWithVisit(cnt+1, r+dr[i], c+dc[i], bit | 1 << (map[tempR][tempC]-'A'));
            }
        }

        return false;
    }
}
