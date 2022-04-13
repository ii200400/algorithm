// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWksRkI6AR0DFAVE
// swea 승현이의 수학공부

// 뭔가 자연스럽게 각 자리수를 더해서 n-1로 나누면 될 것 같았는데
// 강의에서 진짜로 증명해주시는 것 보고 놀랐다..;

package com.ssafy.swea.java7193;

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
			int n = sc.nextInt();	// 진법
			String num = sc.next();	// 숫자인 문자
			int sum = 0;	// 위의 문자의 각 자리의 합
			for (int i = 0; i<num.length(); i++){
				sum += num.charAt(i) - '0';
			}

			// 각 자리의 합의 (n-1) 나머지 출력
			System.out.printf("#%d %d%n", test_case, sum%(n-1));
		}
	}
}
