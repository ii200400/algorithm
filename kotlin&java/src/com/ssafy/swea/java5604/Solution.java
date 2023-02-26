// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXGGNB6cnEDFAUo
// 참고 : https://www.slideshare.net/Baekjoon/baekjoon-online-judge-1019
// [Professional] 구간 합

// 비슷한 문제라고 하는 백준의 1019번 문제의 해답을 통해 해결하였다.
// 주석이 없는 이유는 설명이 너무 어려워서;; 그냥 참고 링크를 보자;;

// 어휴.. ans[x % 10] += point; 에서 point가 항상 1이라고 설명한 줄 알고 계속 이상하네? 하고 있었다.
// 정확히는.. 1이라고 말한 것이 아니라 딱히 언급이 없었다;

package com.ssafy.swea.java5604;

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
			long a = sc.nextLong();	// 시작 숫자
			long b = sc.nextLong();	// 끝 숫자자
			long[] ans = new long[10];	// 각 자리별로 출현 회수
			long point = 1;

			// 큰 숫자가 0이 되기 전까지 (큰 숫자까지 모두 계산이 끝날 때 까지)
			while(b > 0){
				while(a % 10 != 0 && a <= b){
					cal(a, ans, point);
					a++;
				}

				if (a > b)
					break;

				while(b % 10 != 9){
					cal(b, ans, point);
					b--;
				}

				a /= 10;
				b /= 10;

				long plus = (b-a+1)*point;
				for (int i = 0; i<10; i++){
					ans[i] += plus;
				}

				point *= 10;
			}

//			System.out.println(Arrays.toString(ans));
			long num = 0;
			for (int i = 1; i < 10; i++){
				num += i *ans[i];
			}

			System.out.printf("#%d %d%n", test_case, num);
		}
	}

	// 주어진 숫자의 각 자리수의 숫자 출현 회수 연산
	public static void cal(long x, long[] ans, long point) {
		while (x > 0) {
			ans[(int) (x % 10)] += point;
			x /= 10;
		}
	}

}
