// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD

// 단순한 순열문제라고 생각하고 풀었더니 맞았다.
// 문제에 효율성 따지지 말라고 친절하게 작성해준 것은 의외였다.

package com.ssafy.swea.java1247;

import java.util.Scanner;

public class Solution
{

	static int n, minDistance;
	static int[][] customers;
	static int[] house;

	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();	// 고객 수
			int locationX = sc.nextInt();	// 시작 위치
			int locationY = sc.nextInt();
			house = new int[]{sc.nextInt(),sc.nextInt()}; // 집 위치
			customers = new int[n][2];
			for (int i = 0; i<n; i++){
				customers[i] = new int[]{sc.nextInt(), sc.nextInt()};
			}
			minDistance = Integer.MAX_VALUE; // 이동거리 초기화

			// 고객 방문 서비스 시작
			dfs(0, 0, 0, locationX, locationY);

			// 퇴근까지 최소 이동거리를 출력한다.
			System.out.printf("#%d %d\n", test_case, minDistance);
		}
	}

	// 비트마스킹을 이용한 순열
	// 방문 횟수, 고객 방문 기록(비트마스크), 현재까지 이동거리, 현재 위치x, 현재 위치y
	static void dfs(int cnt, int bit, int distance, int locationX, int locationY){
		// 모든 고객의 집을 방문했다면
		if (cnt == n){
			// 퇴근하는 길도 포함해서 최소인지 확인하고 저장한다.
			distance += Math.abs(house[0]-locationX) + Math.abs(house[1]-locationY);
			minDistance = Math.min(minDistance, distance);
			return;
		}

		for (int i = 0; i<n; i++){
			// 방문을 아직 하지 않은 고객이라면
			if ((bit & 1 << i) == 0){
				// 방문한다.
				dfs(cnt+1, bit | 1 << i,
						distance + Math.abs(locationX-customers[i][0]) + Math.abs(locationY-customers[i][1]),
						customers[i][0], customers[i][1]);
			}
		}

	}
}
