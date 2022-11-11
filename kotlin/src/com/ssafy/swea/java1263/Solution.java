// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18P2B6Iu8CFAZN
// swea 사람 네트워크2

// 그냥.. bfs (사람 수 - 1) 만큼 돌리면 되는게 아닌가?
// 마지막 사람은 다른 사람들이 모두 최단거리를 구했으니까.. 안 구해도 될 것 같고..
// ... 어떻게 저장했다가 사용해야할지 모르겠으니 그냥 사람 수 만큼 bfs를 돌리겠다.
// 그러고보니, 플로이드 워셜문제라고 하시지 않았나..? 아몰랑~

package com.ssafy.swea.java1263;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();	// 사람 수
			boolean[][] adjMatrix = new boolean[n][n];	// 인접행렬
			// 인접행렬 초기화
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					adjMatrix[i][j] = sc.nextInt()==1;
				}
			}

			int answer = Integer.MAX_VALUE;	// 정답 저장 변수
			int cc, level;	// 현재 사람의 cc, 레벨 저장 변수
			boolean[] visited;	// 방문 배열
			
			// 각 사람마다
			for (int i = 0; i<n; i++){
				Queue<Integer> q = new LinkedList<>();
				q.add(i);

				cc = 0; level = 0;
				visited = new boolean[n];
				visited[i] = true;

				// bfs 진행
				while(!q.isEmpty()){
					level++;
					int qSize = q.size();	// 큐의 크기

					// 레벨 우선 탐색
					for (int j = 0; j<qSize; j++) {
						int current = q.poll();	// 현재 탐색할 사람

						// 인접한 사람들을 살펴본다.
						for (int k = 0; k < n; k++) {
							// 연결이 되어있지 않거나 이미 방문했다면 패스한다.
							if (!adjMatrix[current][k] || visited[k])
								continue;

							// 방문 체크를 하고 큐에 저장한다.
							visited[k] = true;
							q.add(k);
							cc += level;	// cc를 계산한다.
						}
					}
				}

				// 정답을 적절히 저장
				answer = Math.min(answer, cc);
			}

			// 정답 출력
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}
