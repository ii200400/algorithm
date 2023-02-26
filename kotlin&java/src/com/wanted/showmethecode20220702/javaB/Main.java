// 미친 시큘레이션;;

package com.wanted.showmethecode20220702.javaB;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] map = new int[7][7];    // 격자에 있는 공 정보
        int ballCnt = 0;    // 공의 수

        // 초기화
        for (int i = 0; i<7; i++){
            for (int j = 0; j<7; j++){
                map[i][j] = sc.nextInt();
                
                if (map[i][j] != 0)
                    ballCnt++;
            }
        }

        int ballNum = sc.nextInt(); // 떨어뜨리는 공의 수
        ballCnt++;
        int minBallCnt = 49;
        // 공을 각 열에 떨어뜨려 본다.
        for (int i = 0; i<7; i++){
            // 맵 복사
            int[][] copyMap = copy(map);
            int copyBallCnt = ballCnt;
            int j;
            for (j = 0; j<7; j++){
                if (map[j][i] != 0){
                    break;
                }
            }

            // 공이 i번째 줄에 떨어져서 j번째 까지 떨어진다.
            j--;
            copyMap[j][i] = ballNum;

            HashSet<int[]> disappearBalls;
            do{
                disappearBalls = new HashSet<>();

                // 가로에 대해서 사라지는 공이 있는지 탐색
                for (int k = 0; k<7; k++){
                    int serialCnt = 0;
                    for (int l = 0; l<=7; l++){

                        if (l == 7 || copyMap[k][l] == 0){
                            // 연속하는 공이 없다면 패스
                            if (serialCnt == 0)
                                continue;

                            for (int m = 1; m<=serialCnt; m++){
                                if (serialCnt == copyMap[k][l-m]){
                                    disappearBalls.add(new int[] {k, l-m});
                                }
                            }

                            serialCnt = 0;
                        }else{
                            serialCnt++;
                        }
                    }
                }

                // 세로에 대해서도 같은 연산 진행
                for (int k = 0; k<7; k++){
                    int cntBall = 0;
                    for (int l = 0; l<7; l++){
                        if (copyMap[l][k] != 0)
                            cntBall++;
                    }

                    // 해당 가로줄에 공이 없다면 생략
                    if (cntBall == 0)
                        continue;

                    // 있다면 사라지는 공이 있는지 확인한다.
                    for (int l = 0; l<7; l++){
                        if (cntBall == copyMap[l][k]){
                            disappearBalls.add(new int[] {l, k});
                        }
                    }
                }

                // 공을 사라지게 만든다.
                List<int[]> sortedList = new ArrayList<>(disappearBalls);
                sortedList.sort(Comparator.comparingInt(o -> o[0]));
                copyBallCnt -= disappearBalls.size();
                for (int[] ballPos: disappearBalls) {
                    drop(copyMap, ballPos[0], ballPos[1]);
                }
            }while(!disappearBalls.isEmpty());

            minBallCnt = Math.min(minBallCnt, copyBallCnt);
        }

        System.out.println(minBallCnt);
    }

    // 기존의 맵을 수정하면 안되므로 만든 맵 복사 함수
    static int[][] copy(int[][] map){
        int[][] copyMap = new int[7][7];
        for (int i = 0; i<7; i++){
            copyMap[i] = map[i].clone();
        }

        return copyMap;
    }

    static void drop(int[][] map, int r, int c){
        while(r != 0) {
            map[r][c] = map[r-1][c];
            r--;
        }

        map[r][c] = 0;  // 가장 윗줄은 항상 공이 없는 상태가 된다.
    }
}
