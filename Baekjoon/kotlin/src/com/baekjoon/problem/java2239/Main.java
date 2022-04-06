// 문제 링크 : https://www.acmicpc.net/problem/2239
// 제출 공유 링크 : http://boj.kr/4a72a5d496e042d4abe6f2239cc6e47e
// 백준 스도쿠

// 완전탐색같기는 한데.. 어떻게 완전탐색으로 해야할지..
// 역시 가로/세로/3*3칸 내의 각 숫자 존재여부로 따져야 하나..

// 입력을 받을 때 빈 칸을 저장했다가 dfs를 활용하여 한칸씩 채워넣는 방법을 채택했다.
// 스도쿠 조건에 따라 가로/세로/3*3칸을 살펴보고 들어갈 수 있는 숫자들을 하나씩 넣고 다음 dfs로 진행한다.

package com.baekjoon.problem.java2239;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<int[]> emptyCells;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] sudoku = new int[9][9]; // 스도쿠의 숫자들 배열
        emptyCells = new ArrayList<>(); // 빈 칸 위치
        
        // 스도쿠 배열 초기화
        for(int i = 0; i<9; i++){
            String s = sc.next();
            for(int j = 0; j<9; j++){
                sudoku[i][j] = s.charAt(j) - '0';
                if (sudoku[i][j] == 0) {
                    emptyCells.add(new int[] {i, j});
                }
            }
        }

        dfs(sudoku, 0);
    }

    static boolean dfs(int[][] sudoku, int cnt){
        // 모든 빈칸을 채웠다면
        if (cnt == emptyCells.size()){
            for (int i = 0; i<9; i++){
                for(int j = 0; j<9; j++){
                    System.out.print(sudoku[i][j]);
                }
                System.out.println();
            }
            return true;
        }

        boolean[] nums = new boolean[10];   // 1~9까지 들어갈 수 있는 숫자인지 여부
        // nums 초기화
        int r = emptyCells.get(cnt)[0], c = emptyCells.get(cnt)[1];
        for (int i = 0; i<9; i++){
            nums[sudoku[r][i]] = true;
            nums[sudoku[i][c]] = true;
        }
        for (int i = 0; i<3; i++){
            int nr = (r/3)*3+i;
            for (int j = 0; j<3; j++){
                int nc = (c/3)*3+j;
                nums[sudoku[nr][nc]] = true;
            }
        }

        // 스도쿠를 복사한다.
        int[][] sudokuCopy = new int[9][9];
        for (int i = 0; i<9; i++){
            sudokuCopy[i] = sudoku[i].clone();
        }

        // 빈 칸에 들어갈 수 있는 수를 탐색한다.
        for (int i = 1; i<=9; i++){
            // 스도쿠의 조건에 맞지 않는 수이면 패스
            if (nums[i])
                continue;

            // 복사한 스도쿠에 수를 적어서 다음으로 넘어간다.
            sudokuCopy[r][c] = i;
            if(dfs (sudokuCopy, cnt+1))
                return true;
        }

        return false;
    }
}
