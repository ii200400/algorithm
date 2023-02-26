// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN

// 본인은 단순히 재귀와 이중for문을 생각했는데
// 정렬과 투포인터로 nLogn+n으로 푼 사람도 있었다. 신기하다!

package com.ssafy.swea.java9229;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution
{
    static int n;   // 총 과자 수
    static int[] snaks; // 과자 무게 배열
    static int limit, result;   // 무게 한도, 결과값

    // 2개여서 이중 for문 해도 되는데 까먹음.. 조합 구현하듯이 재귀로 진행
    static void dfs(int cnt, int idx, int weight){ // 선택한 과자 수, 과자 인덱스, 무게
        if (cnt == 2){
            if (weight <= limit)
                result = Math.max(result, weight);

            return;
        }

        for (int i = idx; i<n; i++){
            // i 번째 과자 선택
            dfs(cnt+1, i+1, weight+snaks[i]);
        }

//        // 선택하고 진행
//        dfs(cnt+1, idx+1, weight+snaks[cnt]);
//        // 선택하지 않고 진행
//        dfs(cnt, idx+1, weight);
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 초기화
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            limit = Integer.parseInt(input[1]);
            snaks = new int[n];
            result = -1;

            input = br.readLine().split(" ");
            for (int i = 0; i<n; i++){
                snaks[i] = Integer.parseInt(input[i]);
            }

            // 재귀 시작
            dfs(0, 0, 0);

            // 결과 출력
			System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
