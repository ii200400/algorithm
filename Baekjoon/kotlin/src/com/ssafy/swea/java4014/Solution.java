// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeW7FakkUDFAVH
// [모의 SW 역량테스트] 활주로 건설

// JAVA
//언어
//50,592 kb
//메모리
//213 ms
//실행시간
//2,999
//코드길이

// 어흑.. 급하게 하느라 주석을 추가할 틈이 없;;

package com.ssafy.swea.java4014;

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
			int n = sc.nextInt();	// 맵의 크기
			int x = sc.nextInt();	// 경사로 길이
			int map[][] = new int[n+1][n+1];	// 편의상 크기+1
			for (int i = 1; i<=n; i++){
				for (int j = 1; j<=n; j++){
					map[i][j] = sc.nextInt();
				}
			}

			int installCnt = 0;	// 활주로 수
			// 각 가로줄마다 확인한다.
			int preNum;
			boolean[] installed;
			row: for (int i = 1; i<=n; i++){
				// 편의상 맨앞과 맨뒤는 false로 적용하여 맵에서 벗어났다는 것을 표시한다.
				installed = new boolean[n+2];
				installed[0] = true;
				installed[n+1] = true;

				// 순방향
				preNum = map[i][1];
				for (int j = 2; j<=n;){
					if (map[i][j] >= preNum) {
						preNum = map[i][j];
						j++;
						continue;
					}

					if (map[i][j] == preNum-1){
						preNum -= 1;
						int k;
						installed[j] = true;
						for (k = 1; k<x; k++){
							if (installed[j+k] || map[i][j+k] != preNum){
								continue row;
							}
							installed[j+k] = true;
						}
						j += k;
					}else{
						continue row;
					}
				}

				// 역방향
				preNum = map[i][n];
				for (int j = n-1; j>0;){
					if (map[i][j] >= preNum) {
						preNum = map[i][j];
						j--;
						continue;
					}

					if (map[i][j] == preNum-1){
						preNum -= 1;
						int k;
						installed[j] = true;
						for (k = 1; k<x; k++){
							if (installed[j-k] || map[i][j-k] != preNum){
								continue row;
							}
							installed[j-k] = true;
						}
						j -= k;
					}else{
						continue row;
					}
				}

				installCnt++;
			}

			// 각 세로줄마다 확인한다.
			row: for (int i = 1; i<=n; i++){
				// 편의상 맨앞과 맨뒤는 false로 적용하여 맵에서 벗어났다는 것을 표시한다.
				installed = new boolean[n+2];
				installed[0] = true;
				installed[n+1] = true;

				// 순방향
				preNum = map[1][i];
				for (int j = 2; j<=n;){
					if (map[j][i] >= preNum) {
						preNum = map[j][i];
						j++;
						continue;
					}

					if (map[j][i] == preNum-1){
						preNum -= 1;
						int k;
						installed[j] = true;
						for (k = 1; k<x; k++){
							if (installed[j+k] || map[j+k][i] != preNum){
								continue row;
							}
							installed[j+k] = true;
						}
						j += k;
					}else{
						continue row;
					}
				}

				// 역방향
				preNum = map[n][i];
				for (int j = n-1; j>0;){
					if (map[j][i] >= preNum) {
						preNum = map[j][i];
						j--;
						continue;
					}

					if (map[j][i] == preNum-1){
						preNum -= 1;
						int k;
						installed[j] = true;
						for (k = 1; k<x; k++){
							if (installed[j-k] || map[j-k][i] != preNum){
								continue row;
							}
							installed[j-k] = true;
						}
						j -= k;
					}else{
						continue row;
					}
				}

				installCnt++;
			}

			System.out.printf("#%d %d%n", test_case, installCnt);
		}
	}
}
