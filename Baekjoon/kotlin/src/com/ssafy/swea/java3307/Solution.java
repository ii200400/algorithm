// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr
// 최장 증가 부분 수열

// 이름 그대로 최장증가 부분수열을 구하는 문제
// 자바에 내장되어있는 이진탐색 사용방법을 알고싶어서 내장된 라이브러리로 사용했다.

package com.ssafy.swea.java3307;

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
			int n = sc.nextInt();
			int end = 0;	// lis 배열의 마지막 인덱스 (미포함)
			int[] lis = new int[n];
			for (int i = 0; i<n; i++) {
				int num = sc.nextInt();
				// 도데체 어떻게 나오는가 했더니..
				// 이진탐색으로 같은 숫자를 못 찾으면 들어갈만한 자리에 추가 연산(-(insertion point) - 1)를,
				// 찾으면 그대로 반환하는 것이었다.
				int insert = Arrays.binarySearch(lis, 0, end, num);
				if (insert < 0){	// 이진탐색으로 못 찾은 경우
					insert = (-insert)-1;
				}
				if (insert == end){	// 삽입하는 위치가 끝 위치라면 끝 부분 +1
					end++;
				}
				lis[insert] = num;
//				System.out.println(insert);
//				System.out.println(Arrays.toString(lis));
			}

			// lis 크기 출력
			System.out.printf("#%d %d%n", test_case, end);
		}
	}
}
