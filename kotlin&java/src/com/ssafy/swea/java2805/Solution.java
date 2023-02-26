// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB

// 재귀함수로 풀라는 줄 알고 오해했다..

// ============= 2
// 이전에 dfs 기반의 재귀함수로 풀려고 했는데
// 지금보니 조건을 잘 못 둬서 dfs가 안된거고 dfs도 bfs도 된다.
// 이전에 이미 풀었는데.. 그때는 for문으로 풀었으니 이번에는 bfs를 사용해보겠다.

package com.ssafy.swea.java2805;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int size = sc.nextInt();

            // 농작물 입력
            int[][] map = new int[size][size];
            for(int r = 0; r<size; r++) {
                String s = sc.next();
                for (int c = 0; c<size; c++) {
                    map[r][c] = s.charAt(c) - '0';
                }
            }

//			역시 별찍기가 짱이다! (방법 1)

//            int sum = 0;
//            int half = size/2;

//            for(int i = 0; i<size; i++) {
//                int j;
//                int go = Math.max(half-i, i-half);
//                for(j = 0; j<go; j++) {}// go번 수확 생략
//
//                go = Math.min(2*i+1, 2*(size-i)-1);
//                for(int k = 0; k<go; k++, j++) { // go번 수확!
//                    sum += map[i][j];
//                }
//            }

            // 조금 더 가독성 있게 만들어본다. (방법 2)

//            int sum = 0;
//            int half = size/2;
//
//            // 각 행을 살펴보는데
//            for(int i = 0; i<size; i++){
//                int idx = Math.abs(half-i); // 탐색 시작할 열
//                int diff = half-idx;    // idx부터 얼마나 더 탐색할지 연산에 사용되는 변수
//                for (int k = 0; k<2*diff+1; k++){
//                    sum += map[i][idx+k];   // 각 행에서 필요한 만큼 더한다.
//                }
//            }
            
            // bfs 활용 (방법 3, dfs는 조건식으로 꽤 많이 느려질 것 같으므로 생략)

            int[] dr = new int[]{0,0,1,-1};
            int[] dc = new int[]{1,-1,0,0};
            int sum = map[size/2][size/2];

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{size/2, size/2});
            map[size/2][size/2] = -1;

            int depth = -1;
            // 중앙으로부터 거리가 size/2-2이 될 때까지만 (거리가 2일 때 거리가 3인 곳을 모두 둘러보기 때문;)
            while (++depth < size/2){

                // 모든 depth 만큼 거리의 농작물들을
                int qSize = q.size();
                for (int i = 0; i<qSize; i++) {
                    // 큐에서 뽑아서
                    int[] current = q.poll();

                    // 디버깅용
//                    System.out.println(current[0] + " " + current[1]);

                    // 주변을 살펴보는데
                    for (int j = 0; j < 4; j++) {
                        int r = current[0] + dr[j], c = current[1] + dc[j];
                        // 이미 방문한 곳이라면 생략하고
                        // (밭을 벗어나기 전에 whlie문을 탈출하므로 범위 예외처리는 필요가 없다.)
                        if (map[r][c] == -1)
                            continue;

                        // 수확하고
                        sum += map[r][c];
                        // 큐에 넣은 뒤
                        q.add(new int[]{r, c});
                        // 방문처리를 해준다.
                        map[r][c] = -1;
                    }
                }
            }

            // 출력한다.
            System.out.printf("#%d %d\n", test_case, sum);
        }
    }
}

