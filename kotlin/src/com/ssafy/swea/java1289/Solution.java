// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN

// 분명히.. 풀었던 것 같은데 파일이 없다..?

package com.ssafy.swea.java1289;

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
			String memory = sc.next();
			char c = '0';	// 이전 char 저장 변수
			int modifyNum = 0;	// 수정 횟수
			for (char bit: memory.toCharArray()){
				// 이전과 같은 값이면 패스
				if (c == bit)
					continue;

				// 그렇지 않다면 값을 저장하고
				c = bit;
				// 수정 횟수 +1을 한다.
				modifyNum++;
			}

			// modifyNum 출력
			System.out.printf("#%d %d\n", test_case, modifyNum);
		}
	}
}
