// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIdD46A5EDFAXC

// 주어지는 문자열의 첫번째는 무조건 대문자 알파벳이니
// 그것만 탐색하면 된다.

// 아.. 코딩하다보니 다시 가독성이 떨어지는 코딩을 한다;;

package com.ssafy.swea.java7087;

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
			boolean[] hasAlphabet = new boolean[26];	// 첫 알파벳 존재 여부
			// 알파벳 여부 초기화
			for (int i = sc.nextInt(); i>0; i--) {
				int idx = sc.next().charAt(0) - 'A';
				hasAlphabet[idx] = true;
			}

			// 최대 문제 제목의 개수를 확인한다.
			int idx;
			for (idx = 0; idx < hasAlphabet.length; idx++){
				if (!hasAlphabet[idx])
					break;
			}

			// 최대 문제 제목의 개수 출력
			System.out.printf("#%d %d%n", test_case, idx);
		}
	}
}
