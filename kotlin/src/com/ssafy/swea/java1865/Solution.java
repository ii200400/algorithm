// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LuHfqDz8DFAXc
// 동철이의 일 분배

// 음.. 사람은 최대 16명이니까 순열로 풀어도 될 것 같다..?
// 아.. 순열이 시간초과가 일어나는 n이 30인줄 알았는데;; 그건 부분집합이고 순열을 11부터 문제가 된다.
// 즉, 이 문제는.. tsp? 라는 DP문제로 풀어야 한다는 것 같은데.. 가르쳐준 적 있었나?

// 어.. 중간에 float로 바꿨는데 그것때문에 시간초과가 나고있었다, 다른 싸피 친구의 말에 따라 double로 바꿔주니 바로 해결되었다.
// 그런데 왜 float로 만들면.. 시간초과가 날까..?

// 실험하다보니.. float가 문제인 것이 아니라 dfs에서 가지치기하는 부분에서 <= 대신 <를 넣으면 문제가 되는 것이었다.
// 하핳..;

package com.ssafy.swea.java1865;

import java.util.Scanner;

public class Solution {
	static int n;
	static float ans;
	static int[][] percents;
	static boolean[] visited;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();    // 사람 수
			percents = new int[n][n];    // 각 사람마다 각 일의 성공 확률
			visited = new boolean[n];    // 일이 이미 배정되었는지 (방문 배열)
			ans = 0.0f;    // 모든 일을 성공할 최대 확률

			// percent 2중 배열 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					percents[i][j] = sc.nextInt();
				}
			}

			// 모든 일을 성공할 최대 확률을 순열을 활용하여 찾기
			dfs(0, 100.0f);

			// 모든 일을 성공할 최대 확률 출력
			System.out.printf("#%d %.6f%n", test_case, ans);
		}
	}

	// 순열을 만드는 함수
	static void dfs(int cnt, float donePercent) {
		if (cnt == n) {
			ans = Math.max(donePercent, ans);
			return;
		}

		// cnt번째 사람에게
		for (int i = 0; i < n; i++) {
			// 이미 다른 사람이 일을 맡고 있다면 패스
			if (visited[i])
				continue;

			// 현재까지 계산한 값이 답이 될 수 없을때는 생략한다.
			// 어.. >= 말고 >로 작성해도 시간초과가 난다;;
			if (ans >= donePercent)
				return;

			// i번째 일을 부여하고 다른 사람에게도 일을 할당해본다.
			visited[i] = true;
			dfs(cnt + 1, donePercent*percents[cnt][i]*0.01f);

			// i번째 일 말고 다른 일을 시키는 것도 고려해본다.
			visited[i] = false;
		}
	}
}
