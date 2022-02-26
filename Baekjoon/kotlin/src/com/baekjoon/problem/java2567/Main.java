// 문제 링크 : https://www.acmicpc.net/problem/2567
// 제출 공유 링크 : http://boj.kr/1bf00512f7d64d869651ac3568de7f05

// 우선 색종이(2563) 문제 처럼 풀고 dfs든 bfs든 탐색하면서
// 4방위 탐색으로 빈 공간이 있으면 변을 더해가는 방식으로 해결할 예정이다.
// 처음 색종이를 완탐으로 해결했던 것 때문인지 또 완전탐색으로 푸는 방법이 생각났다.

package com.baekjoon.problem.java2567;

import java.util.Scanner;

public class Main {

    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 벽은.. 아니고 둘래를 구할 때 예외처리를 안하기 위해서 사용
        // 평소처럼 true로 만들지 않아도 되는 것은 좀 신기하다.
        // 색종이가 붙어있다면 true 아니면 false를 저장하는 도화지 배열
        boolean[][] board = new boolean[102][102];
        int x, y;
        for (int i = sc.nextInt(); i>0; i--){
            // 색종이 위치(가로 세로 점점 햇갈린다..)
            x = sc.nextInt()+1;
            y = sc.nextInt()+1;

            // 보드에 색종이를 붙인다.
            for(int j = 0; j<10; j++){
                for (int k = 0; k<10; k++){
                    board[y+j][x+k] = true;
                }
            }
        }

        // DFS 시작 하려고 했는데 안해도 된다
        // 그냥 보드 자체를 한칸씩 보면서 해도 된다.
        // 그런데 DFS 사용해도 상관은 없었겠다.
        int cnt = 0;    // 둘레를 저장하는 변수
        for (int i = 1; i<101; i++){
            for (int j = 1; j<101; j++){
                // 빈 공간은 건너띄고
                if (!board[i][j])
                    continue;

                // 색종이 주변의 4방위 탐색을 진행한다.
                for (int k = 0; k<4; k++){
                    // 색종이 옆에 빈 공간이 있다면 +1
                    if (!board[i+dy[k]][j+dx[k]])
                        cnt++;
                }
            }
        }

        // 둘레 출력
        System.out.println(cnt);
    }
}
