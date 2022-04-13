// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGKdbqczEDFAUo
// 참고 블로그 : https://rebro.kr/105, https://st-lab.tistory.com/241
// swea [Professional] 조합

// 페르마의 소정리 라는 수학론을 알아야 해결이 가능한 문제라고 한다.
// 소수의 나머지 값을 구할 때만 사용할 수 있는 특이한 내용의 수학론이다.

// 알고보니 분할정복도 사용해야 한다고 해서 사용했는데 범위를 잘못 생각해서
// 블로그보고.. 도 몰라서 한참보고 다시 수정했다.

package com.ssafy.swea.java5607;

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
			int n = sc.nextInt();
			int r = sc.nextInt();
			int mod = 1234567891;

			// 분자의 나머지
			long answer = 1;
			for (int i = 2; i<=n; i++){
				answer = answer * i % mod;
			}
			// 분모의 나머지
			long bottom = 1;
			for (int i = 2; i<=r; i++){
				bottom = bottom * i % mod;
			}
			for (int i = 2; i<=n-r; i++){
				bottom = bottom * i % mod;
			}

			// 내가 사용한 분할정복
			int num = mod-2;
			long temp = bottom;
			for (long i = 29; i>=0; i--){
				bottom = bottom * bottom % 1234567891;
				if ((num & (1 << i)) > 0){
					bottom = bottom * temp % 1234567891;
				}
			}

			System.out.printf("#%d %d%n", test_case, answer * bottom % mod);

			// 블로그가 사용한 분할정복
//			long exp = mod-2;
//			long base = bottom;
//			long result = 1;
//			while(exp > 0){
//				if (exp % 2 == 1){
//					result = result * base % mod;
//				}
//
//				base = base * base % mod;
//				exp /= 2;
//			}
//
//			System.out.printf("#%d %d%n", test_case, answer * result % mod);
		}
	}
}
