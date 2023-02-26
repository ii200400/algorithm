// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc

// 그.. 뭐였지..? 탑에서 레이저쏘는 스택문제 생각난다.
// 스택이 필요하지는 않지만 역순으로 읽으면서 가장 큰 값이 나오면 저장해주고
// 그것보다 작은 값이 나오면 차이를 합산하면 될 것 같다.

package com.ssafy.swea.java1859;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine()); // 일 수
			int[] prices = new int[n];	// 매매가 배열

			// 매매가 배열 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i<n; i++){
				prices[i] = Integer.parseInt(st.nextToken());
			}

			int maxPrice = 0;	// 최대 매매가
			long profit = 0;	// 총 이익 (매매가를 더하다보면 21억이 넘을 수 있다.)
			// 매매가를 역순으로 살펴보면서
			for (int i = prices.length-1; i>=0; i--){
				// 현재까지의 최대 매매가보다 큰 값이 나오면
				if (maxPrice < prices[i]){
					// 해당 값을 넣어주고
					maxPrice = prices[i];
				}else{ // 작은 값이 나오면
					// 이익을 본다.
					profit += maxPrice - prices[i];
				}
			}

			// 총 이익을 출력한다.
			System.out.printf("#%d %d\n", test_case, profit);
		}
	}
}
