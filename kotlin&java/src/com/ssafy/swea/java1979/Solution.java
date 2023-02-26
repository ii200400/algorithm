// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PuPq6AaQDFAUq

// 이해를 잘 못했는데.. 그냥..
// 벽으로부터 왼쪽이나 아래쪽으로 칸이 2칸 이상 비워져있으면
// 단어를 쓸 수 있나보다.

// 어.. 오목이랑 거의 같은.. 코딩이 될 것 같다.

package com.ssafy.swea.java1979;

import java.util.Scanner;

public class Solution
{
	static int k, answer;

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();	// 퍼즐 크기
			k = sc.nextInt();	// 단어 길이
			answer = 0;
			int[][] map = new int[n+2][n+2];	// 퍼즐 배열 + 벽 사용
			// 퍼즐 초기화
			for(int i = 1; i<=n; i++){
				for (int j = 1; j<=n; j++){
					map[i][j] = sc.nextInt();
				}
			}

			// 각 자리를 살펴보는데
			for(int i = 1; i<n+1; i++){
				for (int j = 1; j<n+1; j++){
					// 벽이라면 생략
					if (map[i][j] == 0)
						continue;
					// 아니라면 단어를 넣을 수 있는지 본다.
					canWrite(map, i, j);
				}
			}

			// 정답 출력
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}

	// 해당 위치에 단어를 작성할 수 있는 공간이 있는지 확인한다.
	static void canWrite(int[][] map, int _r, int _c){
		// 방향
		int[] dr = new int[]{0, 1};
		int[] dc = new int[]{1, 0};

		// 각 방향을 보는데,
		for (int i = 0; i<2; i++){
			// 반대편이 빈 공간이면 생략;
			if (map[_r-dr[i]][_c-dc[i]] == 1)
				continue;

			// 반대편이 벽이면서,
			// 진행방향에 단어의 길이(k)만큼만 공간이 있는지 확인한다.
			for (int j = 1, r = _r+dr[i], c = _c+dc[i]; j<=k; r += dr[i], c += dc[i], j++){
				if (map[r][c] == 0){
					// 딱 k만큼의 공간이 있다면
					if (j == k) {
						// 저장한다.
						answer++;
					}
					break;
				}
			}
		}
	}
}
