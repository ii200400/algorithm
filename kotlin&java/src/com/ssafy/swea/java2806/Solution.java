// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GKs06AU0DFAXB

// 백준의 문제(3344이나 9663번)과 같은데
// 전자의 경우 속도를 더 빠르게 만들어주어야 할 것 같고(시간제한이 1초..)
// 후자의 경우 백트래킹으로도 해결이 가능하다. (시간제한 10초)

package com.ssafy.swea.java2806;

import java.util.Scanner;

public class Solution
{

	static int n, answer = 0;
	static int col[];

	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
			col = new int[n];
			answer = 0;

			queen(0);

			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	// 현재까지 놓은 퀸의 수(idx번째 )를 파라미터로 넘겨주면서
	// n개의 퀸을 놓을 수 있는 경우의 수를 세는 함수
	static void queen(int idx){
		// 모든 퀸을 놓았다면 다른 경우를 찾으러 돌아간다.
		if (idx == n){
			answer++;
			return;
		}

		// idx+1 번째 줄에 한 칸씩
		for (int i = 0; i<n; i++){
			// 퀸을 놓아보고
			col[idx] = i;
			// 서로 공격하는 퀸이 없다는 것이 판명되면
			if (isAvailable(idx))
				// 다음 퀸을 놓는 것을 진행해본다.
				queen(idx+1);
		}
	}

	static boolean isAvailable(int row){
		for (int i = 0; i<row; i++){
			if (col[i] == col[row] || Math.abs(i-row) == Math.abs(col[i]-col[row]))
				return false;
		}

		return true;
	}
}
