// 문제 링크 : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1006&sca=99&sfl=wr_hit&stx=1733
// 제출 링크 (공유 링크 아님) : http://jungol.co.kr/theme/jungol/result.php?sid=5527001

// 이전에 시험으로 나왔던 오목문제, 조건문을 넣고 잘 되는지 확인해야겠다.

package com.jungol.java1733;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 바둑판, 벽을 세울것이다. 벽은 3으로 한다.
        int[][] board = new int[21][21];
        // 방향 배열
        int[] dr = new int[]{-1, 0, 1, 1};
        int[] dc = new int[]{1, 1, 1, 0};

        // 벽 세우기
        Arrays.fill(board[0], 3);
        Arrays.fill(board[20], 3);
        for (int i : new int[]{0, 20}){
            for (int j = 1; j<20; j++){
                board[j][i] = 3;
            }
        }

        // 보드 초기화
        for (int i = 1; i<20; i++){
            for (int j = 1; j<20; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 각 자리별로 오목 탐색
        for (int i = 1; i<20; i++){
            for (int j = 1; j<20; j++) {
                // 해당 자리의 돌을 확인한다.
                int stone = board[i][j];

                // 빈 공간이면 생략
                if (stone == 0) continue;

                // 탐색을 진행하는데
                boolean flag;   // 5목 여부 확인
                for (int k = 0; k<4; k++){
                    flag = false;   // 초기화

                    // 한 방향에서 오목이 되는지 탐색하면서
                    for (int l = 1, r = i+dr[k], c = j+dc[k]; l<=5; l++, r+=dr[k], c+=dc[k]){
                        // 연속으로 나오는 돌이
                        if (board[r][c] != stone){
                            // 정확히 5개이면
                            if (l == 5){
                                // 오목 여부를 true로 만든다.
                                flag = true;
                            }
                            break;
                        }
                    }

                    // 오목이 맞으면서 반대방향의 돌도 현 위치의 돌과 다르다면
                    if (flag && board[i-dr[k]][j-dc[k]] != stone){
                        // 오목!
                        System.out.println(stone);
                        System.out.println(i + " " + j);
                        return;
                    }
                }
            }
        }

        // 오목이 없는 경우 0을 출력
        System.out.println(0);
    }
}
