// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWrDOdQqRCUDFARG
// swea 치즈 도둑

// 아무리봐도 백준의 안전영역 문제..
// 교수님이 일부러 문제 주셨다고 한 것은 쌍둥이 문제 이해하라는 것이었다;;

package com.ssafy.swea.java7733;

import java.util.Scanner;

public class Solution
{
	static int n;
	static int[][] map;
	static boolean[][] visited;	// 방문 배열

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();	// 치즈 크기
			map = new int[n][n];	// 치즈 맛있는 정도
			boolean[] hasNum = new boolean[101];	// 맛있는 정도 존재 여부

			// 치즈 초기화
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					map[i][j] = sc.nextInt();
					hasNum[map[i][j]] = true;
				}
			}

			int answer = 1;	// 치즈덩어리 최대 개수

			// 각 정도마다 덩어리가 얼마나 있는지 여부
			for (int i = 1; i<101; i++){
				// 해당 맛있는 정도의 치즈가 없으면 패스
				if (!hasNum[i])
					continue;

				// 모든 치즈 부분을 탐색하면서 방문 여부에 따라 dfs 탐색 시작
				int blocks = 0;
				visited = new boolean[n][n];
				for (int j = 0; j<n; j++){
					for (int k = 0; k<n; k++){
						if (visited[j][k] || map[j][k] <= i)
							continue;

						visited[j][k] = true;
						dfs(j, k, i);
						blocks++;
					}
				}

				answer = Math.max(answer, blocks);
			}

			System.out.printf("#%d %d%n", test_case, answer);
		}
	}

	// 4방위 탐색
	static int[] dr = new int[] {1, -1, 0, 0};
	static int[] dc = new int[] {0, 0, 1, -1};

	/**
	 * 깊이우선탐색 - 치즈 한 덩어리 확인 함수
	 * @param r 위치 r
	 * @param c 위치 c
	 * @param time	맛잇는 정도(경과 시간)
	 */
	static void dfs(int r, int c, int time){
		// 4방위 탐색
		for (int i = 0; i<4; i++){
			int nr = r+dr[i];
			int nc = c+dc[i];

			if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc] || map[nr][nc] <= time)
				continue;

			visited[nr][nc] = true;
			dfs(nr, nc, time);
		}
	}
}
