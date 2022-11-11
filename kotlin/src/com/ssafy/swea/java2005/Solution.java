// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P0-h6Ak4DFAUq

// 그냥 배열 만들어서 푼다!
// 음.. 끝이다..

package com.ssafy.swea.java2005;

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
			int n = sc.nextInt();	// 파스칼 삼각형 크기
			int[][] pascal = new int[n][n+1]; // 파스칼 삼각형 배열, 왼편 예외처리를 안하기 위해 크기 +1

			// 계산하면서 출력한다.
			System.out.printf("#%d\n", test_case);
			
			// 가장 위 값 초기화
			System.out.println(1);
			pascal[0][1] = 1;
			// 파스칼 삼각형 연산 및 출력 시작
			for (int i = 1; i<n; i++){
				for (int j = 1; j<=i+1; j++){
					// 자신 왼쪽위와 위의 숫자를 더해서 넣고
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
					// 출력한다.
					System.out.print(pascal[i][j] + " ");
				}
				// 한 줄 출력하면 엔터
				System.out.println();
			}
		}
	}
}
