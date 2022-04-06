// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXQsLWKd5cDFAUo
// swea 키 순서

// 아.. 진짜 뭔지 모르겠어서 그림만 30분째 처다보다가..
// 정방향으로 그래프 탐색 한번 화살표를 반대로 바꾸어서 그래프 탐색 한번 했을 때 모든 노드를 탐색할 수 있으면
// 본인의 등수를 확실히 알 수 있는 학생인 것을 알았다.. 아이고난;;

// dfs를 그냥 2번 쓰고 카운팅하는 것 외에는 없어서 구현은 오래 걸리지 않았..
// 풀이 방법 고민을 더 오래한 느낌이.. 난다..?

package com.ssafy.swea.java5643;

import java.util.Scanner;

public class Solution
{
	static int n, m;	// 사람 수, 비교 회수
	static boolean[][] adjMatrix;	// 인접행렬

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();	// 사람 수
			m = sc.nextInt();	// 비교 회수
			adjMatrix = new boolean[n+1][n+1];	// 인접행렬

			// 인접행렬 (비교 대상 중 작은 쪽이 큰쪽을 향하도록 그래프 생성)
			for (int i = 1; i<=m; i++){
				adjMatrix[sc.nextInt()][sc.nextInt()] = true;
			}

			int answer = 0;	// 정답
			for (int i = 1; i<=n; i++) {
				// 방문 배열
				boolean[] visited = new boolean[n+1];
				visited[i] = true;	// 본인 방문 체크

				// 자신보다 확실히 큰 사람들을 탐색하고
				dfs(i, true, visited);
				// 자신보다 확실히 작은 사람들을 탐색했을 때
				dfs(i, false, visited);

				// 모든 사람을 방문했다면 (i 사람이 자신의 등수를 확실히 안다면)
				boolean flag = true;
				for (int j = 1; j<=n; j++) {
					if (!visited[j]){
						flag = false;
					}
				}

				// 정답+1
				if (flag){
					answer++;
				}
			}

			// 정답 출력
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}

	/**
	 * 자신을 가리키는 혹은 자신이 가리키는 곳으로 그래프 탐색
	 * @param num 	현재 탐색중인 학생 숫자
	 * @param forward	자신이 가리키는 사람으로 탐색할지(더 큰 사람) 자신을 가리키는 사람을 탐색할지 (더 작은 사람)
	 * @param visited	방문배열
	 */
	static void dfs(int num, boolean forward, boolean[] visited){
		// 현재 사람 주변의 사람 탐색
		for (int i = 1; i<=n; i++){
			if (forward){	// 자신보다 더 큰 사람이라고 확실히 아는 사람을 탐색한다.
				if (adjMatrix[num][i] && !visited[i]) {
					// 방문 체크 및 dfs 계속 진행
					visited[i] = true;
					dfs(i, true, visited);
				}
			}else{	// 자신보다 더 작은 사람이라고 확실히 아는 사람을 탐색한다.
				if (adjMatrix[i][num] && !visited[i]) {
					// 위와 동문
					visited[i] = true;
					dfs(i, false, visited);
				}
			}
		}
	}
}
