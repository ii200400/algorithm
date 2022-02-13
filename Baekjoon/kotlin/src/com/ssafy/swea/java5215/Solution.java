// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT

package com.ssafy.swea.java5215;

import java.util.Scanner;

public class Solution
{

    static int N, limit;    // 재료의 수, 칼로리 제한치
    static int[][] foodInfo;// 각 재료의 맛과 칼로리
    static int max;         // 결과값

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        // 테스트 케이스마다 반복
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 초기화
            N = sc.nextInt();
            limit = sc.nextInt();
            foodInfo = new int[N][2];
            max = 0;
            for (int i = 0; i<N; i++){
                foodInfo[i] = new int[] {sc.nextInt(), sc.nextInt()};
            }

            // 부분집합과 같이 탐색
            dfs(0, 0, 0);

            // 결과 출력
            System.out.printf("#%d %d\n", test_case, max);
        }
    }

    static void dfs(int cnt, int tasty, int calorie){
        if (calorie > limit) // 칼로리 제한에 걸리면 돌아간다.
            return;

        if (cnt == N){  // 재료를 사용할지 말지 모두 결정했으면 조건에 따라 결과값에 넣는다.
            max = Math.max(max, tasty);
            return;
        }

        // 재료를 선택하고 진행해보고
        dfs(cnt+1, tasty+foodInfo[cnt][0], calorie+foodInfo[cnt][1]);
        // 선택하지 않고 진행해본다.
        dfs(cnt+1, tasty, calorie);
    }
}
