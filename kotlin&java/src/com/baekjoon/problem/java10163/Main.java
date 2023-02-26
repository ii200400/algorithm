// 문제 링크 : https://www.acmicpc.net/problem/10163
// 제출 공유 링크 : http://boj.kr/43d54742ad6b484f80c0443c2df1c234

package com.baekjoon.problem.java10163;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 색종이 수
        int[][] board = new int[1001][1001]; // 보드판

        // n개의 색종이를 붙인다.
        for (int i = 1; i<=n; i++){
            // 색종이의 위치와 크기에 따라
            int x = sc.nextInt(), y = sc.nextInt();
            int width = sc.nextInt(), height = sc.nextInt();

            // 보드에 종이로 덮는다.
            for (int j = 0; j<width; j++){
                for (int k = 0; k<height; k++){
                    board[x+j][y+k] = i;
                }
            }
        }

        int[] papers = new int[n+1];    // 각 종이가 보이는 면적
        // 보드를 살펴보면서
        for (int i = 0; i<1001; i++){
            for (int j = 0; j<1001; j++){
                // 빈 공간은 패스하고
                if (board[i][j] == 0)
                    continue;
                // 종이가 붙은 부분은 해당 종이 면적을 +1 한다.
                papers[board[i][j]] += 1;
            }
        }

        // 각 종이가 보이는 면적을 출력한다.
        for (int i = 1; i<=n; i++){
            System.out.println(papers[i]);
        }
    }
}
