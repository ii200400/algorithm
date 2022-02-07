package com.baekjoon.problem.java1941;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // 크기가 5*5로 고정되어있으므로
    static char[][] seats = new char[5][5];
    static boolean[][] isSelected = new boolean[5][5];
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기화
        for (int i = 0; i<5; i++){
            String line = sc.nextLine();
            for (int j = 0; j<5; j++){
                seats[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 0, 0);
    }

    static void dfs(int r, int c, int cnt, int cntS){
        if (cnt == 7){
            if (cntS >= 4 || isAllNear())
                result++;
            return;
        }

        // 계속해서 자리를 살펴보는데
        for (int i = r; i<5; i++){
            for (int j = c; j<5; j++){
                isSelected[i][j] = true;
                if (seats[i][j] == 'S'){ // 'S' 학생이 있다면
                    dfs(i, j+1, cnt+1, cntS+1);
                }else{ // 'Y' 학생이 있다면
                    dfs(i, j+1, cnt+1, cntS);
                }

                isSelected[i][j] = false;
            }
        }
    }

    static boolean isAllNear(){
        HashMap<int[], Boolean> checkSeats = new HashMap<>();

        return false;
    }
}
