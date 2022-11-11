// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P1kNKAl8DFAUq

// 첫 문자부터 다른 문자를 차례대로 비교해서 다른 문자의 직전에 닿는지 보면된다.
// 3번만 반복하면 확실시 되기 때문에
// 최대 마디 길이가 10인 상황에서 제약사항에 문자열의 길이 30인 이유인 것 같다.

// 아.. 첫번째 테케를 역순으로 탐색하니 10이 나와서 다시 바꾸었다.
// 마디 길이를 큰 수가 아니라 작은 수부터 탐색하는 것으로 바꾸었다.

package com.ssafy.swea.java2007;

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
			// 값을 입력받고
			String input = sc.next();
			
			int i;	// 마디 길이
			// 마디를 짧게 잡고 점점 길게 생각하면서
			for (i = 1; i<=10; i++){
				boolean flag = true;	// 마디가 성립하는지 여부

				for (int j = 0; j<i; j++){
					// 마디 조건에 맞는지 살펴본다.
					if (input.charAt(j) != input.charAt(i+j) || input.charAt(j) != input.charAt(2*i+j)) {
						// 조건에 맞지 않는다면 false 처리 후 탈출
						flag = false;
						break;
					}
				}

				// 마디를 찾았다면 탈출한다.
				if (flag)
					break;
			}

			// 마디의 길이를 출력한다.
			System.out.printf("#%d %d\n", test_case, i);
		}
	}
}
