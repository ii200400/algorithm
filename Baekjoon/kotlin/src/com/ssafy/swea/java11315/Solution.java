// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXaSUPYqPYMDFASQ

// 요즘 오목 판별 코드를 자주 풀어서 몇 문제만 더 풀면 외울 것 같다;;
// 4방위(오른쪽 위, 오른쪽, 오른쪽 아래, 아래)를 5칸 이상 탐색하는 방식으로 진행하였다.

package com.ssafy.swea.java11315;

import java.util.Arrays;
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
			int size = sc.nextInt();	// 오목판 크기
			char[][] map = new char[size+2][size+2];	// 오목판 배열, 벽 추가로 +2
			
			// 오목판 초기화
			for (int i = 1; i<size+1; i++){
				String line = sc.next();
				for (int j = 1; j<size+1; j++){
					map[i][j] = line.charAt(j-1);
				}
			}
			
			// 오목판 벽 세우기 (빈 공간으로 둘러준다.)
			Arrays.fill(map[0], '.');
			Arrays.fill(map[size+1], '.');
			int[] wall = new int[]{0, size+1};
			for (int i = 0; i<size+1; i++){
				for (int j : wall){
					map[i][j] = '.';
				}
			}

			// 오목을 살펴본다.
			// 4방위(오른쪽 위, 오른쪽, 오른쪽 아래, 아래)
			int[] dr = new int[]{-1, 0, 1, 1};
			int[] dc = new int[]{1, 1, 1, 0};

			// 각 자리를 둘러보면서
			boolean flag = false;	// 오목 여부
			check: for (int i = 1; i<size+1; i++){
				for (int j = 1; j<size+1; j++){
					// 빈 공간이면 생략
					if (map[i][j] == '.')
						continue;

					// 4방위로
					for (int k = 0; k<4; k++){
						int r = i+dr[k], c = j+dc[k];

						// 쭉 살펴봤을 때
						int l;
						for (l = 0; l<4; l++, r+=dr[k], c+=dc[k]){
							if (map[r][c] == '.')
								break;
						}
						
						// 현재 자리를 제외하고 4개의 돌이 있다면
						if (l == 4){
							// 오목 여부 기록 후 오목 체크 끝
							flag = true;
							break check;
						}
					}
				}
			}

			// 오목 여부에 따라 출력
			System.out.printf("#%d %s%n", test_case, flag? "YES":"NO");
		}
	}
}
