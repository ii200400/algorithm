// 문제 링크 :
// [SSAFY 7기] 계절학기 알고리즘 대회 첫번째 문제
// 아기 상어의 엄마 찾아 삼만리

// 아.. 좀 신경쓸 것이 많다..
// 자료구조도 3중 배열로 써야할 것 같다, 완전 시뮬레이션 문제..;
// 일단.. bfs로 풀 예정이다.

package com.ssafy.swea.contest1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{
	static int n, m, k;
	static int[][] nets;
	static int[] baby, mom;
	static int[][] visited;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		testCase: for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();	// 맵 크기
			m = sc.nextInt();	// 그물 수
			k = sc.nextInt();	// 아기상어 체력

			baby = new int[] {sc.nextInt()-1, sc.nextInt()-1, k, 0};	// 아기상어 최초 위치와 체력, 찢은 그물(비트 마스킹)
			mom = new int[] {sc.nextInt()-1, sc.nextInt()-1};	// 엄마상어 최초 위치

			nets = new int[m][4];	// 각 그물의 위치와 크기, 강도
			visited = new int[n][n];	// 각 위치별 아기상어 방문시 체력 배열 (방문했었어도 체력이 더 많은 상태로 도달했다면 인정)
			
			// 그물 초기화 및 아기상어 체력 초기화
			for (int i = 0; i<m; i++){
				nets[i] = new int[] {sc.nextInt()-1, sc.nextInt()-1, sc.nextInt(), sc.nextInt()};
				if (Math.abs(baby[0]-nets[i][0])+ Math.abs(baby[1]-nets[i][1]) <= nets[i][2]) {
					baby[2] -= nets[i][3];
					baby[3] |= 1<<i;
				}
			}

			// 4방향 방문 처리시 사용
			int[] dr = new int[] {1, -1, 0, 0};
			int[] dc = new int[] {0, 0, 1, -1};

			// bfs에 사용
			// [아기상어 위치r, 위치c, 체력, 찢은 그물(비트 마스킹)]
			Queue<int[]> q = new LinkedList<>();
			q.offer(baby);
			visited[baby[0]][baby[1]] = baby[2];

//			if (baby[0] == mom[0] && baby[1] == mom[1])
//			이야기 상 아기와 엄마상어의 위치는 항상 다르다고 유추한다.

			// bfs
			int time = 0;
			while(!q.isEmpty()){
				time++;

				// 레벨 우선 탐색
				int size = q.size();
				for (int i = 0; i<size; i++){
					int[] current = q.poll();
					int r = current[0];
					int c = current[1];
					int hp = current[2];
					int breakNets = current[3];

					for (int j = 0; j<4; j++){
						int nr = r+dr[j];
						int nc = c+dc[j];
						int tempHp = hp;
						int tempBreakNets = current[3];

						// 지도의 배열을 넘어가면 패스
						if (nr < 0 || nr >= n || nc < 0 || nc >= n)
							continue;

						// 그물에 걸리는지 확인
						for (int l = 0; l<m; l++){
							if ((breakNets & 1<<l) == 0 &&
									Math.abs(nr-nets[l][0]) + Math.abs(nc-nets[l][1]) <= nets[l][2]){
								tempHp -= nets[l][3];
								tempBreakNets |= 1<<l;
							}
						}

						// 방문배열에 걸리면 패스 (방문배열의 int 초기값은 0이므로 체력이 0이하라면 무조건 continue)
						if (visited[nr][nc] >= tempHp)
							continue;

						// 체력이 남은 상태에서 목표지점에 도착했다면 출력 후 다음 테케 진행
						if (nr == mom[0] && nc == mom[1]){
							System.out.printf("#%d %d%n", test_case, time);
							continue testCase;
						}

						// 위의 모든 조건이 아니라면 큐에 추가 및 방문 체크
						q.offer(new int[] {nr, nc, tempHp, tempBreakNets});
						visited[nr][nc] = tempHp;
					}
				}
			}

			// 엄마상어를 못 만난 경우
			System.out.printf("#%d %d%n", test_case, -1);
		}
	}
}
