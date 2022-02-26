// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Psz16AYEDFAUq

// 그냥 되는데로 풀었는데 맞는지 모르겠다.
// 예전에 스도쿠를 주면 채워 넣으라는 문제를 보기만 했었는데 그 문제인줄 알고 잠깐 식겁했다.

package com.ssafy.swea.java1974;

import java.util.Scanner;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();

		int[][] sudoku;	// 스도쿠 배열
		testCase: for(int test_case = 1; test_case <= T; test_case++)
		{
			// 스도쿠 초기화
			sudoku = new int[9][9];
			for (int i = 0; i<9; i++){
				for (int j = 0; j<9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			boolean[] rowNums;
			boolean[] colNums;
			// 한 줄씩
			for (int i = 0; i<9; i++){
				// 행과 열의 중복 숫자 체크를 진행한다.
				rowNums = new boolean[9];
				colNums = new boolean[9];
				// 한 칸씩 살펴보는데
				for (int j = 0; j<9; j++){
					// 중복이 가로 혹은 세로줄에서 발생하면
					if (rowNums[sudoku[i][j]-1] || colNums[sudoku[j][i]-1]){
						// 0 출력 후 테스트 케이스 반복문으로 돌아간다.
						System.out.printf("#%d %d\n", test_case, 0);
						continue testCase;
					}

					// 중복이 아니라면 숫자 체크를 진행한다.
					rowNums[sudoku[i][j]-1] = true;
					colNums[sudoku[j][i]-1] = true;
				}
			}

			// 이번에는 3*3칸마다
			boolean[] duplication;
			for (int iPlus = 0; iPlus<9; iPlus += 3){
				for (int jPlus = 0; jPlus<9; jPlus += 3) {
					// 중복 숫자 체크를 진행한다.
					duplication = new boolean[9];

					// 중복이 특정 3*3칸에서 발생하면
					for (int i = 0; i<3; i++){
						for (int j = 0; j<3; j++){
							if(duplication[sudoku[i][j]-1]){
								// 0 출력 후 테스트 케이스 반복문으로 돌아간다.
								System.out.printf("#%d %d\n", test_case, 0);
								continue testCase;
							}

							// 중복이 아니라면 숫자 체크를 진행한다.
							duplication[sudoku[i][j]-1] = true;
						}
					}

				}
			}

			// 모든 조건을 뚫고 스도쿠 검증이 완료되면 1을 출력한다.
			System.out.printf("#%d %d\n", test_case, 1);
		}
	}
}
