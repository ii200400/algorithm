// 문제 링크 : https://www.acmicpc.net/problem/20056
// 제출 공유 링크 : http://boj.kr/c824e3d5b0bb4e709e0dbf437ffbd85d
// 백준 마법사 상어와 파이어볼

// 벽에 부딪히면 어떻게 되는지 열심히 찾았는데 알고보니 행과 열의 아래와 위가 연결되어있다는 설정이었다;
// 단순히 서술되어있는 방법을 그대로 따라하면 될 것 같다.

// %n 연산을 적절하게 하지 못해서 2곳정도 바꾸었다;;
// 하나는 처음 입력을 받을 때 %n을 해서 받으면 안되는데 넣어서
// 다른 하나는 위의 코드를 바꾸면서 %n을 넣어야 하는데 안 넣어서(파이어볼 이동하는 부분에서)
// 문제가 생겼었다.

package com.baekjoon.problem.java20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, answer;
    static ArrayList<int[]>[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 격자 크기
        int m = Integer.parseInt(st.nextToken());   // 파이어볼 개수
        int k = Integer.parseInt(st.nextToken());   // 움직이는 회수
        map = new ArrayList[n][n]; // 칸별 존재하는 파이어볼들
        answer = 0; // 모든 파이어볼 질량 합
        
        // 격자칸 초기화
        for (int i = 0; i<n; i++){
            map[i] = new ArrayList[n];
            for (int j = 0; j<n; j++){
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int mash = Integer.parseInt(st.nextToken());
            // 단순히 조금 더 빠르게 이동하려고 s%n을 했는데 그러면 안된다;;
            map[r-1][c-1].add(new int[] {mash, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            answer += mash;
        }

        for (int i = 0; i<k; i++){
            fireBallMove();
        }

        System.out.println(answer);
    }

    static int[] dr = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = new int[] {0, 1, 1, 1, 0, -1, -1, -1};

    static void fireBallMove(){
        ArrayList<int[]>[][] tempMap = new ArrayList[n][n]; // 이동시킨 파이어볼을 저장하는 격자판

        // 초기화
        for (int i = 0; i<n; i++){
            tempMap[i] = new ArrayList[n];
            for (int j = 0; j<n; j++){
                tempMap[i][j] = new ArrayList<>();
            }
        }

        // 각 위치의
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                int size = map[i][j].size();

                // 파이어볼을 이동시킨다.
                for (int k = 0; k<size; k++){
                    int speed = map[i][j].get(k)[1];
                    int dir = map[i][j].get(k)[2];

                    // 런타임에러 뜨던 곳;; %n을 추가로 해주어야 하는데 생각을 못했었다.
                    int nr = i+(dr[dir]*speed)%n;
                    int nc = j+(dc[dir]*speed)%n;
                    tempMap[(nr+n)%n][(nc+n)%n].add(map[i][j].get(k));
                }
            }
        }

        // 2개 이상의 파이어볼이 있는 칸은 아래와 같은 상황이 된다.
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                int size = tempMap[i][j].size();
                // 파이어볼이 1개 보다 작은 경우에는 특별한일이 일어나지 않는다.
                if (size <= 1)
                    continue;

                boolean allSame = true;    // 모든 파이어볼 방향이 홀수이거나 짝수인지 확인
                int isOdd = tempMap[i][j].get(0)[2]%2; // 첫번째 파이어볼 홀수 여부
                int mashSum = tempMap[i][j].get(0)[0]; // 해당 칸 파이어볼 질량 합
                int speedSum = tempMap[i][j].get(0)[1]; // 해당 칸 파이어볼 속도 합
                // 해당 칸에 있는 모든 파이어볼의 질량합, 속도합, 방향의 홀수/짝수 여부 확인
                for (int k = 1; k<size; k++){
                    mashSum += tempMap[i][j].get(k)[0];
                    speedSum += tempMap[i][j].get(k)[1];
                    if (tempMap[i][j].get(k)[2]%2 != isOdd) {
                        allSame = false;
                    }
                }

                answer -= mashSum;
                mashSum /= 5;
                speedSum /= tempMap[i][j].size();

                // 나눠진 파이어볼 질량이 0이되면 생략한다.
                tempMap[i][j].clear();
                if (mashSum == 0)
                    continue;

                // 이전 파이어볼들은 모두 없애고 나눠진 파이어볼 4개를 넣는다.
                int k;
                if (allSame){
                    k = 0;
                }else{
                    k = 1;
                }
                for (; k<8; k+=2){
                    tempMap[i][j].add(new int[] {mashSum, speedSum, k});
                }
                answer += mashSum*4;
            }
        }

        // 새로운 격자판으로 갱신
        map = tempMap;
    }
}
