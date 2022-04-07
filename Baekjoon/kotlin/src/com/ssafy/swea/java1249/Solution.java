// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD
// swea [S/W 문제해결 응용] 4일차 - 보급로

// 최근에 비슷한 문제 푼적 있지 않나? 바로 또 주실줄은 몰랐네..
// 링크 문제였던 것 같은디..
// 어쨋든 본인은 우선순위 큐로 해결할 예정이다.

// 아.. 다익스트라 알고리즘인데 풀면서 다익스트라라고 생각하면서 풀지를 않았다.. 이뤈..
// 방법은 알면서 무슨 알고리즘인지 눈치채지 못한다니.. 슬프다..

package com.ssafy.swea.java1249;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스만큼 반복
		tastcase: for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());	// 지도 크기
			int[][] map = new int[n][n];	// 지도 배열
			boolean[][] visited = new boolean[n][n];	// 방문 체크 배열

			// 지도 초기화
			for (int i = 0; i<n; i++){
				String str = br.readLine();
				for (int j = 0; j<n; j++){
					map[i][j] = str.charAt(j) - '0';
				}
			}

			// 우선순위 큐로 복구시간이 적은 것만 먼저 가져온다.
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[2]));
			pq.add(new int[]{0, 0, 0});	// {r, c(위치), 해당 길까지 오면서 총 복구 시간}

			// 4방위
			int[] dr = {1, -1, 0, 0};
			int[] dc = {0, 0, 1, -1};

			while (true){	// 벽으로 막힌 곳은 없으므로 while문 내의 조건문에서 프로그램이 끝나도록 만들 것
				int[] current = pq.poll();
				int time = current[2];
				int r = current[0];
				int c = current[1];

				// 4방위 탐색
				for (int i = 0; i<4; i++){
					int nr = r+dr[i];
					int nc = c+dc[i];

					// 원하는 위치에 도착했다면 정답 출력후 테스트케이스 종료
					if (nr == n-1 && nc == n-1){
						System.out.printf("#%d %d%n", test_case, time);
						continue tastcase;
					}

					// 범위를 벗어나거나 이미 방문 경험이 있다면 패스한다.
					if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc])
						continue;

					// 그렇지 않다면 방문 체크를 하고 우선순위 큐에 값을 추가한다.
					visited[nr][nc] = true;
					pq.add(new int[] {nr, nc, map[nr][nc]+time});
				}
			}

//			System.out.printf("#%d %d%n", test_case, );
		}
	}
}
