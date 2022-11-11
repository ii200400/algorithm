// 문제 링크 : https://www.acmicpc.net/problem/7562
// 제출 공유 링크 : http://boj.kr/b815e8c5461d421d8b507f293afdc8e9

// 이전에 풀어본 경험이 있는 문제인데 당시에는 속도를 신경쓰지 않고 풀어서 많이 느렸다...
// 그래서 이번에는! 극강의 속도를 추구하면서 풀었다.

package com.baekjoon.problem.java7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 초기화
        int[] dr = new int[] {-2, -2, -1, -1, 1, 1, 2, 2}; // 체스말 이동 r
        int[] dc = new int[] {1, -1, -2, 2, -2, 2, -1, 1}; // 체스말 이동 c
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        // 테스트 케이스 만큼 반복
        for (int t = 0; t<caseNum; t++){
            // 체스판 한 변 길이
            int size = Integer.parseInt(br.readLine());
            // 이중 벽 한번 둘러본다아아악! 다행히도 위치가 아니라 횟수 출력이라서 그나마 괜찮다.
            // 이미 방문 경험이 있거나 벽이면 true 그렇지 않다면 false 으로 저장한다.
            boolean[][] map = new boolean[size+4][size+4];

            // 벽 세우는 중..
            // 벽을 올릴 인덱스들
            int[] makeBlock = new int[]{0, 1, map.length-2, map.length-1};
            for (int idx: makeBlock){
                Arrays.fill(map[idx], true);
            }
            for (int i = 0; i<map.length; i++){
                for (int j : makeBlock){
                    map[i][j] = true;
                }
            }

            // 시작과 끝점 저장 (벽 때문에 인덱스 2 추가)
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken())+2;
            int startC = Integer.parseInt(st.nextToken())+2;
            st = new StringTokenizer(br.readLine());
            int endR = Integer.parseInt(st.nextToken())+2;
            int endC = Integer.parseInt(st.nextToken())+2;

            // 시작점이 목적지라면 바로 출력 후 다음 테스트 케이스로
            if (startR == endR && startC == endC){
                System.out.println(0);
                continue;
            }

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{startR, startC}); // 시작 지점 큐에 추가

            // BFS 시작
            int cnt = 0; // 나이트의 이동 횟수
            outer: while(!q.isEmpty()){
                // 너비만큼 반복
                int currentQSize = q.size();
                // 이동 횟수 증가 (아래의 for문은 현재 이동 횟수+1 인곳을 탐색하기 때문)
                cnt++;
                for (int wideIdx = 0; wideIdx<currentQSize; wideIdx++) {

                    // 큐에서 위치를 받아와
                    int[] loc = q.poll();

                    // 이동할 수 있는 위치 모두 탐색
                    for (int i = 0; i < 8; i++) {
                        int goR = loc[0] + dr[i];
                        int goC = loc[1] + dc[i];

                        // 방문 경험이 있다면 생략
                        if (map[goR][goC])
                            continue;

                        // 목적지에 도착했다면 나머지 연산 생략, while문 탈출
                        if (goR == endR && goC == endC)
                            break outer;

                        // 그렇지 않다면 큐에 넣어준 후 방문 표시
                        q.add(new int[]{goR, goC});
                        map[goR][goC] = true;
                    }
                }
            }

            // 정답 출력
            System.out.println(cnt);
        }
    }
}
