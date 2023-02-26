// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWzaq5KKk_ADFAVU
// swea 원점으로 집합

// 더 빨리하고 싶다면 answer 값을 이진탐색으로 구하자!
// 1~n 총합이 maxNum보다 큰 가장 작은 값을 구하고 약간의 if-else문이나 for문이 필요하다.
// 본인은 계산이 만번을 넘지 않는다는 것을 보고 귀찮아서 안했다! ^ㅎ^

package com.ssafy.swea.java8458;

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
			int n = sc.nextInt();	// 수의 개수
			// 원점으로부터 가장 먼 점의 원점까지의 거리
			int maxNum = Math.abs(sc.nextInt()) + Math.abs(sc.nextInt());
			boolean isOdd = maxNum % 2 == 1;	// 점의 거리가 홀수인지 짝수인지 확인
			boolean flag = false;
			
			// maxNum, isOdd 초기화
			for (int i = 0; i<n-1; i++){
				int next = Math.abs(sc.nextInt()) + Math.abs(sc.nextInt());
				if ((next % 2 == 1) != isOdd){	// (점의 거리 % 2)가 하나라도 다르다면 -1
					flag = true;
				}

				// 원점으로부터 가장 먼 점이면 저장
				maxNum = Math.max(maxNum, next);
			}

			// 모든 점의 거리가 짝수 혹은 홀수가 아닌 경우 (거리가 짝수인 수와 홀수인 수가 섞여 있다면 원점으로 절대 못 모인다;)
			if (flag){
				System.out.printf("#%d %d%n", test_case, -1);
				continue;
			}

			// 예외처리 (아래의 연산으로 maxNum가 0인 경우는 못 계산한다.)
			if (maxNum == 0){
				System.out.printf("#%d %d%n", test_case, 0);
				continue;
			}

			int answer = 1;	// 답 저장 변수
			// 열심히 원점으로 움직이기
			// 이동거리가 0보다 작으면서 (원점을 지나치거나 도착), 짝수인 경우 원점 도착 (홀수이면 원점을 지나친 상태)
			for (answer = 1; maxNum > 0 || Math.abs(maxNum) % 2 == 1 ; answer++){
				maxNum -= answer;
			}
			answer--;	// 마지막에 더한 +1 제거
			// 정답 출력
			System.out.printf("#%d %d%n", test_case, answer);
		}
	}
}
