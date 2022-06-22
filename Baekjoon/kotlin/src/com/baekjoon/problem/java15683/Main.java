// 문제 링크 : https://www.acmicpc.net/problem/15683
// 제출 공유 링크 : http://boj.kr/85fe84daa0b3447190e84b141feba667
// 백준 감시

// 보기만해도 머리가 아픈 문제.. 어휴..
// 일단 벽을 두르는 것을 거의 필수같다.

// 순수한 완전탐색 노가다 문제
// 너무 코드가 길어서 중간에 조건문 빼먹은 것이나 변수를 바꿔서 쓴 것이 꽤 있었다.

package com.baekjoon.problem.java15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    
    static int r, c, minBlindSpot;
    static char[][] map;
    static int[][] cctvs;
    static int cctvNum;

    static HashMap<Integer, int[]> directionPerType = new HashMap<>();
    // 오른쪽 위쪽 왼쪽 아래쪽 (순서 중요하다)
    static int[][] ds = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());   // 세로 칸 수
        c = Integer.parseInt(st.nextToken());   // 가로 칸 수
        minBlindSpot = Integer.MAX_VALUE;       // 최소 사각지대

        map = new char[r+2][c+2];   // 사무실 (벽 때문에 +2)
        cctvs = new int[8][4];       // cctv 갯수(최대로 8개이기 때문에 일단 8로 선언)별 위치와 종류와 설치 방향
        // 사무실 초기화
        for (int i = 1; i<=r; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j<=c; j++){
                map[i][j] = st.nextToken().charAt(0);

                // cctv가 있다면
                if (map[i][j] != '0' && map[i][j] != '6'){
                    // cctv 배열에 저장 (위치x, 위치y, cctv종류, 설치방향)
                    cctvs[cctvNum++] = new int[]{i, j, map[i][j]-48, 0};
                }
            }
        }

        // 사무실 벽 세우기 (귀찮아.....)
        Arrays.fill(map[0], '6');
        Arrays.fill(map[r+1], '6');
        int[] temp = new int[]{0, c+1};
        for (int i: temp){
            for (int j = 1; j<=r; j++){
                map[j][i] = '6';
            }
        }

        // cctv 종류별 방향 저장 (1번 cctv는 오른쪽, 2번 cctv는 오른쪽 왼쪽, 3번 cctv는 오른쪽 위쪽...)
        directionPerType.put(1, new int[]{0});
        directionPerType.put(2, new int[]{0, 2});
        directionPerType.put(3, new int[]{0, 1});
        directionPerType.put(4, new int[]{0, 1, 2});
        directionPerType.put(5, new int[]{0, 1, 2, 3});

        // 완전탐색 시작
        dfs(0);

        // 최소 사각지대 출력
        System.out.println(minBlindSpot);
    }

    // 부분 집합을 토대로 각 cctv의 방향을 결정해나가는 메서드
    static boolean dfs(int cnt){
        // 모든 cctv의 방향을 결정했다면
        if (cnt == cctvNum){
            // cctv의 사각 지대를 확인하고 적절히 저장한다.
            minBlindSpot = Math.min(minBlindSpot, blindSpot());
            // 사각지대가 0이라면 모든 재귀 함수를 나간다.
            return minBlindSpot == 0;
        }

        switch (cctvs[cnt][2]){ // cctv의 종류에 따라서 설치방향를 바꿔준다.
            // 숫자의 의미는 0은 그대로, 1은 반시계로 90도, 2는 반시계로 180도, 3은 반시계로 270도 돌린것을 의미한다.

            // 카메라 1번과 3번, 4번은 4번 돌릴 수 있고
            case 1:
            case 3:
            case 4:
                for (int i = 0; i<4; i++){
                    cctvs[cnt][3] = i;
                    dfs(cnt+1);
                }
                break;
                // 카메라 2번은 2번 돌릴 수 있고
            case 2:
                for (int i = 0; i<2; i++){
                    cctvs[cnt][3] = i;
                    dfs(cnt+1);
                }
                break;
                // 5번은 돌리든 말든 상관이 없는 시야이다.
            case 5:
                dfs(cnt+1);
        }

        return false;
    }

    // 왜 dfs 보다 더 복잡한데.. 배보다 배꼽이야아아악
    static int blindSpot(){
        // 임시적인 배열을 만들어서
        char[][] tempMap = new char[r+2][c+2];
        for (int i = 0; i<r+2; i++){
            tempMap[i] = map[i].clone();
        }

        // 모든 설치된 cctv의 (시간초과 나면.. 재귀 맵 클론으로 간다..)
        for (int i = 0; i<cctvNum; i++){
            int[] cctv = cctvs[i];

            // 위치와 탐색이 가능한 방향을 확인하고
            int cctvX = cctv[0], cctvY = cctv[1];
            int[] directions = directionPerType.get(cctv[2]);

            // 야오 내가봐도 복잡하다;;
            // 종류별 방향과
            for (int direction: directions){
                // cctv 설치 방향을 고려하여
                int dr = ds[(direction+cctv[3])%4][0], dc = ds[(direction+cctv[3])%4][1];
                int r = cctvX+dr, c = cctvY+dc;

                // 사각지대가 아닌 곳을 확인한다.
                while(tempMap[r][c] != '6'){
                    if (tempMap[r][c] == '0')
                        tempMap[r][c] = '#';

                    // 탐색방향으로 쭉 이동한다.
                    r += dr;
                    c += dc;
                }
            }
        }

        // 드디어 사각지대 탐색한다..
        int blindSpot = 0;
        for (int i = 1; i<r+1; i++){
            for (int j = 1; j<c+1; j++){
                if (tempMap[i][j] == '0')
                    blindSpot++;
            }
        }

        // 사각지대 준다..
        return blindSpot;
    }
}
