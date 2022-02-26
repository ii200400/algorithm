// 문제 링크 : https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWlTKTUqCN8DFAVS

// 와! 8방위 완전탐색! 아시는구나!

package com.ssafy.swea.java7236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		int[] dr = new int[]{0, 0, 1, -1, 1, 1, -1, -1};
		int[] dc = new int[]{1, -1, 0, 0, -1, 1, -1, 1};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());	// 저수지 크기
			boolean[][] map = new boolean[n+2][n+2];	// 저수지 배열, 주변을 땅(true)으로 두른다.
			// 저수지 배열 초기화
			StringTokenizer st;
			for (int i = 1; i<n+1; i++){
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j<n+1; j++){
					map[i][j] = st.nextToken().charAt(0) == 'W';
				}
			}

			// 한 칸씩 살펴보면서 (최소 깊이는 1이므로)
			int waterTankDepth = 1;
			working: for (int i = 1; i<n+1; i++){
				for (int j = 1; j<n+1; j++){
					// 땅이라면 패스
					if (!map[i][j])
						continue;

					// 물이라면 8방위 탐색으로 깊이를 구한다.
					int depth = 0;
					for (int k = 0; k<8; k++){
						int r = i+dr[k], c = j+dc[k];

						// 주변의 물가마다 +1
						if (map[r][c])
							depth++;
					}

					// 더 깊은 값을 저장해준다.
					waterTankDepth = Math.max(depth, waterTankDepth);
					// 저수지의 깊이는 8을 넘기지 못하므로 8이 나오면 탐색 작업을 종료한다.
					if (waterTankDepth == 8)
						break working;
				}
			}

			// 저수지의 깊이를 출력
			System.out.printf("#%d %d%n", test_case, waterTankDepth);
		}
	}
}
