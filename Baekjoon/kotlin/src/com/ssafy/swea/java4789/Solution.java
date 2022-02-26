// 문제 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWS2dSgKA8MDFAVT

// 뭔가.. 느낌상? 값을 더해나가는데 이전 인덱스의 총합이 현재 인덱스의 값보다 작은만큼
// 고용해야할 것 같다.

// 아니 잠깐..... 마지막 문자는 0이 아니니까..
// 그냥 문자열의 길이 - 문자열의 각 숫자 합(마지막 제외) 이 0 미만인지 보면 되는건가???
// 아니네.. 0009001 의 경우에는 고용인이 3명 필요하다..

package com.ssafy.swea.java4789;

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
			String input = sc.next();

			int sum = 0, hire = 0;
			// 문자 하나씩 읽으면서 박수 인원을 계산한다.
			for (int i = 0; i<input.length(); i++){
				// 사람이 없으면 생략
				if (input.charAt(i) == '0')
					continue;

				// 기립박수의 조건이..
				int diff = sum - i;

				// 부족한 만큼 고용을 한다.
				if (diff < 0){
					hire -= diff;
					sum -= diff;
				}

				// 조건이 만족하면 현재 기립박수 하는 사람들을 추가한다.
				sum += input.charAt(i) - '0';
			}

			// 마지막 자리의 인덱스와 총합의 차이(고용된 인원)를 출력한다.
			System.out.printf("#%d %d\n", test_case, hire);
		}
	}
}
