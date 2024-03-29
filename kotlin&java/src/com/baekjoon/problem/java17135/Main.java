// 문제 링크 : https://www.acmicpc.net/problem/17135
// 제출 공유 링크 : http://boj.kr/54189582b0bc4136ba2142bd1ce7aa20

// 크기 최대 15칸이고 궁수가 무조건 3마리이니까..
// 15C3 * 3 * 15^3 정도의.. 연산인가??
// 잘 모르겠고 일단 하고 안되면 안되는 걸로.. 시간 없다;;

// 거의 A형 문제인데 이건;;

// 중간에 n이라고 써야할 것을 m이라고 쓰는 바람에.. 찾는데 힘들었다;;
// 그리고.. 자바로 작성했는데도 시간이 0.2초밖에 안걸리다니.. 뭔가 억울하다.

package com.baekjoon.problem.java17135;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, m, d, answer;
    static boolean[][] map;
    static int[] selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 행의 수
        m = sc.nextInt();   // 열의 수
        d = sc.nextInt();   // 궁수 공격 거리 제한
        map = new boolean[n][m];    // 게임 진행 보드판
        blank = new boolean[m]; // 단순히 빈칸 (적이 1칸씩 내려올 때 빈칸이 생기는 곳)
//        int enemyCnt = 0;
//        int[] rowEnemyCnt = new int[n];
//        Arrays.fill(rowEnemyCnt, 0);

        // 보드판 초기화
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                map[i][j] = sc.nextInt() == 1;

//                if (map[i][j]){
//                    enemyCnt++;
//                    rowEnemyCnt[i]++;
//                }
            }
        }

        answer = 0; // 궁수의 공격으로 제거할 수 있는 적의 최대 수 (정답)
        selected = new int[3];  // 각 궁수의 위치 배열
        // 세 궁수들의 위치를 설정한다.
        combi(0, 0);

        // 정답 출력
        System.out.println(answer);
    }

    // 조합
    static void combi(int cnt, int idx){
        // 세 궁수의 위치를 정했다면
        if (cnt == 3){
            // 게임을 진행해본다.
            play();
            return;
        }

        // 한 궁수의 위치를 정한다.
        for (int i = idx; i<m; i++){
            selected[cnt] = i;
            combi(cnt+1, i+1);
        }
    }

    // 왼쪽 위쪽 오른쪽
    static int[] dr = new int[]{0, -1, 0};
    static int[] dc = new int[]{-1, 0, 1};
    static boolean[] blank;

    // 문제 지문에 맞춰 게임 실행
    static void play(){
        int attackCnt = 0;  // 세 궁수가 잡은 적의 수
        int[][] aimTo = new int[3][];   // 궁수가 화살을 적의 위치
        boolean[][] copyMap = new boolean[n][m];    // 보드판 카피 배열
        // 보드판 복사
        for(int i = 0; i<n; i++){
            copyMap[i] = map[i].clone();
        }

//        System.out.println(Arrays.toString(selected));

        // 각 턴마다
        boolean[][] visited;    // 보드판 방문 여부
        for (int i = 0; i<n; i++) {
            // 궁수들이 적을 노리는 위치 초기화
            Arrays.fill(aimTo, new int[]{-1, -1});

            // 각 궁수에 대해
            archer: for (int j = 0; j < 3; j++) {
                // 방문 배열을 초기화하고
                // 가장 가까운 적을 찾기 위해 bfs를 활용한다.
                visited = new boolean[n][m];
                Queue<int[]> q = new LinkedList<>();

                // 궁수 위치를 넣어 큐 초기화
                q.add(new int[]{ n, selected[j] });

                // 사정 거리가 넘지 않는 적을 살펴본다.
                int depth = 1;
                while (depth <= d) {
                    int size = q.size();

                    // 거리가 가까운 순서대로,
                    for (int k = 0; k<size; k++) {
                        int[] pos = q.poll();

                        // 왼쪽, 위쪽, 오른쪽 순서대로 살펴본다.
                        for (int l = 0; l < 3; l++) {
                            int r = pos[0] + dr[l];
                            int c = pos[1] + dc[l];

                            // 범위를 넘거나 이미 방문했다면 패스
                            if (r < 0 || n <= r || c < 0 || m <= c || visited[r][c])
                                continue;

                            // 적이 있다면 적 위치 저장하고 다음 궁수에 대해 작업을 계속한다.
                            if (copyMap[r][c]) {
                                aimTo[j] = new int[]{r, c};
                                continue archer;
                            }

                            // 아니면 방문했다고 기록하고 다른 곳을 살펴본다.
                            visited[r][c] = true;
                            q.add(new int[]{r, c});
                        }
                    }

                    // 거리가 1칸 멀어지는 것 잊지말고 추가
                    depth++;
                }
            }

//            for (int j = 0; j<n; j++) {
//                System.out.println(Arrays.toString(map[j]));
//            }
//            System.out.println(Arrays.deepToString(aimTo));

            // 각 궁수가 적을 쏜다.
            for (int j = 0; j<3; j++){
                // 사정거리안에 적이 없는 경우는 패스
                if (aimTo[j][0] == -1)
                    continue;

                // 다른 궁수가 적을 잡은 상태가 아니라면 잡은 적 수 추가
                if (copyMap[aimTo[j][0]][aimTo[j][1]]){
                    attackCnt++;
                    copyMap[aimTo[j][0]][aimTo[j][1]] = false;
                }
            }

            // 적이 한 칸씩 내려온다.
            // 인텔리제이에서 추천한 알고리즘인데 뭔지 모르겠다;;
//            if (n - 1 - i >= 0) System.arraycopy(copyMap, i, copyMap, i + 1, n - 1 - i);
            for (int j = n-1; j>i; j--){
                copyMap[j] = copyMap[j-1];
            }
            copyMap[i] = blank;
        }

        // 적을 잡은 수를 적절하게 저장한다.
        answer = Math.max(answer, attackCnt);
    }
}
