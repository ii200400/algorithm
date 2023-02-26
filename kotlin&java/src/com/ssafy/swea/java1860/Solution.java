// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LsaaqDzYDFAXc

// 손님의 도착 시간을 정렬하고 탐색하면 될 것 같다.

package com.ssafy.swea.java1860;

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
			int n = sc.nextInt();	// 손님 수
			int m = sc.nextInt();	// k개 동시에 굽는데 걸리는 시간
			int k = sc.nextInt();	// 동시에 구울 수 있는 붕어빵 개수
			int[] visitTimes = new int[n];	// 손님들의 방문시간

			// 방문시간 초기화
			for (int i = 0; i<n; i++){
				visitTimes[i] = sc.nextInt();
			}
			// 정렬을 하면 연산이 쉬워지므로!
			Arrays.sort(visitTimes);

			boolean flag = true;	// 판매 가능 여부
			for (int idx = 0; idx< visitTimes.length; idx++){
				// 만든 붕어빵 수 - 팔린 붕어빵 수 = 남은 붕어빵 수 가 0개 이하(팔것이 없다면)
				if (visitTimes[idx]/m*k - idx <= 0){
					// 판매 가능 여부를 기록하고 반복문을 탈출한다.
					flag = false;
					break;
				}

			}

			// 판매 가능 여부 출력!
			System.out.printf("#%d %s%n", test_case, flag? "Possible":"Impossible");
		}
	}
}
