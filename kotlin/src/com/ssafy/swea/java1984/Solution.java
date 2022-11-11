// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pw_-KAdcDFAUq

package com.ssafy.swea.java1984;

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
			int max = 0, min = 10000, sum = 0; // 입력값의 최대값, 최소값, 총합
			// 입력을 받을 때마다 최대값, 최소값, 총합을 저장하고
			for (int i = 0; i<10; i++){
				int input = sc.nextInt();
				max = Math.max(max, input);
				min = Math.min(min, input);
				sum += input;
			}

			// 최대값과 최소값을 총합에서 뺀후 반올림을 한다.
			System.out.printf("#%d %d\n", test_case, Math.round(((double) sum-max-min)/8));
		}
	}
}
