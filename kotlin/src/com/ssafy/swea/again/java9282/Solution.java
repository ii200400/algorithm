// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW9j-qfacIEDFAUY
// swea 초콜릿과 건포도

// 아마도? 잘라서 나오는 초콜릿의 건포도 차이가 가장 작도록 자르는 것 같다.... 그럼 자를 때 차이가 같은 것이 여러 개이면..?
// 아니면 완전탐색을 해야하나..... 개당 문제 푸는 속도가 0.3초이니 기각이다;
// 메모이제이션를 사용해야하나.. 어떻게..?

package com.ssafy.swea.again.java9282;

import java.util.Scanner;

public class Solution
{
	static int n, m;
	static int[][] map;
	static int[][][][] dp;
	static int answer;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt(); m = sc.nextInt();	// 초콜릿 크기
			map = new int[n][m];	// 초콜릿 부분별 건포도 개수
			dp = new int[n][m][n][m];	// 위치와 크기별 비용

			// 건포도 개수 초기화
			for (int i = 0; i<n; i++){
				for (int j = 0; j<m; j++){
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i<n; i++){
				for (int j = 0; j<m; j++){

				}
			}

//			System.out.printf("#%d %d%n", test_case, );
		}
	}
}
