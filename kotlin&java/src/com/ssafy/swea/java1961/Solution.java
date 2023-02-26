// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pq-OKAVYDFAUq

// StringBuilder[] 을 만들어서 줄마다 append를 할까..
// 그냥 배열을 3개 저장했다가 순서대로 출력할까..
// 고민하고 있다.

package com.ssafy.swea.java1961;

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
			int n = sc.nextInt();	// 행렬 크기
			int[][] arr = new int[n][n];	// 행렬

			// 행렬 초기화
			for (int i = 0; i<n; i++){
				for (int j = 0; j<n; j++){
					arr[i][j] = sc.nextInt();
				}
			}

			// 문자열 초기화
			StringBuilder[] output = new StringBuilder[n];
			for (int i = 0; i<n; i++){
				output[i] = new StringBuilder();
			}

			// 90도 돌리고 넣어주고를.. 3번해준다.
			for (int k = 0; k<3; k++) {
				// 90도 돌리고
				turn90(arr);
				// 각 줄에 해당 행렬 정보 추가
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[0].length; j++) {
						output[i].append(arr[i][j]);
					}
					output[i].append(' ');
				}
			}

			// 출력한다.
			System.out.printf("#%d\n", test_case);
			for (int i = 0; i<arr.length; i++){
				System.out.println(output[i]);
			}
		}
	}

	// 매개변수로 주어진 배열을 90도 돌려주는 함수
	static void turn90(int[][] arr){
		// 임시 배열에
		int[][] temp = new int[arr.length][arr[0].length];
		// 대각선으로 뒤집은 행렬을 넣고
		for (int i = 0; i<arr.length; i++){
			for (int j = 0; j<arr[0].length; j++){
				temp[j][i] = arr[i][j];
			}
		}

		// 임시 배열에서 원래 행렬로 다시 세로선을 기준으로 뒤집은 행렬을 넣어준다.
		for (int i = 0; i<arr.length; i++){
			for (int j = 0; j<arr[0].length; j++){
				arr[i][j] = temp[i][arr[0].length-j-1];
			}
		}
	}
}
