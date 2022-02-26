// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14hwZqABsCFAYD

package com.ssafy.swea.java1220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int[][] table = new int[n][n];	// 테이블 배열
			// 테이블 초기화
			for (int i = 0; i<n; i++){
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j<n; j++){
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int deadlock = 0;	// 교착상태 수
			// 열을 기준으로 탐색을 한다.
			for (int j = 0; j<n; j++){
				boolean meetN = false;	// N극 확인 여부
				for (int i = 0; i<n; i++){
					// 빈공간이면 생략
					if (table[i][j] == 0)
						continue;
					
					if(table[i][j] == 1)
						// N극을 탐색하면 확인 여부를 true로 만든다.
						meetN = true;
					else if (meetN){
						// S극을 탐색했는데 이전에 N극을 만났었다면 교착상태이다.
						// N극 확인 여부를 false로 만든다.
						deadlock++;
						meetN = false;
					}
				}
			}

			// 교착상태를 출력한다.
			System.out.printf("#%d %d\n", test_case, deadlock);
		}
	}
}
