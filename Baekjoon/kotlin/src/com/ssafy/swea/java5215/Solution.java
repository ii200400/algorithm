// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT

package com.ssafy.swea.java5215;

import java.util.Scanner;

public class Solution
{

    static int N, limit;
    static int[][] foodInfo;
    static int max;

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            limit = sc.nextInt();
            foodInfo = new int[N][2];
            max = 0;
            for (int i = 0; i<N; i++){
                foodInfo[i] = new int[] {sc.nextInt(), sc.nextInt()};
            }

            dfs(0, 0, 0);

            System.out.printf("#%d %d\n", test_case, max);
        }
    }

    static void dfs(int cnt, int tasty, int calorie){
        if (calorie > limit)
            return;

        if (cnt == N){
            max = Math.max(max, tasty);
            return;
        }

        dfs(cnt+1, tasty+foodInfo[cnt][0], calorie+foodInfo[cnt][1]);
        dfs(cnt+1, tasty, calorie);
    }
}
