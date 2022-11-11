// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh

// 기수.. 정렬..?

package com.ssafy.swea.java1204;

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
			int[] numberFreq = new int[101];	// 각 숫자의 빈도 배열
			sc.nextInt();	// 사용하지 않는 변수
			// 숫자 빈도 초기화
			for (int i = 0; i<1000; i++){
				numberFreq[sc.nextInt()] += 1;
			}

			int mostFreq = 0, idx = 0;	// 최빈수의 빈도, 최빈수
			for (int i = 0; i<101; i++){
				// 최빈수를 숫자 빈도 배열에서 찾는다.
				// 최빈수가 많을 때는 가장 큰 점수를 출력해야하므로 <=
				if (mostFreq <= numberFreq[i]){
					idx = i;
					mostFreq = numberFreq[i];
				}
			}

			// 최빈수 출력
			System.out.printf("#%d %d\n", test_case, idx);
		}
	}
}
