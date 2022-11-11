// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq
// [모의 SW 역량테스트] 탈주범 검거

// 당연히 bfs에.. 적절한..! 매우 적절한 자료구조를? 배열을? 만들어야 한다.

// 어휴.. roadTypes 내의 true false 한 쌍을 반대로 썼는데 금방 고쳐서 살았다..

package com.ssafy.swea.java1953;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{
	// 아래, 오른쪽, 위, 왼쪽
	static int[] dr = new int[] {1, 0, -1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};

	// 순서대로 +, |, -, ㄴ, r, ㄱ, -|
	static boolean[][] roadTypes = new boolean[][] {	// 종류별로 갈 수 있는 방향들
			{false, false, false, false},	// 터널 0 은 터널이 없는 곳
			{true, true, true, true},		// 터널 1 은 + 아래 true, 오른쪽 true, 위 true, 왼쪽 true
			{true, false, true, false},		// 터널 2 은 | 아래 true, 오른쪽 false, 위 true, 왼쪽 false
			{false, true, false, true},		// 터널 3 은 - 아래 false, 오른쪽 true, 위 false, 왼쪽 true
			{false, true, true, false},		// ...
			{true, true, false, false},
			{true, false, false, true},
			{false, false, true, true}};

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt(), m = sc.nextInt();	// 맵 세로/가로 길이
			int[] hole = new int[] {sc.nextInt(), sc.nextInt()};
			int totalTime = sc.nextInt();	// 경과 시간
			int[][] map = new int[n][m];	// 지하터널 배열
			boolean[][] visited = new boolean[n][m];	// 방문 배열

			// 지하터널 배열
			for (int i = 0; i<n; i++){
				for (int j = 0; j<m; j++){
					map[i][j] = sc.nextInt();
				}
			}

			int time = 1, canGo = 1;	// 현재 시간, 갈 수 있는 장소 수
			Queue<int[]> q = new LinkedList<>();	// bfs에 사용할 큐
			// 초기화
			q.add(new int[] {hole[0], hole[1]});	
			visited[hole[0]][hole[1]] = true;
			
			// bfs시작
			while (!q.isEmpty() && time < totalTime){
				int qSize = q.size();
				time++;
				
				// 레벨 우선 탐색
				for(int i = 0; i<qSize; i++){
					int[] current = q.poll();
					int r = current[0];
					int c = current[1];
					int type = map[r][c];
					
					// 4방위 중 탐색 가능한 곳을 탐색
					for (int j = 0; j<4; j++){
						// 터널 구조 상 갈 수 없는 위치이면 패스
						if (!roadTypes[type][j])
							continue;

						// 다음 터널의 위치
						int nr = r+dr[j];
						int nc = c+dc[j];

						// 범위에서 벗어나거나, 방문한 경험이 있거나..
						// 인접한 터널 종류(map[nr][nc])가 현재 터널에서 이동이 가능한((j+2)%4) 모양(roadTypes)이지 않으면 패스
						// 이동이 가능하다는 것은 현 터널의 오른쪽으로 갈 수 있을 때 탐색 터널의 왼쪽이 갈 수 있는(두 터널간 이동 가능한) 형태라는 것
						if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || !roadTypes[map[nr][nc]][(j+2)%4])
							continue;

						// 방문 체크 및 큐에 위치 추가, 장소 추가
						visited[nr][nc] = true;
						q.add(new int[] {nr, nc});
						canGo++;
					}
				}
			}

			// 범인이 갈 수 있는 곳의 수 출력
			System.out.printf("#%d %d%n", test_case, canGo);
		}
	}
}
