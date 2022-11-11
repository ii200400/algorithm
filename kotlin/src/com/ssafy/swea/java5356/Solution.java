// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVWgkP6sQ0DFAUO

// 아아 의석아.. 다음에는 글자 수 맞춰줘..
// 입력을 받아와서 가장 긴 문자열의 크기를 확인하고
// 새로운 배열을 위의 크기로 만들고 빈 곳은 빈문자열'' 로 넣어주면
// 그대로 출력만하면 된다는 계산이 나온다.

// 빈 문자열은 에러가 나서 '-'로 대체했다.

// 생각해보니 그냥 삼항연산자 사용하면 되는 것을 깨달아서 다 되돌리고
// 크기가 작으면 빈 문자열을 출력하도록 만들었다.

package com.ssafy.swea.java5356;

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
			char[][] input = new char[5][];	// 입력 알파벳
			int maxSize = 0;
			// 항상 5줄이 한 테스트 케이스 입력이므로
			for (int i = 0; i<5; i++){
				// 입력을 받아오면서
				input[i] = sc.next().toCharArray();
				// 가장 긴 문자열의 크기 저장
				maxSize = Math.max(maxSize, input[i].length);

			}

			// 테스트 케이스 출력
			System.out.printf("#%d ", test_case);
			// 문자들 출력
			for (int i = 0; i<maxSize; i++){
				for (int j = 0; j<5; j++){
					// 크기가 작으면 빈 문자열을, 아니면 가지고 있는 문자열을 출력한다.
					System.out.print(input[j].length-1 < i? "": input[j][i]);
				}
			}
			System.out.println();
		}
	}
}
